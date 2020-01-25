package kg.geektech.lesson8_1.players;

import java.util.Random;

public class Warrior extends Hero {

    public Warrior(int health, int damage) {
        super(health, damage, AbilityType.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        Random r = new Random(2);
        int a = r.nextInt(4);
        heroes[0].setDamage(heroes[0].getDamage() * a);
        boss.setHealth(boss.getHealth() - heroes[0].getDamage());


//        int a = 10;
//        int b = 2;
//        b = 2 * 2
//        a = 10 - 4


    }


}

