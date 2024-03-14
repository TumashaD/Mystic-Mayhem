package Utils;

import Player.Player;
import Serialization.Serialization;
import java.util.List;
import java.util.Scanner;

public class SelectProfile extends Utils{
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
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            while (choice < 1 || choice > players.size()) {
                System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
                choice = input.nextInt();
            }
            Player selectedPlayer = players.get(choice - 1);
            Utils.clearScreen();
            PlayGame.profileOptions(selectedPlayer);
        }
    }

    public static Player showOpponents(Player player){
        List<Player> players = Serialization.deserializing();
        System.out.println(GREEN+"Choose an opponent \n"+RESET);
        for (int i = 0; i < players.size(); i++) {
            if (!players.get(i).getName().equals(player.getName())) {
                System.out.println(YELLOW+"[" + (i + 1) + "] " + players.get(i).getName() + " : " + "XP = " + players.get(i).getXp()) ;
            }
        }
        System.out.println(YELLOW + "[" + (players.size()+1) + "] " + Utils.bossOpponent().getName() +" : " + "XP = " + Utils.bossOpponent().getXp()+ RESET);
        System.out.print("\nEnter your choice: ");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        while (choice < 1 || choice > players.size()+1) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        Player selectedOpponent;
        if (choice == players.size()+1){
            selectedOpponent = Utils.bossOpponent();
        }
        else{
            selectedOpponent = players.get(choice - 1);
        }
        Utils.clearScreen();
        return selectedOpponent;
    }

}

