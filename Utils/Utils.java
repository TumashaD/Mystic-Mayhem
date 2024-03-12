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

    static String[] homeGrounds = {"Hillcrest", "Marshland", "Desert", "Arcane"};

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clear the screen
        System.out.flush();
    }
    public static void createProfile() {
        Scanner input = new Scanner(System.in);
        System.out.println(GREEN +"""
            ===========================================
            |           CREATE NEW PROFILE            |
            ===========================================
                """);
        System.out.print("Enter your name: ");
        String name = input.nextLine();

        System.out.print("Enter your username: ");
        String userName = input.nextLine();
        clearScreen();

        
        System.out.println("Select a home ground:");
        System.out.println("""
                [1] Hillcrest
                [2] Marshland
                [3] Desert
                [4] Arcane
                """);

        int homeGround = input.nextInt();

        while (homeGround < 1 || homeGround > 4) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            homeGround = input.nextInt();
        }
        
        Player player = new Player(name, userName, homeGrounds[homeGround-1]);
        
    }

    public static void startingScreen(){
        // ANSI escape codes
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String YELLOW = "\u001B[33m";
        final String BLUE = "\u001B[34m";
        final String ORANGE = "\u001B[38;5;208m";

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
        Utils.clearScreen();
        if (choice == 2){
            Utils.createProfile();
        }
    }

}
