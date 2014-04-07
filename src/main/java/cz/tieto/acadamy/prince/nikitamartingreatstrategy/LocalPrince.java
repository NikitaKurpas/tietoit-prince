package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;

import java.util.HashMap;

/**
* Created by Nikita on 07/04/2014.
*/
public class LocalPrince {
    private Prince prince;

    Field nextField;
    Field currentField;
    Field previousField;

    HashMap<String, Equipment> equipmentList = new HashMap();

    int currentHealth;
    int maxHealth;

    int direction = Globals.DIRECTION;

    public LocalPrince(Prince prince) {
        this.prince = prince;

        this.nextField = prince.look(this.direction);
        this.currentField = prince.look(0);
        this.previousField = prince.look(Direction.changeDirection(this.direction));

        this.currentHealth = prince.getHealth();
        this.maxHealth = prince.getMaxHealth();

        for (Equipment eq : prince.getInventory()) {
            equipmentList.put(eq.getName(), eq);
        }
    }

    public Action move(int direction) {
        if (direction == Direction.FORWARD) return new MoveForward();
        if (direction == Direction.BACKWARD) return new MoveBackward();
        throw new IllegalArgumentException();
    }

    public Action jump(int direction) {
        if (direction == Direction.FORWARD) return new JumpForward();
        if (direction == Direction.BACKWARD) return new JumpBackward();
        throw new IllegalArgumentException();
    }

    public Action pickUp() {
        return new Grab();
    }

    public Action decide() {
        if (nextField == null) {
            Globals.DIRECTION = Direction.changeDirection(Globals.DIRECTION);
            direction = Globals.DIRECTION;
            return move(direction);
        }
        return new Context(this, Globals.GATE_FIELD ? currentField : nextField).executeStrategy();
    }
}
