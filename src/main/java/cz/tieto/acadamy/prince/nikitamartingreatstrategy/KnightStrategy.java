package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

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
        if (prince.currentHealth <= prince.maxHealth / 3) {
            prince.direction = Direction.changeDirection(prince.direction);
            Globals.HEAL_REQUIRED = true;
            return new Context(prince, prince.previousField).executeStrategy();
        }
        Equipment sword = prince.equipmentList.get(Equipments.SWORD);
        if (sword == null) {
            Globals.DIRECTION = Direction.changeDirection(Globals.DIRECTION);
            prince.direction = Globals.DIRECTION;
            return new Context(prince, prince.previousField).executeStrategy();
        }
        return new Use(sword, knight.getObstacle());
    }
}
