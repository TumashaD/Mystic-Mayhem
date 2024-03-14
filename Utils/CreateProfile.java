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
        System.out.println(GREEN +"""
            ===========================================
            |           CREATE NEW PROFILE            |
            ===========================================
                """ + RESET);
        System.out.print(YELLOW + "Enter your name: ");
        String name = getName();
        System.out.println();
        
        System.out.print(YELLOW+"Enter your username: ");
        String userName = getName();
        if (players.size() > 0){
            for (Player p : players){
                boolean isValidUsername = false;

                while (!isValidUsername) {
                    if (p.getUserName().equals(userName) || Utils.bossOpponent().getUserName().equals(userName)) {
                        System.out.println(RED + "Profile Already Exists!" + RESET);
                        System.out.print(YELLOW+"Enter a new username: ");
                        userName = getName();
                    } else {
                        isValidUsername = true;
                    }
                }
            }
        }
        System.out.println();

        System.out.println(YELLOW+"Select a home ground: \n");
        System.out.print("""
                [1] Hillcrest
                [2] Marshland
                [3] Desert
                [4] Arcane

                Your choice: """ );

        int homeGround = getChoice(4);
        Player player = new Player(name, userName, homeGrounds[homeGround-1]);
        return player;
        
    }

    public static Boolean createArmy(Player player, Boolean isRunOut) {
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
        
        for (String key : characters.keySet()) {
            Utils.clearScreen();
            CharacterTable.characterTable();
            System.out.println(YELLOW+"\nYou have " + gc + " gold coins to spend.\n"+RESET);
            System.out.println(ORANGE + "Select a " + key + ":\n" + RESET);
            String[] characterList = characters.get(key);
            for (int i = 0; i < characterList.length; i++) {
                System.out.println(ORANGE+" [" + (i+1) + "]" + characterList[i]);
            }
            System.out.print("\nYour choice: "+RESET);
            choice = getChoice(characterList.length);
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
            System.out.println();
            if (gc <= 0) {
                return true;
            }
        }
        player.setCoins(gc);
        return false;

    }
}
