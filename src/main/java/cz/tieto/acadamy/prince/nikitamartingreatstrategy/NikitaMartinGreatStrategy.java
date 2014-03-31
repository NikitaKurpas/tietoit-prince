package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.GameStrategy;
import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.*;
import cz.tieto.princegame.common.gameobject.Field;

import javax.tools.ForwardingFileObject;
import java.util.Iterator;

public class NikitaMartinGreatStrategy implements GameStrategy {

    private boolean moveRight = true;

    final static String OBS_PITFALL = "pitfall";
    final static String OBS_CHOPPER = "chopper";
    final static String OBS_KNIGHT  = "knight";

    final static String PROP_CHOPPER_OPENING = "opening";
    final static String PROP_TRUE = "true";
    final static String PROP_KNIGHT_HEALTH = "health";
    final static String PROP_KNIGHT_DEAD = "dead";

    final static String EQ_SWORD = "sword";

    private boolean healRequired = false;

    @Override
    public Action step(Prince prince) {
        if (prince == null) {
            return null;
        }

        Field currentField = prince.look(0);
        if (currentField.isGate()) {
            return new EnterGate();
        }

        if (currentField.getEquipment() != null) {
            Equipment equipment = currentField.getEquipment();
            // SWORD
            if (equipment.getName().equals(EQ_SWORD))
                return new Grab();
        }

        int lookDirection = moveRight ? 1 : -1;
        Field nextField = prince.look(lookDirection);

        if (nextField == null) {
            moveRight = !moveRight;
            return move(moveRight);
        }

        // TODO: OBS on a gate
        // NEXT FILED IS A GATE
        if (nextField.isGate()) {
            return move(moveRight);
        }

        // HEAL
        int health = prince.getHealth();
        int maxHealth = prince.getMaxHealth();
        if (health >= maxHealth) healRequired = false;
        if (health < maxHealth && healRequired) {
            return new Heal();
        }

        // NEXT FILED IS AN OBSTACLE
        if (nextField.getObstacle() != null) {
            Obstacle obstacle = nextField.getObstacle();
//            Context context = new Context(obstacle);
//            return context.executeStrategy();

            // PITFALL
            if (obstacle.getName().equals(OBS_PITFALL))
                return jump(moveRight);

            // CHOPPER
            else if (obstacle.getName().equals(OBS_CHOPPER))
                if (obstacle.getProperty(PROP_CHOPPER_OPENING).equals(PROP_TRUE))
                    return jump(moveRight);
                else
                    return new Heal();

            // KNIGHT
            else if (obstacle.getName().equals(OBS_KNIGHT)) {
                Equipment sword = null;
                for (Iterator iterator = prince.getInventory().iterator(); iterator.hasNext();) {
                    Equipment eq = (Equipment) iterator.next();
                    if(eq.getName().equals(EQ_SWORD))
                        sword = eq;
                }

                if (obstacle.getProperty(PROP_KNIGHT_DEAD).equals(PROP_TRUE))
                    return move(moveRight);
                else if (sword == null) {
                    moveRight = !moveRight;
                    move(moveRight);
                }
                else if (health <= maxHealth / 3) {
                    healRequired = true;
                    return move(!moveRight);
                } else
                    return new Use(sword, obstacle);

            }

            // NONE OF THE ABOVE
            else
                return move(moveRight);
        }

        // NEXT FIELD IS EMPTY
        return move(moveRight);

    }

    Action move(boolean moveRight) {
        if (!moveRight) return new MoveBackward();
        return new MoveForward();
    }

    Action jump(boolean moveRight) {
        if (!moveRight) return new JumpBackward();
        return new JumpForward();
    }


    interface Strategy {
        Action execute();
    }

    class PitfallStratagy implements Strategy {
        public Action execute() {
            return jump(moveRight);
        }
    }

    class ChopperStrategy implements Strategy {

        private Obstacle obstacle;

        public ChopperStrategy(Obstacle obstacle) {
            this.obstacle = obstacle;
        }

        public Action execute() {
            if (obstacle.getProperty(PROP_CHOPPER_OPENING).equals(PROP_TRUE))
                return jump(moveRight);
            else
                return new Heal();
        }
    }

    class Context {
        private Strategy strategy;
        private Obstacle obstacle;

        public Context(Obstacle obstacle) {
            this.obstacle = obstacle;
        }

        Action executeStrategy() {
            if (this.obstacle.getName().equals(OBS_PITFALL))
                return new PitfallStratagy().execute();
            else if (this.obstacle.getName().equals(OBS_CHOPPER))
                return new ChopperStrategy(obstacle).execute();
            else return new Heal();
        }
    }
}
