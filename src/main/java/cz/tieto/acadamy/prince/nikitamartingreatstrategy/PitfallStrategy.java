package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;

import javax.xml.bind.annotation.XmlElementDecl;

/**
* Created by Nikita on 07/04/2014.
*/
class PitfallStrategy implements Strategy {

    private LocalPrince prince;

    public PitfallStrategy(LocalPrince prince) {
        this.prince = prince;
    }

    public Action execute() {
        return prince.jump(this.prince.direction);
    }
}
