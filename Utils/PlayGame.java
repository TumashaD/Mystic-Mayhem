package Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Player.Player;
import Serialization.Serialization;
import Battle.Battle;

public class PlayGame extends Utils{
    public static void playGame(Player player){
        System.out.println(ORANGE+ Utils.initScreen+ RESET);
        int n ;
        if (players.size() == 0){
            System.out.print(YELLOW + Utils.firstPlayOptions + RESET);
            n = 2;
        }
        else {
            System.out.print(YELLOW + Utils.playOptions + RESET);
            n = 3;
        }
        int choice = getChoice(n);
        if (choice == 1 && n == 3){
            Utils.clearScreen();
            System.out.print(ORANGE + initScreen + RESET);
            SelectProfile.showProfiles();
        }

        if ((choice == 1 && n == 2) || (choice == 2 && n == 3)){ 
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
            mainMenu(player);}
    }

    public static void profileOptions(Player player){
        Scanner input = new Scanner(System.in);
        System.out.println(ORANGE + Utils.initScreen + RESET);
        System.out.print(YELLOW + Utils.profileOptions + RESET);
        int choice = getChoice(3);
        if (choice == 1) {
            Utils.clearScreen();
            Player oppponent = SelectProfile.showOpponents(player);
            Battle battle = new Battle(player, oppponent);
            System.out.println(battle.startBattle());
            System.out.print("Press Enter to continue...");
            input.nextLine();
            Utils.clearScreen();
            profileOptions(player);
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
