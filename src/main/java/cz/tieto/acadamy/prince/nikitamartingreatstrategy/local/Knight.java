package cz.tieto.acadamy.prince.nikitamartingreatstrategy.local;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Obstacles;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Properties;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
*/
public class Knight {
    private Obstacle obstacle;

    public int health;
    public boolean isDead = false;

    public Knight(Obstacle obstacle) {
        if (!obstacle.getName().equals(Obstacles.KNIGHT)) {
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
