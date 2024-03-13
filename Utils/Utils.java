package Utils;
import java.util.Scanner;

import Player.Player;


public class Utils {
    //colours
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String ORANGE = "\u001B[38;5;208m";

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clear the screen
        System.out.flush();
    }

    public static void mainMenu(Player player){
        Scanner input = new Scanner(System.in);
        String initScreen = """
            ========================================================================================================================================
                        ███╗   ███╗██╗   ██╗███████╗████████╗██╗ ██████╗    ███╗   ███╗███████╗██╗   ██╗██╗  ██╗███████╗███╗   ███╗
                        ████╗ ████║╚██╗ ██╔╝██╔════╝╚══██╔══╝██║██╔════╝    ████╗ ████║██╔════╝╚██╗ ██╔╝██║  ██║██╔════╝████╗ ████║
                        ██╔████╔██║ ╚████╔╝ ███████╗   ██║   ██║██║         ██╔████╔██║█████╗   ╚████╔╝ ███████║█████╗  ██╔████╔██║
                        ██║╚██╔╝██║  ╚██╔╝  ╚════██║   ██║   ██║██║         ██║╚██╔╝██║██╔══╝    ╚██╔╝  ██╔══██║██╔══╝  ██║╚██╔╝██║
                        ██║ ╚═╝ ██║   ██║   ███████║   ██║   ██║╚██████╗    ██║ ╚═╝ ██║███████╗   ██║   ██║  ██║███████╗██║ ╚═╝ ██║
                        ╚═╝     ╚═╝   ╚═╝   ╚══════╝   ╚═╝   ╚═╝ ╚═════╝    ╚═╝     ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚══════╝╚═╝     ╚═╝
            ========================================================================================================================================
            """;
        
        System.out.println(ORANGE + initScreen + RESET);
        
        String options = """
            Choose an option...

            [1] Play
            [2] Create Profile
            [3] Customize Profile
            [4] Exit

            Enter Your Choice: """;

        System.out.print(YELLOW + options + RESET);

        int choice = input.nextInt();
        while (choice < 1 || choice > 4) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 2) {
            player = CreateProfile.createProfile();
            Utils.clearScreen();

            Boolean isRunOut = CreateProfile.createArmy(input,player, false);
            Utils.clearScreen();

            while (isRunOut) {
                isRunOut = CreateProfile.createArmy(input,player, true);
                Utils.clearScreen();
            }
            System.out.println(GREEN + "Profile Created Successfully! \n");
            System.out.println(YELLOW + "You have " + player.getCoins() + " coins left. \n");
            mainMenu(player);
        }

        if (choice == 3) {
            Utils.clearScreen();
            CustomizeProfile.customizeProfile(player);
        }
        if (choice == 4){
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
}

