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
            chooseCharacter(player);
        }
        if (choice == 3){
            Utils.clearScreen();
            customizeProfile(player);
        }

    }

    public static void buyCharacter(Player player){
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
        if (choice == 1){
            buyArcher(player);
            System.out.println(GREEN+"You have successfully bought an Archer!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        if (choice == 2){
            buyKnight(player);
            System.out.println(GREEN+"You have successfully bought a Knight!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        if (choice == 3){
            buyMage(player);
            System.out.println(GREEN+"You have successfully bought a Mage!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        if (choice == 4){
            buyHealer(player);
            System.out.println(GREEN+"You have successfully bought a Healer!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        if (choice == 5){
            buyMythicalCreature(player);
            System.out.println(GREEN+"You have successfully bought a Mythical Creature!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            CharacterTable.characterTable();
            buyCharacter(player);
        }
        if (choice == 6){
            Utils.clearScreen();
            yourCharacters(player);
        }

    }

    public static void buyArcher(Player player){
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
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
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Shooter
            player.buyArcher(new Archer("Shooter"));
        }
        if (choice == 2){
            // Buy Ranger
            player.buyArcher(new Archer("Ranger"));
        }
        if (choice == 3){
            // Buy Sunfire
            player.buyArcher(new Archer("Sunfire"));
        }
        if (choice == 4){
            // Buy Zing
            player.buyArcher(new Archer("Zing"));
        }
        if (choice == 5){
            // Buy Saggitarus
            player.buyArcher(new Archer("Saggitarius"));
        }
        if (choice == 6){
            Utils.clearScreen();
            buyCharacter(player);
        }
    }

    public static void buyKnight(Player player){
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
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Squire
            player.buyKnight(new Knight("Squire"));
        }
        if (choice == 2){
            // Buy Cavalier
            player.buyKnight(new Knight("Cavalier"));
        }
        if (choice == 3){
            // Buy Templar
            player.buyKnight(new Knight("Templar"));
        }
        if (choice == 4){
            // Buy Zoro
            player.buyKnight(new Knight("Zoro"));
        }
        if (choice == 5){
            // Buy Swiftblade
            player.buyKnight(new Knight("Swiftblade"));
        }
        if (choice == 6){
            Utils.clearScreen();
            buyCharacter(player);
        }
    }

    // The mages are Warlock, Illusionist, Enchanter, Conjurer and Eldritch
    public static void buyMage(Player player){
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
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Warlock
            player.buyMage(new Mage("Warlock"));
        }
        if (choice == 2){
            // Buy Illusionist
            player.buyMage(new Mage("Illusionist"));
        }
        if (choice == 3){
            // Buy Enchanter
            player.buyMage(new Mage("Enchanter"));
        }
        if (choice == 4){
            // Buy Conjurer
            player.buyMage(new Mage("Conjurer"));
        }
        if (choice == 5){
            // Buy Eldritch
            player.buyMage(new Mage("Eldritch"));
        }
        if (choice == 6){
            Utils.clearScreen();
            buyCharacter(player);
        }
    }

    // The healers are Soother, Medid, Alchemist, Saint and Lightbringer
    public static void buyHealer(Player player){
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
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Soother
            player.buyHealer(new Healer("Soother"));
        }
        if (choice == 2){
            // Buy Medid
            player.buyHealer(new Healer("Medid"));
        }

        if (choice == 3){
            // Buy Alchemist
            player.buyHealer(new Healer("Alchemist"));
        }
        if (choice == 4){
            // Buy Saint
            player.buyHealer(new Healer("Saint"));
        }
        if (choice == 5){
            // Buy Lightbringer
            player.buyHealer(new Healer("Lightbringer"));
        }
        if (choice == 6){
            Utils.clearScreen();
            buyCharacter(player);
        }
    }

    // The mythical creatures are Dragon, Basilisk, Hydra, Phoenix, and Pegasus
    public static void buyMythicalCreature(Player player){
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
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Dragon
            player.buyMythicalCreature(new MythicalCreature("Dragon"));
        }
        if (choice == 2){
            // Buy Basilisk
            player.buyMythicalCreature(new MythicalCreature("Basilisk"));
        }
        if (choice == 3){
            // Buy Hydra
            player.buyMythicalCreature(new MythicalCreature("Hydra"));
        }
        if (choice == 4){
            // Buy Phoenix
            player.buyMythicalCreature(new MythicalCreature("Phoenix"));
        }
        if (choice == 5){
            // Buy Pegasus
            player.buyMythicalCreature(new MythicalCreature("Pegasus"));
        }
        if (choice == 6){
            Utils.clearScreen();
            buyCharacter(player);
        }
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
            buyEquipment(player.getArcher(), player);
        }
        if (choice == 2){
            buyEquipment(player.getKnight(), player);
        }
        if (choice == 3){
            buyEquipment(player.getMage(), player);
        }
        if (choice == 4){
            buyEquipment(player.getHealer(), player);
        }
        if (choice == 5){
            buyEquipment(player.getMythicalCreature(), player);
        }
        if (choice == 6){
            Utils.clearScreen();
            yourCharacters(player);
        }
    }

    public static void buyEquipment(Character character, Player player){
        EquipmentTable.equipmentTable();
        Scanner input = new Scanner(System.in);
        String options = ( YELLOW + """
        Choose an option... 
        
        [1] Buy Armour
        [2] Buy Artifact
        [3] Go Back
        
    Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 5) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            buyArmour(character, player);
            System.out.println(GREEN+"You have successfully bought an Armour!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            buyEquipment(character, player);
        }
        if (choice == 2){
            buyArtifact(character, player);
            System.out.println(GREEN+"You have successfully bought an Artifact!" + RESET);
            System.out.println(YELLOW+"You have " + player.getCoins() + " coins left" + RESET);
            updateProfile(player, players);
            Utils.clearScreen();
            EquipmentTable.equipmentTable();
            buyEquipment(character, player);
        }
        if (choice == 3){
            Utils.clearScreen();
            yourCharacters(player);
        }
    }

    // The armours are Chainmail, Regalia, and Fleece
    public static void buyArmour(Character character, Player player){
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
        while (choice < 1 || choice > 4) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Chainmail
            Armour chainmail = new Armour("Chainmail");
            character.setEquipment(chainmail);
            player.buyEquipment(chainmail);
        }
        if (choice == 2){
            // Buy Regalia
            Armour regalia = new Armour("Regalia");
            character.setEquipment(regalia);
            player.buyEquipment(regalia);
        }
        if (choice == 3){
            // Buy Fleece
            Armour fleece = new Armour("Fleece");
            character.setEquipment(fleece);
            player.buyEquipment(fleece);
        }
        if (choice == 4){
            Utils.clearScreen();
            buyEquipment(character, player);
        }
    }

    // THe artifacts are Excalibur, Amulet, and Crystal

    public static void buyArtifact(Character character, Player player){
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
        while (choice < 1 || choice > 4) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            // Buy Excalibur
            Artifact excalibur = new Artifact("Excalibur");
            character.setEquipment(excalibur);
            player.buyEquipment(excalibur);
        }
        if (choice == 2){
            // Buy Amulet
            Artifact amulet = new Artifact("Amulet");
            character.setEquipment(amulet);
            player.buyEquipment(amulet);
        }
        if (choice == 3){
            // Buy Crystal
            Artifact crystal = new Artifact("Crystal");
            character.setEquipment(crystal);
        }
        if (choice == 4){
            Utils.clearScreen();
            buyEquipment(character, player);
        }
    }
}
