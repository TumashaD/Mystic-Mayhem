import Utils.Utils;
import Player.Player;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {      
        Scanner input = new Scanner(System.in);
         
        int choice = Utils.mainScreen(input);
        Utils.clearScreen();

        if (choice == 2){
            Player player = Utils.createProfile(input);
            Utils.clearScreen();
            
            Boolean isRunOut = Utils.createArmy(input, player, false);
            Utils.clearScreen();

            while (isRunOut){
                isRunOut = Utils.createArmy(input, player, true);
                Utils.clearScreen();
            }
        }

        
    }
}
