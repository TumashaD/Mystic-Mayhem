package Utils;

import Player.Player;
import Serialization.Serialization;
import java.util.List;
import java.util.Scanner;

public class SelectProfile extends Utils{
    public static void showProfiles(){
        List<Player> players = Serialization.deserializing();
        for (int i = 0; i < players.size(); i++) {
            System.out.println(YELLOW+"[" + (i + 1) + "] " + players.get(i).getName());
        }
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
