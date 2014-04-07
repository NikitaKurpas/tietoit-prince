package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.EnterGate;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
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
        if (equipment != null) {
            return prince.pickUp();
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
        }
        if (Globals.GATE_FIELD) {
            return new EnterGate();
        }
        if (field.isGate()) {
            Globals.GATE_FIELD = true;
            return prince.move(prince.direction);
        }
        return prince.move(prince.direction);
    }
}
