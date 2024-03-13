package Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.crypto.AEADBadTagException;

import java.util.List;

import Character.CharacterTable;
import Character.Archer.Archer;
import Character.Healer.Healer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.MythicalCreature.MythicalCreature;
import Player.Player;
import Serialization.Serialization;

public class CreateProfile extends Utils{

    static String[] homeGrounds = {"Hillcrest", "Marshland", "Desert", "Arcane"};

    static Map<String,String[]> characters = new HashMap<String,String[]>(
        Map.of(
            "Archer", new String[]{"Shooter", "Ranger", "Sunfire", "Zing", "Saggitarius"},
            "Knight", new String[]{"Squire", "Cavalier", "Templar", "Zoro", "Swiftblade"},
            "Mage", new String[]{"Warlock", "Illusionist", "Enchanter", "Conjurer", "Eldritch"},
            "Healer", new String[]{"Soother", "Medic", "Alchemist", "Saint", "Lightbringer"},
            "MythicalCreature", new String[]{"Dragon", "Basilisk", "Hydra", "Phoenix", "Pegasus"}
        )
    );
    public static Player createProfile() {
        Utils.clearScreen();
        Scanner input = new Scanner(System.in);
        System.out.println(GREEN +"""
            ===========================================
            |           CREATE NEW PROFILE            |
            ===========================================
                """ + RESET);
        System.out.print(YELLOW + "Enter your name: ");
        String name = input.nextLine();
        System.out.println();
        
        System.out.print("Enter your username: ");
        String userName = input.nextLine();
        if (players.size() > 0){
            for (Player p : players){
                boolean isValidUsername = false;

                while (!isValidUsername) {
                    if (p.getUserName().equals(userName) || Utils.bossOpponent().getUserName().equals(userName)) {
                        System.out.println(RED + "Profile Already Exists!" + RESET);
                        System.out.print(YELLOW+"Enter a new username: ");
                        userName = input.nextLine();
                    } else {
                        isValidUsername = true;
                    }
                }
            }
        }
        System.out.println();

        System.out.println("Select a home ground:");
        System.out.println("""
                [1] Hillcrest
                [2] Marshland
                [3] Desert
                [4] Arcane

                Your choice:
                """ );

        int homeGround = input.nextInt();

        while (homeGround < 1 || homeGround > 4) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            homeGround = input.nextInt();
        }
        Player player = new Player(name, userName, homeGrounds[homeGround-1]);
        return player;
        
    }

    public static Boolean createArmy(Player player, Boolean isRunOut) {
        Scanner input = new Scanner(System.in);
        int gc = player.getCoins();
        int choice;
        System.out.println(ORANGE +"""                            
                                            ===========================================
                                            |           CREATE NEW ARMY               |
                                            ===========================================
                """ + RESET);
        //Print Character Table
        CharacterTable.characterTable();

        if (isRunOut){
            System.out.println(RED + """
                ===========================================
                |           YOU"VE RUN OUT OF COINS        |
                ===========================================
            """ + YELLOW);
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
            System.out.println(YELLOW+"\nYou have " + gc + " gold coins left."+RESET);
            System.out.println();
            if (gc <= 0) {
                return true;
            }
        }
        player.setCoins(gc);
        return false;

    }
}
