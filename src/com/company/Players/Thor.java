package com.company.Players;

public class Thor extends Hero {
    public Thor(int health, int damage, String name, EnumSuperAbility superAbility) {
        super(health, damage, name, superAbility);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] == this && heroes[i].getHealth() > 0) {
                boss.setDamage(0);
            }

        }

    }

}
