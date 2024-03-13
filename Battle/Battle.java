package Battle;

import Character.Character;
import Player.Player;
import java.util.List;

public class Battle {
    private Player challenger;
    private Player defender;

    public Battle(Player challenger , Player defender){
        this.challenger = challenger;
        this.defender = defender;
    }

    public void startBattle(){
        System.out.printf("""
            ===========================================
                        %s vs %s              
            ===========================================
                """, challenger.getName(), defender.getName());
    
        List<Character> challengerAttackList= challenger.getAttackers();
        List<Character> challengerDefenceList= challenger.getDefenders();

        List<Character> defenderAttackList= defender.getAttackers();
        List<Character> defenderDefenceList= defender.getDefenders();

    }
}
