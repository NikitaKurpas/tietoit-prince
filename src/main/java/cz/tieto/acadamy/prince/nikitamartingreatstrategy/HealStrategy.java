package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.action.Heal;

/**
* Created by Nikita on 07/04/2014.
*/
class HealStrategy implements Strategy {
    public Action execute() {
        return new Heal();
    }
}
