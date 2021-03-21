package com.company.Players;

import java.util.Random;

public class Warrior extends Hero {


    public Warrior(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int random1 = random.nextInt(4) + 2;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this) {
                heroes[i].setDamage(heroes[i].getDamage() * random1);
            }

        }
        System.out.println(getName() + EnumSuperAbility.CRITICAL_DAMAGE + ":  " + getDamage());
    }

}
