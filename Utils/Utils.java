package Utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;
import Equipment.Equipment;
import Equipment.Armour.Armour;
import Equipment.Artifacts.Artifact;
import Player.Player;
import Serialization.Serialization;

public class Utils {
    //colours
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[38;5;81m";
    public static final String ORANGE = "\u001B[38;5;208m";
    public static final List<Player> players = Serialization.deserializing();

    public static void clearScreen() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
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

    static final String firstPlayOptions = """
        Choose an option...

        [1] Create Profile
        [2] Go Back

        Enter Your Choice: """;

    static final String profileOptions = """
        Choose an option...

        [1] Go to Battle
        [2] Customize Profile
        [3] Go Back

        Enter Your Choice: """;

    public static void mainMenu(Player player){
        System.out.println(ORANGE + initScreen + RESET);
        System.out.print(YELLOW + options + RESET);
        int choice = getChoice(2);
        if (choice == 1) {
            Utils.clearScreen();
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

    public static Player bossOpponent(){
        Player boss = new Player("GeraltofRivia","whitewolf","Marshland");
        boss.setXp((short) 32);
        boss.setCoins(215);
        Archer ranger = new Archer("Ranger");
        Knight squire = new Knight("Squire");
        Mage warlock = new Mage("Warlock");
        Healer medic = new Healer("Medic");
        MythicalCreature dragon = new MythicalCreature("Dragon");
        Armour chainmail = new Armour("Chainmail");
        Artifact amulet = new Artifact("Amulet");
        ranger.setArmour(chainmail);
        medic.setArtifact(amulet);

        boss.setArcher(ranger);
        boss.setKnight(squire);
        boss.setMage(warlock);
        boss.setHealer(medic);
        boss.setMythicalCreature(dragon);  
        return boss;
    }

    public static List<Player> playersWithBoss(){
        List<Player> playersCopy = new ArrayList<>(players);
        playersCopy.add(bossOpponent());
        return playersCopy;
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


    public static int getChoice(int n) {
        Scanner input = new Scanner(System.in);
        int choice;
        try {
            choice = input.nextInt();
            while (choice < 1 || choice > n) {
                System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
                choice = input.nextInt();
            }
        } catch (InputMismatchException e) {
            System.out.print(RED + "Invalid Input! Please enter a valid integer choice: " + RESET);
            input.nextLine();
            choice = getChoice(n); 
        }
        return choice;
    }

    public static String getName() {
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        if (name.length() == 0){
            System.out.print(RED + "Invalid Input! Please enter a valid name: " + RESET);
            name = getName();
        }
        return name;
    }
}

