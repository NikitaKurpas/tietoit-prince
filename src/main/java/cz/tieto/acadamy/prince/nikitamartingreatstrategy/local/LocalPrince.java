package cz.tieto.acadamy.prince.nikitamartingreatstrategy.local;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.strategies.FieldAction;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Direction;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.GlobalFlags;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.LocalFlags;
import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Prince;
import org.apache.commons.lang.ObjectUtils;

import java.util.HashMap;
import java.util.Map;

/**
* Created by Nikita on 07/04/2014.
*/
public class LocalPrince {
    // PUBLIC FIELDS
    public FieldSet fieldSet = new FieldSet();
    public Direction direction = new Direction();
    public LocalFlags localFlags;
    public GlobalFlags globalFlags;
    public Map<String, Equipment> equipmentList = new HashMap<>();
    public int currentHealth;
    public int maxHealth;
    public Prince originalPrince;

    public void readLocalFlags(LocalFlags flags) {
        this.localFlags = flags;
    }

    public void readGlobalFlags(GlobalFlags flags) {
        this.direction = flags.DIRECTION;
        this.globalFlags = flags;
    }

    public void readDirection() {
        this.direction = this.globalFlags.DIRECTION;
    }

    public void readPrince(Prince prince) {
        this.originalPrince = prince;
        if (globalFlags != null) {
            direction = globalFlags.DIRECTION;
        }
        System.out.println("[DEBUG] DIRECTION = " + direction.getDirection());

        this.fieldSet.nextField = prince.look(this.direction.getDirection()); // CURRENT DIRECTION
        this.fieldSet.currentField = prince.look(Direction.CURRENT); // CURRENT FIELD
        this.fieldSet.previousField = prince.look(this.direction.changeDirection(false)); // OPPOSITE DIRECTION

        this.currentHealth = prince.getHealth();
        this.maxHealth = prince.getMaxHealth();

        if (localFlags == null) localFlags = new LocalFlags();

        if (currentHealth >= maxHealth) {
            globalFlags.HEAL_REQUIRED = false;
        } else {
            if (currentHealth <= 4 && !globalFlags.HEAL_REQUIRED) {
                globalFlags.RETREAT = true;
                globalFlags.HEAL_REQUIRED = true;
            }
        }

        if (fieldSet.nextField == null) {
            System.out.println("[DEBUG] CHANGE DIRECTION");
            globalFlags.DIRECTION.changeDirection(true);
            readPrince(originalPrince);
            return;
        }

        for (Equipment eq : prince.getInventory()) {
            equipmentList.put(eq.getName(), eq);
        }
    }

    public Action move(Direction direction) {
        System.out.println("[DEBUG] MOVE " + (direction.getDirection() == 1 ? "FORWARD" : "BACKWARD"));
        if (direction.getDirection() == Direction.FORWARD) return new MoveForward();
        if (direction.getDirection() == Direction.BACKWARD) return new MoveBackward();
        throw new IllegalArgumentException();
    }

    public Action move(int direction) {
        if (direction == Direction.FORWARD) return new MoveForward();
        if (direction == Direction.BACKWARD) return new MoveBackward();
        throw new IllegalArgumentException();
    }

    public Action jump(Direction direction) {
        System.out.println("[DEBUG] JUMP " + (direction.getDirection() == 1 ? "FORWARD" : "BACKWARD"));
        if (direction.getDirection() == Direction.FORWARD) return new JumpForward();
        if (direction.getDirection() == Direction.BACKWARD) return new JumpBackward();
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

    public Action heal() {
        return new Heal();
    }

    public Action enterGate() {
        return new EnterGate();
    }

    public Action decide() {
        if (Helpers.isEquipmentField(fieldSet.currentField)) {
            return this.pickUp();
        }
        if (Helpers.isGateField(fieldSet.currentField)) {
            return this.enterGate();
        }
        return new FieldAction(this).chooseAction();
    }
}
