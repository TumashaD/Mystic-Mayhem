package Utils;

import Player.Player;
import Serialization.Serialization;
import java.util.List;

public class SelectProfile extends Utils{
    public static List<Player> playersCopy = playersWithBoss();

    public static void showProfiles(){
        List<Player> players = Serialization.deserializing();
        System.out.println(GREEN+"\nPlayers \n"+RESET);
        for (int i = 0; i < players.size(); i++) {
            System.out.println(YELLOW+"[" + (i + 1) + "] " + players.get(i).getName());
        }
        if (players.size() == 0){
            Utils.clearScreen();
            System.out.println(RED+"No profiles found!"+RESET);
            System.out.println("Create a profile to play the game");
            PlayGame.playGame(null);
        }
        else{
            System.out.print("\nChoose a profile: ");
            int choice = getChoice(players.size());
            Player selectedPlayer = players.get(choice - 1);
            Utils.clearScreen();
            PlayGame.profileOptions(selectedPlayer);
        }
    }
    public static int GenerateRandomIndex(List<Player> players){
        int randomIndex = (int) (Math.random() * players.size());
        return randomIndex;
    }

    public static Player showOpponents(Player player){
        System.out.println(YELLOW+"Your Opponent \n"+RESET);
        int randomIndex = GenerateRandomIndex(playersCopy);
        while (playersCopy.get(randomIndex).getName().equals(player.getName())) {
            randomIndex = GenerateRandomIndex(playersCopy);
        }
        Player opponent = playersCopy.get(randomIndex);
        System.out.println(RED + opponent.getName() + " (" + "XP: " + opponent.getXp() + ")" + RESET);
        System.out.println("\nArcher: " + opponent.getArcher().getName() +
                           "\nKnight: " + opponent.getKnight().getName() +
                           "\nMage: " + opponent.getMage().getName() +
                           "\nHealer: " + opponent.getHealer().getName() +
                           "\nMythical Creature: " + opponent.getMythicalCreature().getName());
        System.out.println(YELLOW+"\n [ 1 ] Battle Opponent " + "\n [ 2 ] Skip Opponent " + "\n [ 3 ] Exit ");
        System.out.print("\nEnter your choice: ");
        int choice = getChoice(3);
        if (choice == 2){
            Utils.clearScreen();
            playersCopy.remove(opponent);
            if (playersCopy.size() == 1){
                playersCopy = playersWithBoss();
            }
            opponent = showOpponents(player);  
        }
        else if (choice == 1){
            Utils.clearScreen();
            return opponent;
        }
        else if (choice == 3){
            Utils.clearScreen();
            PlayGame.profileOptions(player);
        }
        return opponent;
    }

}



