package com.company.Players;

import java.util.Random;

public class Magic extends Hero {


    public Magic(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        Random random = new Random();
        int n = random.nextInt(3) + 1;
        for (int i = 0; i <heroes.length ; i++) {
            if(heroes[i].getHealth()>0 && boss.getHealth() > 0 && heroes[i] != this){
                heroes[i].setDamage(heroes[i].getDamage() + n);
            }
        }
        System.out.println(getName() + EnumSuperAbility.BOOST + ": увеличение удара на " + n);
    }
}
