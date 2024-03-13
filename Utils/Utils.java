package Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Player.Player;
import Serialization.Serialization;

public class Utils {
    //colours
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String ORANGE = "\u001B[38;5;208m";
    static final List<Player> players = Serialization.deserializing();

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clear the screen
        System.out.flush();
    }

    static final String initScreen = """
        ========================================================================================================================================
                    ███╗   ███╗██╗   ██╗███████╗████████╗██╗ ██████╗    ███╗   ███╗███████╗██╗   ██╗██╗  ██╗███████╗███╗   ███╗
                    ████╗ ████║╚██╗ ██╔╝██╔════╝╚══██╔══╝██║██╔════╝    ████╗ ████║██╔════╝╚██╗ ██╔╝██║  ██║██╔════╝████╗ ████║
                    ██╔████╔██║ ╚████╔╝ ███████╗   ██║   ██║██║         ██╔████╔██║█████╗   ╚████╔╝ ███████║█████╗  ██╔████╔██║
                    ██║╚██╔╝██║  ╚██╔╝  ╚════██║   ██║   ██║██║         ██║╚██╔╝██║██╔══╝    ╚██╔╝  ██╔══██║██╔══╝  ██║╚██╔╝██║
                    ██║ ╚═╝ ██║   ██║   ███████║   ██║   ██║╚██████╗    ██║ ╚═╝ ██║███████╗   ██║   ██║  ██║███████╗██║ ╚═╝ ██║
                    ╚═╝     ╚═╝   ╚═╝   ╚══════╝   ╚═╝   ╚═╝ ╚═════╝    ╚═╝     ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝
        ========================================================================================================================================
        """;

    static final String options = """
        Choose an option...

        [1] Play Game
        [2] Exit Game

        Enter Your Choice: """;

    static final String playOptions = """
        Choose an option...

        [1] Select Profile
        [2] Create Profile
        [3] Go Back

        Enter Your Choice: """;

    static final String profileOptions = """
        Choose an option...

        [1] Go to Battle
        [2] Customize Profile
        [3] Go Back

        Enter Your Choice: """;

    public static void mainMenu(Player player){
        Scanner input = new Scanner(System.in);      
        System.out.println(ORANGE + initScreen + RESET);
        System.out.print(YELLOW + options + RESET);
        int choice = input.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1) {
            PlayGame.playGame(player);
        }

        if (choice == 2){
            System.exit(0);
        }
        }
    
    public static void displayProfile(Player player){
        System.out.println(GREEN +"""
            ===========================================
            |               YOUR PROFILE              |
            ===========================================
                """);
        System.out.println("Name: " + player.getName());
        System.out.println("Username: " + player.getUserName());
        System.out.println("Home Ground: " + player.getHomeGround());
        System.out.println("XP: " + player.getXp());
        System.out.println("Coins: " + player.getCoins() + "\n");
    }

    public static void saveProfile(Player player, List<Player> players){
            players.add(player);
            boolean creation = Serialization.serializing(players);
            if (creation){
                System.out.println(GREEN + "Profile Saved Successfully!" + RESET);
            }
            else{
                System.out.println(RED + "Profile Save Failed!" + RESET);
            }
    }
    public static void updateProfile(Player player, List<Player> players){
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getUserName().equals(player.getUserName())){
                players.set(i, player);
                boolean creation = Serialization.serializing(players);
                if (creation){
                    System.out.println(GREEN + "Profile Updated Successfully!" + RESET);
                }
                else{
                    System.out.println(RED + "Profile Update Failed!" + RESET);
                }
            }
        }
    }

    public static void deleteProfile(Player player, List<Player> players){
        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getUserName().equals(player.getUserName())){
                players.remove(i);
                boolean creation = Serialization.serializing(players);
                if (creation){
                    System.out.println(GREEN + "Profile Deleted Successfully!" + RESET);
                }
                else{
                    System.out.println(RED + "Profile Delete Failed!" + RESET);
                }
            }
        }
    }

}

