package Battle;

import Character.Character;
import Character.Healer.Healer;
import Player.Player;
import java.util.List;

public class Battle {
    private Player player1;
    private Player player2;

    public Battle(Player challenger , Player defender){
        this.player1 = challenger;
        this.player2 = defender;
    }

    public String startBattle(){
        System.out.printf("""
            ===========================================
                        %s vs %s              
            ===========================================
                """, this.player1.getName(), this.player2.getName());
    
        List<Character> player1_AttackList= this.player1.getAttackers();
        List<Character> player1_DefenceList= this.player1.getDefenders();

        List<Character> player2_AttackList= this.player2.getAttackers();
        List<Character> player2_DefenceList= this.player2.getDefenders();

        //test
        System.out.println("Player 1");
        System.out.println(player1_AttackList);
        System.out.println(player1_DefenceList);
        System.out.println("Player 2");
        System.out.println(player2_AttackList);
        System.out.println(player2_DefenceList);

        int round = 0;
        int player1_Index = 0;
        int player2_Index = 0;


        for (int i = 0; i < 5; i++){
            //player1 attack
            round++;
            System.out.println("\nRound " + round + " ----> Player" + this.player1.getName() + " is playing");
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
                        System.out.println(player2_Defender.getName() + " is eliminated");
                    }
                    else{
                        System.out.println(player2_Defender.getName() + " has " + player2_Defender.getHealth() + " health left");
                    }
                }
            } else{
                return "Player " + this.player1.getName() + " has lost to Player " + this.player2.getName();
            }

            round++;
            System.out.println("\nRound " + round + " ----> Player" + this.player2.getName() + " is playing");
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
                        System.out.println(player1_Defender.getName() + " is eliminated");
                    }
                    else{
                        System.out.println(player1_Defender.getName() + " has " + player1_Defender.getHealth() + " health left");
                    }
                }
            }
            else{
                return "Player " + this.player2.getName() + " has lost to Player " + this.player1.getName();   
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

        return "Match is a draw";
    }
}
