import java.util.*;

public class Skeleton extends Monster {
    //Constructor for Skeletons
    public Skeleton(){
        super(7, 1, 2, 1);
        this.name = "Skeleton";
    }

    //Overloaded constructor for scaling difficulty
    public Skeleton(int healthBuff, int powBuff, int defBuff, int lootBuff){
        super(7+healthBuff, 1+powBuff, 2+defBuff, 1+lootBuff);
        this.name = "Skeleton";
    }

    //Overloaded defend method for the Skeleton's ability, gaining Defense over time
    public int defend(){
        Random rand = new Random();
        if(rand.nextInt(0,5) == 0){
            this.baseDefense++;
            this.curDefense = this.baseDefense;
            System.out.println("Oh no! He's drinking milk!");
        }
        return this.curDefense;
    }
}