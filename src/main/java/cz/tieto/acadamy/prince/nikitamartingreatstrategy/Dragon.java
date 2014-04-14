package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Obstacle;

/**
 * Created by Nikita on 14-Apr-14.
 */
public class Dragon {
    private Obstacle obstacle;

    int health;
    int damageShort = 3;
    int damageLong = 1;
    boolean isDead = false;

    public Dragon(Obstacle obstacle) {
        if (!obstacle.getName().equals(Obstacles.DRAGON)) {
            throw new IllegalArgumentException();
        }
        this.obstacle = obstacle;
        this.health = Integer.parseInt(obstacle.getProperty(Properties.HEALTH));
        this.isDead = obstacle.getProperty(Properties.DEAD).equals(Properties.TRUE);
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
