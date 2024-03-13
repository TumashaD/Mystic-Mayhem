package Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Player.Player;
import Serialization.Serialization;

public class PlayGame extends Utils{
    public static void playGame(Player player){
        Scanner input = new Scanner(System.in);
        Utils.clearScreen();
        System.out.println(ORANGE+ Utils.initScreen+ RESET);
        System.out.print(YELLOW + Utils.playOptions + RESET);
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice ==1 ){
            Utils.clearScreen();
            System.out.println(ORANGE + Utils.initScreen + RESET);
            SelectProfile.showProfiles();
        }

        if (choice == 2) {
            Player newPlayer = CreateProfile.createProfile();
            Utils.clearScreen();
            
            Boolean isRunOut = CreateProfile.createArmy(newPlayer, false);
            Utils.clearScreen();
            
            while (isRunOut) {
                isRunOut = CreateProfile.createArmy(newPlayer, true);
                Utils.clearScreen();
            }
            System.out.println(YELLOW + "You have " + newPlayer.getCoins() + " coins left. \n");
            saveProfile(newPlayer, players);
            profileOptions(newPlayer);
        }
        if (choice == 3) {
            Utils.clearScreen();
            Utils.mainMenu(player);
        }
    }
    public static void profileOptions(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println(ORANGE + Utils.initScreen + RESET);
        System.out.print(YELLOW + Utils.profileOptions + RESET);
        int choice = input.nextInt();

        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }

        if (choice == 1) {
            
        }

        if (choice == 2){
            Utils.clearScreen();
            CustomizeProfile.customizeProfile(player);
        }
        if (choice == 3) {
            Utils.clearScreen();
            playGame(player);
        }
    }
}
