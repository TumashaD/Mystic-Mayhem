package Battle;

import Character.Character;
import Character.Healer.Healer;
import Player.Player;
import Serialization.Serialization;

import java.util.List;

import Utils.Utils;

public class Battle {
    private Player originalPlayer1;
    private Player originalPlayer2;

    private Player player1;
    private Player player2;
    private String battleGround;

    public Battle(Player challenger , Player defender){
        this.originalPlayer1 = challenger;
        this.originalPlayer2 = defender;
        this.battleGround = defender.getHomeGround();

        this.player1 = Serialization.deepCopy(challenger);
        this.player2 = Serialization.deepCopy(defender);

        this.player1.setBattleGround(this.battleGround);
        this.player2.setBattleGround(this.battleGround);
    }

    private static void pause(int milliseconds) {
        try {
            // Pause for 3 seconds (3000 milliseconds)
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // This part is executed if the sleep is interrupted
            System.err.println("Sleep was interrupted");
        }
    }

    public String startBattle(){
        System.out.printf(Utils.ORANGE+"""
            =============================================================
                %s vs %s   ||  Battle Ground: %s  
            =============================================================\n
                """, this.player1.getName(), this.player2.getName(),this.battleGround);
    
        List<Character> player1_AttackList= this.player1.getAttackers();
        List<Character> player1_DefenceList= this.player1.getDefenders();

        List<Character> player2_AttackList= this.player2.getAttackers();
        List<Character> player2_DefenceList= this.player2.getDefenders();


        int round = 0;
        int player1_Index = 0;
        int player2_Index = 0;

        pause(500);

        for (int i = 0; i < 5; i++){
            //player1 attack
            round++;
            System.out.println();
            pause(2000);
            System.out.printf(Utils.YELLOW+"""
                =============================================================
                Round %d ----> Player %s is playing   
                        """, round, this.player1.getName());
            System.out.println("-------------------------------------------------------------");
            pause(2000);
            Character player1_Attacker = player1_AttackList.get(player1_Index);

            if (player1_AttackList.size() > 0){
                Character player2_Defender = player2_DefenceList.get(0);

                if (player1_Attacker instanceof Healer){
                    player1_Attacker.attack(player1_DefenceList.get(0));

                    System.out.println(player1_Attacker.getName() + " heals " + player1_DefenceList.get(0).getName());
                    System.out.println(player1_DefenceList.get(0).getName() + " has " + player1_DefenceList.get(0).getHealth() + " health left");
                }
                else{
                    player1_Attacker.attack(player2_Defender);

                    System.out.println(player1_Attacker.getName() + " attacks " + player2_Defender.getName());

                    if (player2_Defender.getHealth() <= 0){
                        player2_DefenceList.remove(player2_Defender);
                        player2_AttackList.remove(player2_Defender);
                        System.out.println(Utils.RED + player2_Defender.getName() + " is eliminated");
                        System.out.println(Utils.YELLOW+"=============================================================");
                    }
                    else{
                        System.out.println(player2_Defender.getName() + " has " + player2_Defender.getHealth() + " health left");
                        System.out.println(Utils.YELLOW+"=============================================================");
                    }
                }
            } else{
                this.originalPlayer2.setXp(this.originalPlayer2.getXp() + 1);

                this.originalPlayer2.setCoins(this.originalPlayer2.getCoins() + 0.1*this.originalPlayer1.getCoins());
                this.originalPlayer1.setCoins(this.originalPlayer1.getCoins() - 0.1*this.originalPlayer1.getCoins());

                String result = String.format("""
                        =============================================================
                        %s has lost to %s   
                        =============================================================            
                        """, this.player1.getName(), this.player2.getName());
                return Utils.ORANGE+result+Utils.RESET;
            }

            round++;
            System.out.println();
            pause(2000);
            System.out.printf(Utils.BLUE+"""
                =============================================================
                Round %d ----> Player %s is playing   
                        """, round, this.player2.getName());
            System.out.println("-------------------------------------------------------------");
            pause(2000);
            Character player2_Attacker = player2_AttackList.get(player2_Index);
            if (player2_AttackList.size() > 0){
                Character player1_Defender = player1_DefenceList.get(0);

                if (player2_Attacker instanceof Healer){
                    player2_Attacker.attack(player2_DefenceList.get(0));

                    System.out.println(player2_Attacker.getName() + " heals " + player2_DefenceList.get(0).getName());
                    System.out.println(player2_DefenceList.get(0).getName() + " has " + player2_DefenceList.get(0).getHealth() + " health left");
                }
                else{
                    player2_Attacker.attack(player1_Defender);

                    System.out.println(player2_Attacker.getName() + " attacks " + player1_Defender.getName());

                    if (player1_Defender.getHealth() <= 0){
                        player1_DefenceList.remove(player1_Defender);
                        player1_AttackList.remove(player1_Defender);
                        System.out.println(Utils.RED + player1_Defender.getName() + " is eliminated");
                        System.out.println(Utils.BLUE+"=============================================================");
                    }
                    else{
                        System.out.println(player1_Defender.getName() + " has " + player1_Defender.getHealth() + " health left");
                        System.out.println(Utils.BLUE+"=============================================================");
                    }
                }
            }
            else{
                this.originalPlayer1.setXp(this.originalPlayer1.getXp() + 1);

                this.originalPlayer1.setCoins(this.originalPlayer1.getCoins() + 0.1*this.originalPlayer2.getCoins());
                this.originalPlayer2.setCoins(this.originalPlayer2.getCoins() - 0.1*this.originalPlayer2.getCoins());

                String result = String.format("""
                        =============================================================
                        %s has lost to %s   
                        =============================================================            
                        """, this.player2.getName(), this.player2.getName());
                return Utils.ORANGE+result+Utils.RESET;
                
            }

            // update index
            if (player1_Attacker == player1_AttackList.get(player1_Index)){
                player1_Index++;
            }
            if (player1_Index >= player1_AttackList.size()){
                player1_Index = 0;
            }

            if (player2_AttackList.get(player2_Index) == player2_Attacker){
                player2_Index++;
            }
            if (player2_Index >= player2_AttackList.size()){
                player2_Index = 0;
            }

             
        
        }

        return Utils.ORANGE+"""
            \n===========================================
            |           MATCH IS A DRAW               |
            ===========================================
                    """+Utils.RESET;
    }
}
