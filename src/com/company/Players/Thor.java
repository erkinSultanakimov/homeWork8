package com.company.Players;

import java.util.Random;

public class Thor extends Hero {
    public Thor(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {


        Random random = new Random();
        boolean n = random.nextBoolean();
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this && heroes[i].getHealth() > 0 && n != false) {
                boss.setDamage(0);
            } else {
                boss.setDamage(50);
            }
        }
        System.out.println(" Оглушить таноса:" + n);

    }

}
