package Utils;

public class Utils {
    public static void clearScreen() {
        System.out.print("\033[H\033[2J"); // Clear the screen
        System.out.flush();
    }
    
}
