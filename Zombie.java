import java.util.*;

public class Zombie extends Monster {
    //Constructor for Zombies
    public Zombie(){
        super(5, 2, 1, 2);
        this.name = "Zombie";
    }

    //Overloaded constructor for scaling difficulty
    public Zombie(int healthBuff, int powBuff, int defBuff, int lootBuff){
        super(5+healthBuff, 2+powBuff, 1+defBuff, 2+lootBuff);
        this.name = "Zombie";
    }

    //Overloaded die method for the zombie, who will sometimes reanimate
    public void die(){
        Random rand = new Random();
        if(rand.nextInt(0,2) == 0){
            isAlive = false;
        } else {
            isAlive = true;
            curHealth = rand.nextInt(1,maxHealth+1);
            System.out.println("Oh no, it's still moving!");
        }
    }
}
