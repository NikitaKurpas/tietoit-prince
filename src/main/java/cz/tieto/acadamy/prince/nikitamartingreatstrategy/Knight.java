package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
*/
class Knight {
    private Obstacle obstacle;

    int health;
    boolean isDead = false;

    public Knight(Obstacle obstacle) {
        if (!obstacle.getName().equals(Obstacles.KNIGHT)) {
            throw new IllegalArgumentException();
        }
        this.obstacle = obstacle;
        this.health = Integer.parseInt(obstacle.getProperty(Properties.KNIGHT_HEALTH));
        this.isDead = obstacle.getProperty(Properties.KNIGHT_DEAD).equals(Properties.TRUE);
    }

    public Obstacle getObstacle() {
        return obstacle;
    }
}
