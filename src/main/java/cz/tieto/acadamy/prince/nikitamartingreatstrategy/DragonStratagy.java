package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Use;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Obstacle;

class DragonStrategy implements Strategy {

    private Dragon dragon;
    private LocalPrince prince;

    public DragonStrategy(LocalPrince prince, Obstacle obstacle) {
        this.dragon = new Dragon(obstacle);
        this.prince = prince;
    }

    public Action execute() {
        if (dragon.isDead) return prince.move(prince.direction);
        if (prince.currentHealth < 6) {
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
        return new Use(sword, dragon.getObstacle());
    }
}
