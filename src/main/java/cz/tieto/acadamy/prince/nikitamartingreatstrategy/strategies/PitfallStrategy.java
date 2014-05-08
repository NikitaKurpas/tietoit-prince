package cz.tieto.acadamy.prince.nikitamartingreatstrategy.strategies;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.LocalPrince;
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
        this.prince.globalFlags.DOUBLE_RETREAT = false;
        this.prince.globalFlags.RETREAT = false;
        return prince.jump(this.prince.direction);
    }
}
