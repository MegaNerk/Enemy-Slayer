import java.util.*;

public class CombatManager{
    private Player player; //The player object that will be performing combat
    private Monster enemy; //The current enemy the player is fighting
    private Scanner in; //System.in scanner for player input

    //Constructor for CombatManagers
    public CombatManager(Player player, Scanner in){
        this.player = player;
        this.in = in;
    }

    //Main method of the CombatManager, runs combat between a player and a monster
    public void runCombat(Monster enemy){
        this.enemy = enemy;
        Random rand = new Random();
        System.out.println("A " + enemy.getName() + " appears!");

        while (player.isAlive() && enemy.isAlive()){
            System.out.println("\n******");
            runPlayerAction(rand);
            if(enemy.isAlive()){
                runEnemyAction(rand);
            }
            System.out.println(enemy.getName() + " health: " + enemy.getHealth());
            System.out.println("Player health: " + player.getHealth());
        }
    endCombat();
    }

    //Runs at the end of combat, cleans up
    private void endCombat(){
        if(player.isAlive()){
            System.out.println("You won the fight!");
            player.gainLoot(enemy.dropLoot());
        } else {
            System.out.println("You wake up back in the town hospital...");
        }
    }

    //Method contains logic to execute the player's turn
    private void runPlayerAction(Random rand){
        boolean madeChoice = false;

        while(!madeChoice){
            System.out.println("Will you attack or Defend\n(atk/def)");
            try{EnemySlayer.input = in.nextLine().toLowerCase();}
            catch(Exception e){System.out.println("Input failed: " + e);}
            
            System.out.println("******");

            switch(EnemySlayer.input){
                case "atk":
                    int attackValue = rand.nextInt(1, player.attack()+1);
                    System.out.println("You attacked for " + attackValue +" damage!");
                    enemy.takeDamage(attackValue);
                    madeChoice = true;
                    break;
                case "def":
                    int defenseValue = rand.nextInt(1, player.defend()+1);
                    System.out.println("You defended, restoring " + defenseValue +" health!");    
                    player.heal(defenseValue);
                    madeChoice = true;
                    break;
                default:
                    System.out.println("Not a valid input, please try again\n");
            }
        }
    }

    //Method contains logic to determine and execute the monster's turn in combat
    private void runEnemyAction(Random rand){
        switch(rand.nextInt(1,3)){
            case 1:
                int attackValue = rand.nextInt(1, enemy.attack()+1);
                System.out.println("The " + enemy.getName() + " attacked for " + attackValue +" damage!");
                player.takeDamage(attackValue);
                break;
            case 2:
                int defenseValue = rand.nextInt(1,enemy.defend()+1);
                System.out.println("The " + enemy.getName() + " defended! Restoring " + defenseValue +" health!");
                enemy.heal(defenseValue);
                break;
            default:
                System.out.println("Error, Unknown Monster Action\n");
        }
    }
}