package com.company.Game;

import com.company.Players.*;

public class Game {
    public static void startGame() {
        Boss boss = new Boss(700, 50, " Thanos ");
        Warrior warrior = new Warrior(270, 20, " Captain America ", EnumSuperAbility.CRITICAL_DAMAGE);
        Berserk berserk = new Berserk(240, 10, " Berserk ", EnumSuperAbility.REVERT_DAMAGE);
        Magic magic = new Magic(250, 25, " Magic ", EnumSuperAbility.BOOST);
        Medic doc = new Medic(220, 5, " Doc ", 10, EnumSuperAbility.HEAL);
        Medic assistent = new Medic(260, 10, " Assistent ", 5, EnumSuperAbility.HEAL);
        Thor thor = new Thor(100,10," Thor",EnumSuperAbility.THOR);
        Hero[] heroes = {warrior, berserk, magic, doc, assistent, thor};
        System.out.println("______The game_____");
        printStatistics(boss, heroes);
        while (!isGameFinished(boss,heroes)){
            round(boss,heroes);
        }

    }
    private static void round(Boss boss, Hero[] heroes){
        bossHit(boss, heroes);
        heroesHit(boss, heroes);
        applySuperAbbilities(boss, heroes);

        printStatistics(boss, heroes);
    }
    private static boolean isGameFinished(Boss boss, Hero[] heroes){
        if (boss.getHealth() <= 0){
            System.out.println("Heroes won");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i <heroes.length ; i++) {
            if (heroes[i].getHealth() > 0){
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead){
            System.out.println("Boss won");

        }
        return allHeroesDead;
    }

     private static void printStatistics(Boss boss, Hero[] heroes){
         System.out.println(boss.getName() + " health: " + boss.getHealth() + " Damage: " + boss.getDamage());
        for (int i = 0; i <heroes.length ; i++) {
            System.out.println(heroes[i].getName() + " Health: " + heroes[i].getHealth() + " Damage: " + heroes[i].getDamage());
         }
         System.out.println("_______________________");
     }

    private static void heroesHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - hero.getDamage());
            }
        }
    }
    private static void applySuperAbbilities(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                hero.applySuperAbility(boss,heroes);
            }
        }
    }

    private static void bossHit(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0) {
                hero.setHealth(hero.getHealth() - boss.getDamage());
            }
        }
    }

}
