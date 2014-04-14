package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.EnterGate;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* TODO: analyse(next field) method and do(set of flags) method
*/
class Context {;
    private Obstacle obstacle;
    private Equipment equipment;
    private LocalPrince prince;
    private Field field;

    public Context(LocalPrince prince, Field field) {
        this.prince = prince;
        this.obstacle = field.getObstacle();
        this.equipment = field.getEquipment();
        this.field = field;
    }

    Action executeStrategy() {
        if (prince.currentHealth >= prince.maxHealth) {
            Globals.HEAL_REQUIRED = false;
        }
        if (Globals.HEAL_REQUIRED) {
            return new HealStrategy().execute();
        }
        if (prince.currentHealth < 4) {
            Globals.HEAL_REQUIRED = true;
            prince.direction = Direction.changeDirection(prince.direction);
            return new Context(prince, prince.previousField).executeStrategy();
        }
        if (equipment != null) {
            if (!Globals.EQUIPMENT_FIELD) {
                Globals.EQUIPMENT_FIELD = true;
                return prince.move(prince.direction);
            } else {
                return prince.pickUp();
            }
        }
        if (obstacle != null) {
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
        }
        if (Globals.GATE_FIELD) {
            return new EnterGate();
        }
        if (field.isGate()) {
            Globals.GATE_FIELD = true;
            return prince.move(prince.direction);
        }
//        System.err.println("Something went wrong...");
        return prince.move(prince.direction);
    }
}
