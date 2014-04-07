package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;

/**
* Created by Nikita on 07/04/2014.
*/
class PitfallStrategy implements Strategy {

    private LocalPrince prince;

    public PitfallStrategy(LocalPrince prince) {
        this.prince = prince;
    }

    public Action execute() {
        return this.prince.jump(this.prince.direction);
    }
}
