import java.util.*;

public class Monster extends Entity{
    protected int loot; //How much gold the monster will drop
    protected String name; //Monster's name (Will be it's type)

    //Getter method for monster name (will be it's type)
    public String getName(){
        return name;
    }

    //Protected constructor to prevent standalone monster initialization
    protected Monster(int maxHealth, int basePower, int baseDefense, int loot){
        this.maxHealth = maxHealth;
        this.curHealth = this.maxHealth;
        
        this.basePower = basePower;
        this.curPower = this.basePower;

        this.baseDefense = baseDefense;
        this.curDefense = this.baseDefense;

        this.loot = loot;
    }
    
    //Method for monster loot
    public int dropLoot(){
        Random rand = new Random();
        return rand.nextInt(1,loot+1);
    }
}