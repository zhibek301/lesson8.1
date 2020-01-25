package kg.geektech.lesson8_1.general;

import kg.geektech.lesson8_1.players.*;

public class RPG_Game {

    public static void startGame() {
        Boss boss = new Boss(500, 50);
        Warrior warrior = new Warrior(250, 20);
        Magic magic = new Magic(250, 20);
        Hunter hunter = new Hunter(250, 20);
        Medic medic = new Medic(250, 10, 15);
        Medic youngMedic = new Medic(300, 10, 5);

        Hero[] heroes = {warrior, magic, medic, hunter, youngMedic};

        printStatistics(boss, heroes);
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    public static void round(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            bossHit(boss, heroes);
        }
        heroesHit(boss, heroes);
        heroesApplyPower(boss, heroes);
        printStatistics(boss, heroes);
    }

    public static boolean isFinished(Boss boss, Hero[] heroes) {

        if (boss.getHealth() < 0) {
            System.out.println("Heroes won!");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!");
        }
        return allHeroesDead;
    }

    public static void bossHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
        }
    }

    public static void heroesHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    public static void heroesApplyPower(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].applySuperPower(boss, heroes);
            }
        }
    }

    public static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("________________");
        System.out.println("Boss health: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName()
                    + " health: " + heroes[i].getHealth());
        }
        System.out.println("________________");
    }

}
