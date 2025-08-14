import java.util.*;

public class Shop {
    Player player; //Player instance that is currently shopping
    Scanner in; //Scanner object to get player inputs
    boolean shopping; //Boolean for whether or not the player is still shopping

    //Prices for the upgrades, increase when bought
    int healthCost = 1;
    int powerCost = 1;
    int defenseCost = 1;

    //Constructor for the shop object
    public Shop(Scanner in){
        this.in = in;
    }

    //Method called to open the shop
    public void openShop(Player player){
        this.player = player;
        shopping = true;

        System.out.println("\n****** Welcome to the shop! ******");
        System.out.println("You have " + player.getGold() + " gold");
        System.out.println("Want to buy an upgrade?\n(heal/health/power/defense)");
        System.out.println("\nWant to leave?\n(leave)");

        while (shopping) {
            //curGold = String.valueOf(player.getGold());
            try{EnemySlayer.input = in.nextLine().toLowerCase();}
            catch(Exception e){System.out.println("Input failed: " + e);}
                switch(EnemySlayer.input){
                    case "heal":
                        if(player.getGold() >= 1){
                            player.heal(player.getMaxHealth());
                            player.spendGold(1);
                            System.out.println("\nThat should fix you right up! You now have " + player.getHealth() + "/" + player.getMaxHealth() + " Health\n you now have " + player.getGold() + " gold");
                        } else {
                            System.out.println("Sorry, I don't treat for free");
                        }
                        break;
                    case "health":
                        if(player.getGold() >= healthCost){
                            player.upgradeHealth();
                            player.upgradeHealth();
                            player.spendGold(1);
                            System.out.println("\nLookin' mighty healthy! You now have " + player.getHealth() + "/" + player.getMaxHealth() + " Health\n you now have " + player.getGold() + " gold");
                        } else {
                            System.out.println("No such thing as free miracles...");
                        }
                        break;
                    case "power":
                        if(player.getGold() >= powerCost){
                            player.upgradePower();
                            player.spendGold(1);
                            System.out.println("\nI've got just the pills for you! Your power is now " + player.getPower() + "\n you now have " + player.getGold() + " gold");
                        } else {
                            System.out.println("Find your own drugs!");
                        }
                        break;
                    case "defense":
                        if(player.getGold() >= defenseCost){
                            player.upgradeDefense();
                            player.spendGold(1);
                            System.out.println("\nGood form! Your defense is now " + player.getDefense() + "\n you now have " + player.getGold() + " gold");
                        } else {
                            System.out.println("Teachers make little enough as is.");
                        }
                        break;
                    case "leave":
                        System.out.println("See you next time!");
                        shopping = false;
                        break; 
                    default:
                    System.out.println("\nNot a valid input");
                }
        }
    }
}