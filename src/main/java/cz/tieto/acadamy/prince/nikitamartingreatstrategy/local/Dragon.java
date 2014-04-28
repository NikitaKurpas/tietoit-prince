package cz.tieto.acadamy.prince.nikitamartingreatstrategy.local;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Obstacles;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Properties;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
 * Created by Nikita on 14-Apr-14.
 */
public class Dragon {
    private Obstacle obstacle;

    public int health;
    public int damageShort = 3;
    public int damageLong = 1;
    public boolean isDead = false;

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
