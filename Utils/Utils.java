package Utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import Character.CharacterTable;
import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;
import Player.Player;
import Utils.CustomizeProfile;

public class Utils {
    //colours
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String ORANGE = "\u001B[38;5;208m";

    static String[] homeGrounds = {"Hillcrest", "Marshland", "Desert", "Arcane"};

    static Map<String,String[]> characters = new HashMap<String,String[]>(
        Map.of(
            "Archer", new String[]{"Shooter", "Ranger", "Sunfire", "Zing", "Saggitarius"},
            "Knight", new String[]{"Squire", "Cavalier", "Templar", "Zoro", "Swiftblade"},
            "Mage", new String[]{"Warlock", "Illutionist", "Enchanter", "Conjurer", "Eldritch"},
            "Healer", new String[]{"Soother", "Medic", "Alchemist", "Saint", "Lightbringer"},
            "MythicalCreature", new String[]{"Dragon", "Basillisk", "Hydra", "Phoenix", "Pegasus"}
        )
    );

    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clear the screen
        System.out.flush();
    }

    public static int mainScreen(Scanner input){

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
        return choice;

    }

    public static Player createProfile(Scanner input) {
        System.out.println(GREEN +"""
            ===========================================
            |           CREATE NEW PROFILE            |
            ===========================================
                """);
        System.out.println("Enter your name: ");
        String name = input.nextLine();
        
        System.out.println("Enter your username: ");
        String userName = input.nextLine();

        
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

        return player;
        
    }

    public static Boolean createArmy(Scanner input,Player player, Boolean isRunOut) {
        int gc = player.getCoins();
        int choice;
        System.out.println(ORANGE +"""
            ===========================================
            |           CREATE NEW ARMY               |
            ===========================================
                """);
        //Print Character Table
        CharacterTable.characterTable();

        if (isRunOut){
            System.out.println(RED + """
                ===========================================
                |           YOU"VE RUN OUT OF COINS        |
                ===========================================
            """ + ORANGE);
        }
        System.out.println("\nYou have " + gc + " gold coins to spend. \n");

        for (String key : characters.keySet()) {
            System.out.println(ORANGE + "Select a " + key + ":");
            String[] characterList = characters.get(key);
            for (int i = 0; i < characterList.length; i++) {
                System.out.println(" [" + (i+1) + "]" + characterList[i]);
            }
            System.out.print("Your choice: ");
            choice = input.nextInt();
            while (choice < 1 || choice > characterList.length) {
                System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
                choice = input.nextInt();
            }
            switch (key) {
                case "Archer":
                    Archer archer = new Archer(characterList[choice-1]);
                    player.setArcher(archer);
                    gc -= archer.getPrice();
                    break;
                case "Knight":
                    Knight knight = new Knight(characterList[choice-1]);
                    player.setKnight(knight);
                    gc -= knight.getPrice();
                    break;
                case "Mage":
                    Mage mage = new Mage(characterList[choice-1]);
                    player.setMage(mage);
                    gc -= mage.getPrice();
                    break;
                case "Healer":
                    Healer healer = new Healer(characterList[choice-1]);
                    player.setHealer(healer);
                    gc -= healer.getPrice();
                    break;
                case "MythicalCreature":
                    MythicalCreature mythicalCreature = new MythicalCreature(characterList[choice-1]);
                    player.setMythicalCreature(mythicalCreature);
                    gc -= mythicalCreature.getPrice();
                    break;
                default:
                    break;
            }
            System.out.println("\nYou have " + gc + " gold coins left.");
            if (gc <= 0) {
                return true;
            }
        }

        player.setCoins(gc);
        return false;

    }

}
