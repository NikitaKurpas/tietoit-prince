package cz.tieto.acadamy.prince.nikitamartingreatstrategy.strategies;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.Dragon;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.LocalPrince;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Equipments;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Use;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Obstacle;

public class DragonStrategy {
    private Dragon dragon;
    private LocalPrince prince;

    public DragonStrategy(LocalPrince prince, Obstacle obstacle) {
        this.dragon = new Dragon(obstacle);
        this.prince = prince;
    }

    public Action execute() {
        if (dragon.isDead) return prince.move(prince.direction);
        if (prince.currentHealth < 6) {
            prince.globalFlags.HEAL_REQUIRED = true;
            prince.globalFlags.RETREAT = prince.globalFlags.DOUBLE_RETREAT = true;
            return new FieldAction(prince).chooseAction();
        }
        Equipment sword = prince.equipmentList.get(Equipments.SWORD);
        if (sword == null) {
            prince.globalFlags.DIRECTION.changeDirection(true);
            prince.readPrince(prince.originalPrince);
            return new FieldAction(prince).chooseAction();
        }
        return new Use(sword, dragon.getObstacle());
    }
}
