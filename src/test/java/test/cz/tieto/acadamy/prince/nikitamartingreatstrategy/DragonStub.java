package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Obstacle;

public class DragonStub implements Obstacle {

    int health = 35;
    int previousHealth = health;
    int smallDmg = 1;
    int largeDmg = 3;

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "dragon";
    }

    @Override
    public String getProperty(String s) {
        if (s.equals("health")) {
            return Integer.toString(health);
        } if (s.equals("dead")) {
            return Boolean.toString(health < previousHealth);
        }
        return null;
    }
}
