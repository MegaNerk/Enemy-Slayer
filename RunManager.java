import java.util.*;

public class RunManager{
    static int numRuns; //Static variable tracks the total number of runs performed this play session

    private int runLevel; //Private variable tracks the current level of runs produced by this run manager
    private int monstersFought; //Private variable tracks how many monsters have been fought
    private boolean runActive; //Private boolean tracks whether the run is still active

    private Player runPlayer; //Player instance for the run
    private CombatManager combatManager; //Combat Manager handles combat
    private Scanner in; //Scanner object to get player inputs

    //Constructor
    public RunManager(Scanner in){
        this.in = in;
        runLevel = 1;
    }

    //This method starts the next run of monster fights
    public void startRun(Player player) {
        this.runPlayer = player;
        combatManager = new CombatManager(runPlayer, in);
        System.out.println("*****\nThis run is level " + runLevel);

        runActive = true;
        monstersFought = 0;
        boolean retreated = false;

        //While loop keeps giving the player monsters to fight until the run ends
        while (runActive){
            combatManager.runCombat(pickNewMonster());
            monstersFought++;

            if (!runPlayer.isAlive() || monstersFought >= runLevel){
                runActive = false;
            } else {
                System.out.println("The monster has fallen, will you continue to fight?\n(y/n)");
                try{EnemySlayer.input = in.nextLine().toLowerCase();}
                catch(Exception e){System.out.println("Input failed: " + e);}
                switch(EnemySlayer.input){
                    case "y":
                        break;
                    default:
                        runActive = false;
                        retreated = true;
                        break;
                }
            }
        }
        endRun(retreated);
    }

    //Method to end the run
    private void endRun(boolean retreated){
        if (runPlayer.isAlive() && !retreated){
            numRuns++;
            runLevel++;
            System.out.println("\nYou have now completed " + numRuns + " runs, and now have " + runPlayer.getGold() + " gold");
        } else if(!runPlayer.isAlive()){
            runPlayer.revive();
            runPlayer.spendGold(runPlayer.getGold());
            System.out.println("You have lost all of your gold...");
        } else if (retreated){
            System.out.println("You flee back to town, and now have " + runPlayer.getGold() + " gold");
        }
    }

    //This method generates a new monster of a random type and returns it as the output
    private Monster pickNewMonster(){
        Random rand = new Random();

        int healthBuff = rand.nextInt(0,runLevel+1);
        int powBuff = rand.nextInt(0,runLevel+1);
        int defBuff = rand.nextInt(0,runLevel+1);
        int lootBuff = rand.nextInt(0,runLevel+1);
        
        int randomMonster = rand.nextInt(1,4);
        switch(randomMonster){
            case 1:
                return new Zombie(healthBuff, powBuff, defBuff, lootBuff);
            case 2:
                return new Skeleton(healthBuff, powBuff, defBuff, lootBuff);
            case 3:
                return new Bandit(healthBuff, powBuff, defBuff, lootBuff);
            default:
                System.out.println("Unknown Error: Failed to generate monster");
                return null;
        }
    }
}