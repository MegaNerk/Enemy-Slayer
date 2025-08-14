public class Player extends Entity{
    //Variable tracks player gold
    private int gold;

    //Getter method for gold
    public int getGold(){
        return gold;
    }

    //Default constructor
    public Player(){
        this.maxHealth = 10;
        this.curHealth = this.maxHealth;
        
        this.basePower = 2;
        this.curPower = this.basePower;

        this.baseDefense = 2;
        this.curDefense = this.baseDefense;
        
        this.gold = 0;
    }
    
    //Overloaded constructor for customizability
    public Player(int maxHealth, int basePower, int baseDefense, int gold){
        this.maxHealth = maxHealth;
        this.curHealth = this.maxHealth;

        this.basePower = basePower;
        this.curPower = this.basePower;

        this.baseDefense = baseDefense;
        this.curDefense = this.baseDefense;

        this.gold = gold;
    }

    //Method to revive the player
    public void revive(){
        isAlive = true;
        curHealth = maxHealth;
    }

    //Method to gain loot after fights
    public void gainLoot(int loot){
        gold += loot;
        System.out.println("You looted " + loot + " gold!");
    }

    //Method to spend gold
    public void spendGold(int amount){
        gold -= amount;
    }

    //Method to upgrade maxHealth
    public void upgradeHealth(){
        maxHealth++;
        curHealth++;
    }

    //Method to upgrade basePower
    public void upgradePower(){
        basePower++;
        curPower++;
    }

    //Method to upgrade baseDefense
    public void upgradeDefense(){
        baseDefense++;
        curDefense++;
    }

}