package kg.geektech.lesson8_1.players;

import java.util.Random;

public class Magic extends Hero {

    private int increasedDamage;

    public Magic(int health, int damage) {
        super(health, damage, AbilityType.BOOST);
    }


    public int getIncreasedDamage() {
        return increasedDamage;
    }

    public void setIncreasedDamage()
        {
            this.increasedDamage= new Random().nextInt(30) + 5;
        }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < 4; i++) {
            if (heroes [i].getDamage()>0) {
                setIncreasedDamage();
                heroes[i].setDamage(heroes[i].getDamage()+ getIncreasedDamage());
                System.out.println("Magic increased " + heroes[i].getClass().getSimpleName() + " " + getIncreasedDamage());
            }

        }




    }
}




