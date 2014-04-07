package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
*/
class Chopper {
    private Obstacle obstacle;

    boolean isOpening = false;

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
