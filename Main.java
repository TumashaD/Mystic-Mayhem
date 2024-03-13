
import Battle.Battle;
import Character.Archer.Archer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.Healer.Healer;
import Character.MythicalCreature.MythicalCreature;
import Player.Player;

public class Main {
    public static void main(String[] args) {      
        // Player player = null;
        // Utils.mainMenu(player);

        Player player1 = new Player("Player1", "player1", "Hillcrest");
        Player player2 = new Player("Player2", "player2", "Marshland");

        player1.setArcher(new Archer("Shooter"));
        player2.setArcher(new Archer("Shooter"));

        player1.setKnight(new Knight("Squire"));
        player2.setKnight(new Knight("Squire"));

        player1.setHealer(new Healer("Soother"));
        player2.setHealer(new Healer("Soother"));

        player1.setMage(new Mage("Warlock"));
        player2.setMage(new Mage("Warlock"));

        player1.setMythicalCreature(new MythicalCreature("Dragon"));
        player2.setMythicalCreature(new MythicalCreature("Dragon"));

        Battle battle = new Battle(player1, player2);
        System.out.println(battle.startBattle());
        

    }
}