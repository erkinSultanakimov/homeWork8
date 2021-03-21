package com.company.Players;

import java.util.Random;

public class Berserk extends Hero {


    public Berserk(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int random1 = random.nextInt(boss.getDamage()+1) + 1;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this) {
                heroes[i].setDamage(boss.getDamage() - random1);
            }
        }
        System.out.println(getName() + EnumSuperAbility.REVERT_DAMAGE + ":  " + getDamage());
    }
}
