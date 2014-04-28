package cz.tieto.acadamy.prince.nikitamartingreatstrategy.local;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Obstacles;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Properties;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
*/
public class Chopper {
    private Obstacle obstacle;

    public boolean isOpening = false;

    public Chopper(Obstacle obstacle) {
        if (!obstacle.getName().equals(Obstacles.CHOPPER)) {
            throw new IllegalArgumentException();
        }
        this.obstacle = obstacle;
        if (obstacle.getProperty(Properties.CHOPPER_OPENING).equals(Properties.TRUE)) {
            this.isOpening = true;
        }
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
