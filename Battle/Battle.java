package Battle;

import Character.Character;
import Player.Player;
import java.util.List;

public class Battle {
    private Player player1;
    private Player player2;

    public Battle(Player player1, Player player2){
        this.player1 = player1;
        this.player2 = player2;
    }

    public void startBattle(){
        System.out.println("Battle started between " + player1.getName() + " and " + player2.getName());
        

        List<Character> attackers_1 = player1.getAttackList();
        List<Character> attackers_2 = player2.getAttackList();

        List<Character> defenders_1 = player1.getDefenceList();
        List<Character> defenders_2 = player2.getDefenceList();

        int player1_remain = 5;
        int player2_remain = 5;
        int p1_i = 0;
        int p2_i = 0;

        while( player1_remain > 0 && player2_remain > 0){
            
               
            defenders_2.get(p2_i).attack(attackers_1.get(0).getAttack());
            if(defenders_2.get(p2_i).getHealth() <= 0){
                int i = 0;
                for(Character c : attackers_2){
                    
                    if(c.getName() == defenders_2.get(p2_i).getName()){
                        attackers_2.remove(i);
                        break;
                    }else{
                        i++;
                    }
                }
                player2_remain--;
                p2_i++;
            }

            defenders_1.get(p1_i).attack(attackers_2.get(0).getAttack());
            if(defenders_1.get(p1_i).getHealth() <= 0){
                int i = 0;
                for(Character c : attackers_1){
                    
                    if(c.getName() == defenders_1.get(p1_i).getName()){
                        attackers_1.remove(i);
                        break;
                    }else{
                        i++;
                    }
                }
                player1_remain--;
                p1_i++;
            }
                
                
            
        }



    }
}
