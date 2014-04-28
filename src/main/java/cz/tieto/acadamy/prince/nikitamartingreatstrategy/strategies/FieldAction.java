package cz.tieto.acadamy.prince.nikitamartingreatstrategy.strategies;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.Helpers;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.LocalPrince;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Obstacles;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Obstacle;

public class FieldAction {
    LocalPrince prince;

    public FieldAction(LocalPrince prince) {
        this.prince = prince;
    }

    public Action chooseAction() {
        if (prince.globalFlags.RETREAT || prince.globalFlags.DOUBLE_RETREAT) {
            prince.direction.changeDirection(true); // TEMPORARILY CHANGE DIRECTION

            if (Helpers.isObstacleField(prince.fieldSet.previousField)) {
                return obstacleAction(prince.fieldSet.previousField.getObstacle());
            } else {
                return prince.move(prince.direction);
            }
        }

        if (prince.globalFlags.HEAL_REQUIRED) {
            return prince.heal();
        }

        if (Helpers.isObstacleField(prince.fieldSet.nextField)) {
            return obstacleAction(prince.fieldSet.nextField.getObstacle());
        }

        return null;
    }

    private Action obstacleAction(Obstacle obstacle) {
        if (obstacle.getName().equals(Obstacles.PITFALL)) {
            return new PitfallStrategy(prince).execute();
        }
        if (obstacle.getName().equals(Obstacles.CHOPPER)) {
            return new ChopperStrategy(prince, obstacle).execute();
        }
        if (obstacle.getName().equals(Obstacles.KNIGHT)) {
            return new KnightStrategy(prince, obstacle).execute();
        }
        if (obstacle.getName().equals(Obstacles.DRAGON)) {
            return new DragonStrategy(prince, obstacle).execute();
        }
        return prince.move(prince.direction);
    }
}
