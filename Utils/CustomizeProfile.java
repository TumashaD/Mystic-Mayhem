package Utils;

import java.util.Scanner;
import Player.Player;
import Character.CharacterTable;
import Character.Archer.Archer;
import Character.Knight.Knight;
import Character.Mage.Mage;
import Character.Healer.Healer;
import Character.MythicalCreature.MythicalCreature;
import Equipment.Equipment;
import Equipment.EquipmentTable;
import Equipment.Armour.Armour;
import Equipment.Artifacts.Artifact;
import Character.Character;
import java.util.List;
import Serialization.Serialization;

public class CustomizeProfile extends Utils{
    
    public static Player customizeProfile(Player player){
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        String title = (BLUE +"""
            ===========================================
            |           CUSTOMIZE PROFILE             |
            ===========================================
                """ + RESET);
        String options = ( YELLOW + """
            Choose an option... 

            [1] Your Profile
            [2] Your Characters
            [3] Go Back

            Enter Your Choice: """ + RESET);

        System.out.print(title+ options);

        int choice = input.nextInt();
        
        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        Utils.clearScreen();
        if (choice == 1){
            Utils.displayProfile(player);
            System.out.print(BLUE+"Choose an option... \n[1] Change Name \n[2] Delete Profile \n[3] Go Back\nEnter Your Choice:"+RESET);
            int option = input.nextInt();
            if (option == 1){
                String changeName = ("\n"+ YELLOW + "Enter your new name: " + RESET);
                System.out.print(changeName);
                String newName = input2.nextLine();
                player.setName(newName);
                Utils.clearScreen();
                System.out.print(GREEN+"Your name has been changed to " + newName + "\n" + RESET);
                updateProfile(player, players);
                customizeProfile(player);
            }
            if (option == 2){
                Utils.clearScreen();
                System.out.print(RED+"Are you sure you want to delete your profile? (Y/N): "+RESET);
                String delete = input2.nextLine();
                if (delete.equals("Y") || delete.equals("y")){
                    deleteProfile(player, players);
                    Utils.mainMenu(player);
                } else {
                    Utils.clearScreen();
                    customizeProfile(player);
                }
            }
            if (option == 3){
                Utils.clearScreen();
                customizeProfile(player);
            }
        }
        if (choice == 2){
            yourCharacters(player);
        }
        if (choice == 3){
            PlayGame.profileOptions(player);
        }

        return player;
    }
    public static void yourCharacters(Player player){
        Scanner input = new Scanner(System.in);
        player.displayCharacters();
        String options = ( YELLOW + """
            Choose an option... 

            [1] Buy New Characters
            [2] Buy Equipments
            [3] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        if (choice == 2){
            Utils.clearScreen();
            player.displayCharacters();
            chooseCharacter(player);
        }
        if (choice == 3){
            Utils.clearScreen();
            customizeProfile(player);
        }

    }

    public static void buyCharacter(Player player){
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( YELLOW + """
            Choose an option... 

            [1] Buy Archer
            [2] Buy Knight
            [3] Buy Mage
            [4] Buy Healer
            [5] Buy Mythical Creature
            [6] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        System.out.println();
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        CharacterTable.characterTable();
        if (choice == 1){
            while(isBought == false){
                isBought = buyArcher(player);
                if (isBought){
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(GREEN+"You have successfully bought an Archer!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyCharacter(player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 2){
            while(isBought == false){
                isBought = buyKnight(player);
                if (isBought){
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(GREEN+"You have successfully bought a Knight!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyCharacter(player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 3){
            while(isBought == false){
                isBought = buyMage(player);
                if (isBought){
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(GREEN+"You have successfully bought a Mage!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyCharacter(player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 4){
            while(isBought == false){
                isBought = buyHealer(player);
                if (isBought){
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(GREEN+"You have successfully bought a Healer!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyCharacter(player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 5){
            while(isBought == false){
                isBought = buyMythicalCreature(player);
                if (isBought){
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(GREEN+"You have successfully bought a Mythical Creature!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyCharacter(player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    CharacterTable.characterTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 6){
            Utils.clearScreen();
            yourCharacters(player);
        }

    }

    public static boolean buyArcher(Player player) {
        int n;
        if (player.getArcher().getName().equals("Shooter")) {
            n = 1;
        }
        else if (player.getArcher().getName().equals("Ranger")) {
            n = 2;
        }
        else if (player.getArcher().getName().equals("Sunfire")) {
            n = 3;
        }
        else if (player.getArcher().getName().equals("Zing")) {
            n = 4;
        }
        else if (player.getArcher().getName().equals("Saggitarius")) {
            n = 5;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = (ORANGE + """
            Choose an option... 

            [1] Buy Shooter
            [2] Buy Ranger
            [3] Buy Sunfire
            [4] Buy Zing
            [5] Buy Saggitarius
            [6] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 6 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Archer! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1) {
            // Buy Shooter
            isBought = player.buyArcher(new Archer("Shooter"));
        } else if (choice == 2) {
            // Buy Ranger
            isBought = player.buyArcher(new Archer("Ranger"));
        } else if (choice == 3) {
            // Buy Sunfire
            isBought = player.buyArcher(new Archer("Sunfire"));
        } else if (choice == 4) {
            // Buy Zing
            isBought = player.buyArcher(new Archer("Zing"));
        } else if (choice == 5) {
            // Buy Saggitarius
            isBought = player.buyArcher(new Archer("Saggitarius"));
        } else if (choice == 6) {
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        return isBought;
    }
    

    public static boolean buyKnight(Player player){
        int n;
        if (player.getKnight().getName().equals("Squire")) {
            n = 1;
        }
        else if (player.getKnight().getName().equals("Cavalier")) {
            n = 2;
        }
        else if (player.getKnight().getName().equals("Templar")) {
            n = 3;
        }
        else if (player.getKnight().getName().equals("Zoro")) {
            n = 4;
        }
        else if (player.getKnight().getName().equals("Swiftblade")) {
            n = 5;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Squire
            [2] Buy Cavalier
            [3] Buy Templar
            [4] Buy Zoro
            [5] Buy Swiftblade
            [6] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 6 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Knight! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1 && !player.getKnight().getName().equals("Squire")) {
            // Buy Squire
            isBought = player.buyKnight(new Knight("Squire"));
        }
        if (choice == 2 && !player.getKnight().getName().equals("Cavalier")){
            // Buy Cavalier
            isBought = player.buyKnight(new Knight("Cavalier"));
        }
        if (choice == 3){
            // Buy Templar
            isBought = player.buyKnight(new Knight("Templar"));
        }
        if (choice == 4){
            // Buy Zoro
            isBought = player.buyKnight(new Knight("Zoro"));
        }
        if (choice == 5){
            // Buy Swiftblade
            isBought = player.buyKnight(new Knight("Swiftblade"));
        }
        if (choice == 6){
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        return isBought;
    }

    // The mages are Warlock, Illusionist, Enchanter, Conjurer and Eldritch
    public static boolean buyMage(Player player){
        int n;
        if (player.getMage().getName().equals("Warlock")) {
            n = 1;
        }
        else if (player.getMage().getName().equals("Illusionist")) {
            n = 2;
        }
        else if (player.getMage().getName().equals("Enchanter")) {
            n = 3;
        }
        else if (player.getMage().getName().equals("Conjurer")) {
            n = 4;
        }
        else if (player.getMage().getName().equals("Eldritch")) {
            n = 5;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Warlock
            [2] Buy Illusionist
            [3] Buy Enchanter
            [4] Buy Conjurer
            [5] Buy Eldritch
            [6] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 6 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Mage! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Warlock
            isBought = player.buyMage(new Mage("Warlock"));
        }
        if (choice == 2){
            // Buy Illusionist
            isBought = player.buyMage(new Mage("Illusionist"));
        }
        if (choice == 3){
            // Buy Enchanter
            isBought = player.buyMage(new Mage("Enchanter"));
        }
        if (choice == 4){
            // Buy Conjurer
            isBought = player.buyMage(new Mage("Conjurer"));
        }
        if (choice == 5){
            // Buy Eldritch
            isBought = player.buyMage(new Mage("Eldritch"));
        }
        if (choice == 6){
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        return isBought;
    }

    // The healers are Soother, Medid, Alchemist, Saint and Lightbringer
    public static boolean buyHealer(Player player){
        int n;
        if (player.getHealer().getName().equals("Soother")) {
            n = 1;
        }
        else if (player.getHealer().getName().equals("Medid")) {
            n = 2;
        }
        else if (player.getHealer().getName().equals("Alchemist")) {
            n = 3;
        }
        else if (player.getHealer().getName().equals("Saint")) {
            n = 4;
        }
        else if (player.getHealer().getName().equals("Lightbringer")) {
            n = 5;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Soother
            [2] Buy Medid
            [3] Buy Alchemist
            [4] Buy Saint
            [5] Buy Lightbringer
            [6] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 6 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Healer! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Soother
            isBought = player.buyHealer(new Healer("Soother"));
        }
        if (choice == 2){
            // Buy Medid
            isBought = player.buyHealer(new Healer("Medid"));
        }

        if (choice == 3){
            // Buy Alchemist
            isBought = player.buyHealer(new Healer("Alchemist"));
        }
        if (choice == 4){
            // Buy Saint
            isBought = player.buyHealer(new Healer("Saint"));
        }
        if (choice == 5){
            // Buy Lightbringer
            isBought = player.buyHealer(new Healer("Lightbringer"));
        }
        if (choice == 6){
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        return isBought;
    }

    // The mythical creatures are Dragon, Basilisk, Hydra, Phoenix, and Pegasus
    public static boolean buyMythicalCreature(Player player){
        int n;
        if (player.getMythicalCreature().getName().equals("Dragon")) {
            n = 1;
        }
        else if (player.getMythicalCreature().getName().equals("Basilisk")) {
            n = 2;
        }
        else if (player.getMythicalCreature().getName().equals("Hydra")) {
            n = 3;
        }
        else if (player.getMythicalCreature().getName().equals("Phoenix")) {
            n = 4;
        }
        else if (player.getMythicalCreature().getName().equals("Pegasus")) {
            n = 5;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Dragon
            [2] Buy Basilisk
            [3] Buy Hydra
            [4] Buy Phoenix
            [5] Buy Pegasus
            [6] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 6 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Mythical Creature! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Dragon
            isBought = player.buyMythicalCreature(new MythicalCreature("Dragon"));
        }
        if (choice == 2){
            // Buy Basilisk
            isBought = player.buyMythicalCreature(new MythicalCreature("Basilisk"));
        }
        if (choice == 3){
            // Buy Hydra
            isBought = player.buyMythicalCreature(new MythicalCreature("Hydra"));
        }
        if (choice == 4){
            // Buy Phoenix
            isBought = player.buyMythicalCreature(new MythicalCreature("Phoenix"));
        }
        if (choice == 5){
            // Buy Pegasus
            isBought = player.buyMythicalCreature(new MythicalCreature("Pegasus"));
        }
        if (choice == 6){
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        return isBought;
    }

    public static void chooseCharacter(Player player){
        Scanner input = new Scanner(System.in);
        String character = (BLUE + """
                Choose your Character... 

                [1] Archer:  """  + player.getArcher().getName() + "\n" +"""
                [2] Knight:  """ + player.getKnight().getName()  + "\n" +"""
                [3] Mage:  """ + player.getMage().getName() + "\n" +"""
                [4] Healer:  """ +  player.getHealer().getName() +  "\n" +"""
                [5] Mythical Creature:  """ +  player.getMythicalCreature().getName() + "\n"+ """
                [6] Go Back

                Enter Your Choice:""" + RESET);

        System.out.print(character);
        int choice = input.nextInt();

        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            EquipmentTable.equipmentTable();
            buyEquipment(player.getArcher(), player);
        }
        if (choice == 2){
            EquipmentTable.equipmentTable();
            buyEquipment(player.getKnight(), player);
        }
        if (choice == 3){
            EquipmentTable.equipmentTable();
            buyEquipment(player.getMage(), player);
        }
        if (choice == 4){
            EquipmentTable.equipmentTable();
            buyEquipment(player.getHealer(), player);
        }
        if (choice == 5){
            EquipmentTable.equipmentTable();
            buyEquipment(player.getMythicalCreature(), player);
        }
        if (choice == 6){
            Utils.clearScreen();
            yourCharacters(player);
        }
    }

    public static void buyEquipment(Character character, Player player){
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( YELLOW + """
    Choose an option... 
        
    [1] Buy Armour
    [2] Buy Artifact
    [3] Go Back
        
    Enter Your Choice: """ + RESET);
        System.out.print("Character: " + character.getName() + "\n");
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 5) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            while(isBought == false){
                isBought = buyArmour(character,player);
                if (isBought){
                    Utils.clearScreen();
                    EquipmentTable.equipmentTable();
                    System.out.println(GREEN+"You have successfully bought an Armour!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyEquipment(character, player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    EquipmentTable.equipmentTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 2){
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            while(isBought == false){
                isBought = buyArtifact(character,player);
                if (isBought){
                    EquipmentTable.equipmentTable();
                    System.out.println(GREEN+"You have successfully bought an Artifact!" + RESET);
                    updateProfile(player, players);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                    buyEquipment(character, player);
                    isBought = true;
                }
                else{
                    Utils.clearScreen();
                    EquipmentTable.equipmentTable();
                    System.out.println(RED+"\nYou don't have enough coins!" + RESET);
                    System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
                }
            }
        }
        if (choice == 3){
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            yourCharacters(player);
        }
    }

    // The armours are Chainmail, Regalia, and Fleece
    public static boolean buyArmour(Character character, Player player){
        int n;
        if (character.getArmourName().equals("Chainmail")) {
            n = 1;
        }
        else if (character.getArmourName().equals("Regalia")) {
            n = 2;
        }
        else if (character.getArmourName().equals("Fleece")) {
            n = 3;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Chainmail
            [2] Buy Regalia
            [3] Buy Fleece
            [4] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        System.out.println();
        while (choice < 1 || choice > 4 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Armour! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Chainmail
            Armour chainmail = new Armour("Chainmail");
            isBought = player.buyEquipment(chainmail);
            if (isBought){
                character.setArmour(chainmail);
            }
        }
        if (choice == 2){
            // Buy Regalia
            Armour regalia = new Armour("Regalia");
            isBought = player.buyEquipment(regalia);
            if (isBought){
                character.setArmour(regalia);
            }
        }
        if (choice == 3){
            // Buy Fleece
            Armour fleece = new Armour("Fleece");
            isBought = player.buyEquipment(fleece);
            if (isBought){
                character.setArmour(fleece);
            }
        }
        if (choice == 4){
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            buyEquipment(character, player);
        }
        return isBought;
    }

    // THe artifacts are Excalibur, Amulet, and Crystal

    public static boolean buyArtifact(Character character, Player player){
        int n;
        if (character.getArtifactName().equals("Excalibur")) {
            n = 1;
        }
        else if (character.getArtifactName().equals("Amulet")) {
            n = 2;
        }
        else if (character.getArtifactName().equals("Crystal")) {
            n = 3;
        }
        else {
            n = 0;
        }
        boolean isBought = false;
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Excalibur
            [2] Buy Amulet
            [3] Buy Crystal
            [4] Go Back

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 4 || choice == n) {
            if (choice == n) {
                System.out.print(RED + "You already have this Artifact! Please enter a valid choice: " + RESET);
            }
            else {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            }
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Excalibur
            Artifact excalibur = new Artifact("Excalibur");
            isBought = player.buyEquipment(excalibur);
            if (isBought){
                character.setArtifact(excalibur);
            }
        }
        if (choice == 2){
            // Buy Amulet
            Artifact amulet = new Artifact("Amulet");
            isBought = player.buyEquipment(amulet);
            if (isBought){
                character.setArtifact(amulet);
            }
        }
        if (choice == 3){
            // Buy Crystal
            Artifact crystal = new Artifact("Crystal");
            isBought = player.buyEquipment(crystal);
            if (isBought){
                character.setArtifact(crystal);
            }
        }
        if (choice == 4){
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            buyEquipment(character, player);
        }
        return isBought;
    }
}
