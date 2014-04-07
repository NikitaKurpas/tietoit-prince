package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
* Created by Nikita on 07/04/2014.
*/
class ChopperStrategy implements Strategy {

    private Chopper chopper;
    private LocalPrince prince;

    public ChopperStrategy(LocalPrince prince, Obstacle obstacle) {
        this.chopper = new Chopper(obstacle);
        this.prince = prince;
    }

    public Action execute() {
        if (chopper.isOpening)
            return this.prince.jump(this.prince.direction);
        else
            return new HealStrategy().execute();
    }
}
