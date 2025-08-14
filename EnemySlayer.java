import java.util.*;

public class EnemySlayer{
    public static String input; //Input string for player input
    public static Scanner in = new Scanner(System.in); //System.in scanner for collecting player input
    public static RunManager game = new RunManager(in); //RunManager object to create fight runs for the player
    public static Shop shop = new Shop(in);
    public static Player player = new Player(); //Player instance object representing the user's character

    //Main game body
    public static void main(String[] args) {
        while (true) {
        System.out.println("\nType \"Quit\" to quit, \"Shop\" to visit the shop, or \"Run\" to start a run\n(Quit/Shop/Run)");
        try{input = in.nextLine().toLowerCase();}
        catch(Exception e){System.out.println("Input failed: " + e);}
            switch(input){
                case "quit":
                    System.out.println("\nGoodbye!");
                    System.exit(0);
                    break;
                case "run":
                    game.startRun(player);
                    break;
                case "shop":
                    shop.openShop(player);    
                    break;  
                default:
                System.out.println("\nNot a valid input");
            }
        }
    }
}