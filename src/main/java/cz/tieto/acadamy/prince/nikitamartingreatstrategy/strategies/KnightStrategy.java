package cz.tieto.acadamy.prince.nikitamartingreatstrategy.strategies;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.Knight;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.LocalPrince;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Equipments;
import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Use;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
*/
class KnightStrategy implements Strategy {

    private Knight knight;
    private LocalPrince prince;

    public KnightStrategy(LocalPrince prince, Obstacle obstacle) {
        this.knight = new Knight(obstacle);
        this.prince = prince;
    }

    public Action execute() {
        if (knight.isDead) return prince.move(prince.direction);
        if (prince.globalFlags.HEAL_REQUIRED) {
            prince.globalFlags.RETREAT = true;
            return new FieldAction(prince).chooseAction();
        }
        Equipment sword = prince.equipmentList.get(Equipments.SWORD);
        if (sword == null) {
            prince.globalFlags.DIRECTION.changeDirection(true);
            prince.readPrince(prince.originalPrince);
            return new FieldAction(prince).chooseAction();
        }
        return new Use(sword, knight.getObstacle());
    }
}
