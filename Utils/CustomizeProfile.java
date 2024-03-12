package Utils;

import java.util.Scanner;

import Character.CharacterTable;
import Equipment.EquipmentTable;

public class CustomizeProfile {
    //colours
    static final String RESET = "\u001B[0m";
    static final String RED = "\u001B[31m";
    static final String GREEN = "\u001B[32m";
    static final String YELLOW = "\u001B[33m";
    static final String BLUE = "\u001B[34m";
    static final String ORANGE = "\u001B[38;5;208m";

    public static int customizeProfileMenu(){
        Scanner input = new Scanner(System.in);
        String title = (BLUE +"""
            ===========================================
            |           CUSTOMIZE PROFILE             |
            ===========================================
                """ + RESET);
        String options = ( YELLOW + """
            Choose an option... 

            [1] Change your name
            [2] Your Characters
            [3] Main Menu

            Enter Your Choice: """ + RESET);

        System.out.print(title+ options);

        int choice = input.nextInt();
        
        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        Utils.clearScreen();
        return choice;
    
    }
    public static void yourCharacters(){
        Scanner input = new Scanner(System.in);
        String title = (BLUE +"""
            ===========================================
            |           YOUR CHARACTERS               |
            ===========================================
                """ + RESET);
        String options = ( YELLOW + """
            Choose an option... 

            [1] Buy New Characters
            [2] Buy Equipments
            [3] Main Menu

            Enter Your Choice: """ + RESET);
        System.out.print(title+ options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            buyCharacter();
        }
        if (choice == 2){
            buyEquipment();
        }
        if (choice == 3){
            Utils.clearScreen();
            customizeProfile();
        }
    }
    public static void customizeProfile(){
        int choice = customizeProfileMenu();
        Scanner input = new Scanner(System.in);
        if (choice == 1){
            String changeName = ("\n"+ YELLOW + "Enter your new name: " + RESET);
            System.out.print(changeName);
            String newName = input.nextLine();
            // SetName
            System.out.print(GREEN+"Your name has been changed to " + newName + "\n" + RESET);
            choice = customizeProfileMenu();
        }
        if (choice == 2){
            yourCharacters();
        }
        if (choice == 3){
            Utils.startingScreen();
        }
    }

    public static void buyCharacter(){
        CharacterTable.characterTable();
        Scanner input = new Scanner(System.in);
        String options = ( YELLOW + """
            Choose an option... 

            [1] Buy Archer
            [2] Buy Knight
            [3] Buy Mage
            [4] Buy Healer
            [5] Buy Mythical Creature
            [6] Main Menu

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        System.out.println();
        while (choice < 1 || choice > 6) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            buyArcher();
        }
        if (choice == 2){
            buyKnight();
        }
        if (choice == 3){
            buyMage();
        }
        if (choice == 4){
            buyHealer();
        }
        if (choice == 5){
            buyMythicalCreature();
        }
        if (choice == 6){
            Utils.clearScreen();
            customizeProfile();
        }
    }

    public static void buyArcher(){
        Scanner input = new Scanner(System.in);
        String options = ( ORANGE + """
            Choose an option... 

            [1] Buy Shooter
            [2] Buy Ranger
            [3] Buy Sunfire
            [4] Buy Zing
            [5] Buy Saggitarus
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
        }
        if (choice == 2){
            // Buy Ranger
        }
        if (choice == 3){
            // Buy Sunfire
        }
        if (choice == 4){
            // Buy Zing
        }
        if (choice == 5){
            // Buy Saggitarus
        }
        if (choice == 6){
            Utils.clearScreen();
            buyCharacter();
        }
    }

    public static void buyKnight(){
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
        }
        if (choice == 2){
            // Buy Cavalier
        }
        if (choice == 3){
            // Buy Templar
        }
        if (choice == 4){
            // Buy Zoro
        }
        if (choice == 5){
            // Buy Swiftblade
        }
        if (choice == 6){
            buyCharacter();
        }
    }

    // The mages are Warlock, Illusionist, Enchanter, Conjurer and Eldritch
    public static void buyMage(){
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
        }
        if (choice == 2){
            // Buy Illusionist
        }
        if (choice == 3){
            // Buy Enchanter
        }
        if (choice == 4){
            // Buy Conjurer
        }
        if (choice == 5){
            // Buy Eldritch
        }
        if (choice == 6){
            buyCharacter();
        }
    }

    // The healers are Soother, Medid, Alchemist, Saint and Lightbringer
    public static void buyHealer(){
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
        }
        if (choice == 2){
            // Buy Medid
        }
        if (choice == 3){
            // Buy Alchemist
        }
        if (choice == 4){
            // Buy Saint
        }
        if (choice == 5){
            // Buy Lightbringer
        }
        if (choice == 6){
            buyCharacter();
        }
    }

    // The mythical creatures are Dragon, Basilisk, Hydra, Phoenix, and Pegasus
    public static void buyMythicalCreature(){
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
        }
        if (choice == 2){
            // Buy Basilisk
        }
        if (choice == 3){
            // Buy Hydra
        }
        if (choice == 4){
            // Buy Phoenix
        }
        if (choice == 5){
            // Buy Pegasus
        }
        if (choice == 6){
            buyCharacter();
        }
    }

    public static void buyEquipment(){
        EquipmentTable.equipmentTable();
        Scanner input = new Scanner(System.in);
        String options = ( YELLOW + """
            Choose an option... 

            [1] Buy Armour
            [2] Buy Artifact
            [3] Main Menu

            Enter Your Choice: """ + RESET);
        System.out.print(options);
        int choice = input.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.print(RED + "Invalid Choice! Please enter a valid choice: " + RESET);
            choice = input.nextInt();
        }
        if (choice == 1){
            buyArmour();
        }
        if (choice == 2){
            buyArtifact();
        }
        if (choice == 3){
            Utils.clearScreen();
            customizeProfile();
        }
    }

    // The armours are Chainmail, Regalia, and Fleece
    public static void buyArmour(){
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
        }
        if (choice == 2){
            // Buy Regalia
        }
        if (choice == 3){
            // Buy Fleece
        }
        if (choice == 4){
            buyEquipment();
        }
    }

    // THe artifacts are Excalibur, Amulet, and Crystal

    public static void buyArtifact(){
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
        }
        if (choice == 2){
            // Buy Amulet
        }
        if (choice == 3){
            // Buy Crystal
        }
        if (choice == 4){
            buyEquipment();
        }
    }
}
