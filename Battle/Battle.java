package Battle;

import Character.Character;
import Character.Healer.Healer;
import Player.Player;
import Serialization.Serialization;

import java.util.Collections;
import java.util.Comparator;
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

        this.player1.setPlayerBattleGround(this.battleGround);
        this.player2.setPlayerBattleGround(this.battleGround);
    }

    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
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
        
        for (int i = 0; i < 10; i++){

            if(player1_AttackList.size()==0){
                this.originalPlayer2.setXp(this.originalPlayer2.getXp() + 1);
                
                double exchange = 0.1*this.originalPlayer1.getCoins();
                this.originalPlayer2.setCoins(this.originalPlayer2.getCoins() + exchange);
                this.originalPlayer1.setCoins(this.originalPlayer1.getCoins() - exchange);

                String result = String.format("""
                        =============================================================
                        %s has lost to %s   
                        ============================================================= 
                        
                        Statics:
                        =============================================================
                        %s : %d +1 XP || %d + %d Gold Coins
                        -------------------------------------------------------------
                        %s : %d -%d Gold Coins
                        =============================================================
                        """, this.player1.getName(), this.player2.getName(),player2.getName(),player2.getXp(),player2.getCoins(),(int)exchange,player1.getName(),player1.getCoins(),(int)exchange);
                return Utils.ORANGE+result+Utils.RESET;
            }

            Character player1_Attacker = player1_AttackList.get(player1_Index); //player 1 attacker
            Character player2_Attacker = player2_AttackList.get(player2_Index); //player 2 attacker

            //player1 attack
            round++;
            System.out.println();
            // pause(2000);
              
            System.out.printf(Utils.YELLOW+"""
            =============================================================
            Round %d ----> Player %s is playing   
            """, round, this.player1.getName());
            System.out.println("-------------------------------------------------------------");
            // pause(2000);
            Character player2_Defender = player2_DefenceList.get(0);

                if (player1_Attacker instanceof Healer){
                    Character healingCharacter = Collections.min(player1_DefenceList, Comparator.comparingDouble(Character::getHealth));
                    player1_Attacker.attack(healingCharacter, 1);

                    System.out.println(player1_Attacker.getName() + " heals " + healingCharacter.getName());
                    System.out.println(healingCharacter.getName() + " health has increased to " + healingCharacter.getHealth());
                    System.out.println(Utils.YELLOW+"=============================================================");
                }
                else{
                    player1_Attacker.attack(player2_Defender, 1);

                System.out.println(player1_Attacker.getName() + " attacks " + player2_Defender.getName());

                if (player2_Defender.getHealth() <= 0){
                    player2_DefenceList.remove(player2_Defender);
                    player2_AttackList.remove(player2_Defender);

                    System.out.println(player2_AttackList);
                    
                    System.out.println(Utils.RED + player2_Defender.getName() + " is eliminated");
                    System.out.println(Utils.YELLOW+"=============================================================");
                }
                else{
                    System.out.println(player2_Defender.getName() + " has " + player2_Defender.getHealth() + " health left");
                    System.out.println(Utils.YELLOW+"=============================================================");
                }
            }
                //bonus attack
                if(player1_Attacker.getbonus_attack() > 0){

                    player2_Defender = player2_DefenceList.get(0);
                    System.out.printf(Utils.YELLOW+"""
                        =============================================================
                        Round %d ----> Player %s is playing Bonus attack   
                            """, round, this.player1.getName());
                    System.out.println("-------------------------------------------------------------");
                    player1_Attacker.attack(player2_Defender, 1);

                    System.out.println(player1_Attacker.getName() + " attacks " + player2_Defender.getName());

                    if (player2_Defender.getHealth() <= 0){
                        player2_DefenceList.remove(player2_Defender);
                        player2_AttackList.remove(player2_Defender);

                        System.out.println(player2_AttackList);

                        System.out.println(Utils.RED + player2_Defender.getName() + " is eliminated");
                        System.out.println(Utils.YELLOW+"=============================================================");
                    }
                    else{
                        System.out.println(player2_Defender.getName() + " has " + player2_Defender.getHealth() + " health left");
                        System.out.println(Utils.YELLOW+"=============================================================");
                    }
                    
                }
                if(player1_Attacker.getbonus_health() > 0){

                    System.out.printf(Utils.YELLOW+"""
                        =============================================================
                        Round %d ----> Player %s is playing    
                            """, round, this.player1.getName());
                    player1_Attacker.setHealth(player1_Attacker.getHealth()*1.1);;

                    System.out.println(player1_Attacker.getName() + " health increased " );

                  
                    System.out.println(player1_Attacker.getName() + " has " + player1_Attacker.getHealth() + " health left");
                    System.out.println(Utils.YELLOW+"=============================================================");
                    
                    
                }

        
            //update index
            if(player2_AttackList.size()>0){
                if (player2_Index >= player2_AttackList.size()){
                    player2_Index = 0;
                }else if (player2_Attacker == player2_AttackList.get(player2_Index) && player2_Index+1 < player2_AttackList.size()){
                    player2_Index++;
                }else if (player2_Index+1 == player2_AttackList.size()){
                    player2_Index = 0;
                }
            }

            round++;
            System.out.println();
            // pause(2000);
            
            if (player2_AttackList.size() > 0){
                System.out.printf(Utils.BLUE+"""
                =============================================================
                Round %d ----> Player %s is playing   
                        """, round, this.player2.getName());
                System.out.println("-------------------------------------------------------------");
                // pause(2000);
                Character player1_Defender = player1_DefenceList.get(0);
                
                if (player2_Attacker instanceof Healer){
                    Character healingCharacter = Collections.min(player2_DefenceList, Comparator.comparingDouble(Character::getHealth));
                    player2_Attacker.attack(healingCharacter, 1);

                    System.out.println(player2_Attacker.getName() + " heals " + healingCharacter.getName());
                    System.out.println(healingCharacter.getName() + " health has increased to " + healingCharacter.getHealth());
                    System.out.println(Utils.BLUE+"=============================================================");
                }
                else{
                    player2_Attacker.attack(player1_Defender, 1);

                    System.out.println(player2_Attacker.getName() + " attacks " + player1_Defender.getName());

                    if (player1_Defender.getHealth() <= 0){
                        player1_DefenceList.remove(player1_Defender);
                        player1_AttackList.remove(player1_Defender);

                        System.out.println(player1_AttackList);
                        System.out.println(Utils.RED + player1_Defender.getName() + " is eliminated");
                        System.out.println(Utils.BLUE+"=============================================================");
                    }
                    else{
                        System.out.println(player1_Defender.getName() + " has " + player1_Defender.getHealth() + " health left");
                        System.out.println(Utils.BLUE+"=============================================================");
                    }
                }
                //bonus attack
                if(player2_Attacker.getbonus_attack() > 0){
                    player1_Defender = player1_DefenceList.get(0);
                    System.out.printf(Utils.BLUE+"""
                        =============================================================
                        Round %d ----> Player %s is playing Bonus attack   
                            """, round, this.player2.getName());
                    System.out.println("-------------------------------------------------------------");
                    player2_Attacker.attack(player1_Defender, 1);

                    System.out.println(player2_Attacker.getName() + " attacks " + player1_Defender.getName());

                    if (player1_Defender.getHealth() <= 0){
                        player1_DefenceList.remove(player1_Defender);
                        player1_AttackList.remove(player1_Defender);

                        System.out.println(player1_AttackList);

                        System.out.println(Utils.RED + player1_Defender.getName() + " is eliminated");
                        System.out.println(Utils.BLUE+"=============================================================");
                    }
                    else{
                        System.out.println(player1_Defender.getName() + " has " + player1_Defender.getHealth() + " health left");
                        System.out.println(Utils.BLUE+"=============================================================");
                    }
                    
                }
                if(player2_Attacker.getbonus_health() > 0){

                    System.out.printf(Utils.BLUE+"""
                        =============================================================
                        Round %d ----> Player %s is playing    
                            """, round, this.player2.getName());
                    player2_Attacker.setHealth(player2_Attacker.getHealth()*1.1);;

                    System.out.println(player2_Attacker.getName() + " health increased " );

                  
                    System.out.println(player2_Attacker.getName() + " has " + player2_Attacker.getHealth() + " health left");
                    System.out.println(Utils.BLUE+"=============================================================");
                    
                    
                }
            }
            else{
                this.originalPlayer1.setXp(this.originalPlayer1.getXp() + 1);

                double exchange = 0.1*this.originalPlayer2.getCoins();
                this.originalPlayer1.setCoins(this.originalPlayer1.getCoins() + exchange);
                this.originalPlayer2.setCoins(this.originalPlayer2.getCoins() - exchange);

                String result = String.format("""
                        =============================================================
                        %s has lost to %s   
                        ============================================================= 
                        
                        Statics:
                        =============================================================
                        %s : %d +1 XP || %d + %d Gold Coins
                        -------------------------------------------------------------
                        %s : %d -%d Gold Coins
                        =============================================================
                        """, this.player2.getName(), this.player1.getName(),player1.getName(),player1.getXp(),player1.getCoins(),(int)exchange,player2.getName(),player2.getCoins(),(int)exchange);
                return Utils.ORANGE+result+Utils.RESET;
                
            }
            // update index
            if(player1_AttackList.size()>0){
                if (player1_Index >= player1_AttackList.size()){
                    player1_Index = 0;
                } else if (player1_Attacker == player1_AttackList.get(player1_Index) && player1_Index+1 < player1_AttackList.size()){
                    player1_Index++;
                } else if (player1_Index+1 == player1_AttackList.size()){
                    player1_Index = 0;
                }
            }


             
        
        }

        return Utils.ORANGE+"""
            \n===========================================
            |           MATCH IS A DRAW               |
            ===========================================
                    """+Utils.RESET;
    }

}
