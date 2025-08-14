import java.util.*;

public class Bandit extends Monster {
        //Constructor for Bandits
        public Bandit(){
            super(4, 3, 2, 3);
            this.name = "Bandit";
        }
    
        //Overloaded constructor for scaling difficulty
        public Bandit(int healthBuff, int powBuff, int defBuff, int lootBuff){
            super(4+healthBuff, 3+powBuff, 2+defBuff, 3+lootBuff);
            this.name = "Bandit";
        }

        public int attack(){
            Random rand = new Random();
            if(rand.nextInt(0,4) == 0){
                this.maxHealth++;
                heal(1);
                System.out.println("Hey, he's taking your stuff!");
            }
            return getPower();
        }
}