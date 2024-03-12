import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import Utils.Utils;
import Views.Block;
import Views.Board;
import Views.Table;

import Player.Player;
import Serialization.Serialization;

public class Main {
    public static void main(String[] args) {
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

        List<Player> players = Serialization.deserializing();
        
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

        //print army table
        // List<String> headersList = Arrays.asList("NAME", "GENDER", "MARRIED", "AGE", "SALARY($)");
        // List<List<String>> rowsList = Arrays.asList(
        //         Arrays.asList("Eddy \n hello", "Male", "No", "23", "1200.27"),
        //         Arrays.asList("Libby", "Male", "No", "17", "800.50"),
        //         Arrays.asList("Rea", "Female", "No", "30", "10000.00"),
        //         Arrays.asList("Deandre", "Female", "No", "19", "18000.50"),
        //         Arrays.asList("Alice", "Male", "Yes", "29", "580.40"),
        //         Arrays.asList("Alyse", "Female", "No", "26", "7000.89"),
        //         Arrays.asList("Venessa", "Female", "No", "22", "100700.50")
        // );

        // Board board = new Board(75);
        // Table table = new Table(board, 75, headersList, rowsList);
        // table.setGridMode(Table.GRID_COLUMN);
        // //setting width and data-align of columns
        // List<Integer> colWidthsList = Arrays.asList(14, 14, 13, 14, 14);
        // List<Integer> colAlignList = Arrays.asList(Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER, Block.DATA_CENTER);
        // table.setGridMode(Table.GRID_FULL).setColWidthsList(colWidthsList);
        // table.setColAlignsList(colAlignList);
        
        // Block tableBlock = table.tableToBlocks();
        // board.setInitialBlock(tableBlock);
        // board.build();
        // String tableString = board.getPreview();
        // System.out.println(tableString);

        if (choice == 2){
            Player player = Utils.createProfile();
            players.add(player);
        }

    }
}
