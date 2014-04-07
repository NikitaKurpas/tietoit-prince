package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.GameStrategy;
import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.*;

public class NikitaMartinGreatStrategy implements GameStrategy {

    @Override
    public Action step(Prince prince) {
        return new LocalPrince(prince).decide();
    }

}
