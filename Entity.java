public class Entity{
    //Variables track Health info for the entity
    protected int maxHealth;
    protected int curHealth;

    //Variables track Power info for the entity
    protected int basePower;
    protected int curPower;

    //Variables track Defense info for the entity
    protected int baseDefense;
    protected int curDefense;

    //Boolean tracks whether or not this entity is alive
    protected boolean isAlive;

    //Protected constructor to prevent standalone Entities
    protected Entity(){
        isAlive = true;
    }

    //Getter Method for current power
    public int getHealth(){
        return this.curHealth;
    }

    //Getter Method for current power
    public int getMaxHealth(){
        return this.maxHealth;
    }

    //Getter Method for current power
    public int getPower(){
        return this.curPower;
    }

    //Getter method for current defense
    public int getDefense(){
        return this.curDefense;
    }

    //Getter method for isAlive boolean
    public boolean isAlive(){
        return isAlive;
    }

    //Essentially another getter. (Seperate method for intentional overload potential)
    public int attack(){
        //Code that attacks
        return this.getPower();
    }

    //Essentially another getter. (Seperate method for intentional overload potential)
    public int defend(){
        //Code that defends
        return this.getDefense();
    }

    //Method deals damage to the entity
    public void takeDamage(int damage){
        if ((this.curHealth - damage) > 0){
            this.curHealth -= damage;
        } else{
            this.curHealth = 0;
            this.die();
        }
    }

    //Method heals the entity for a set amount
    public void heal(int health){
        if ((this.curHealth + health) <= this.maxHealth){
            this.curHealth += health;
        } else{
            this.curHealth = this.maxHealth;
        }
    }

    //Marks the entity as dead (Seperate method for intentional overload potential)
    public void die(){
        isAlive = false;
    }
}