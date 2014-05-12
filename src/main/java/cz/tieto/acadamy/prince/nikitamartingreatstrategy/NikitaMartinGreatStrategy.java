package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.local.LocalPrince;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.GlobalFlags;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.LocalFlags;
import cz.tieto.princegame.common.GameStrategy;
import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.Prince;

public class NikitaMartinGreatStrategy implements GameStrategy {

    LocalPrince localPrince = new LocalPrince();
    GlobalFlags globalFlags = new GlobalFlags();

    @Override
    public Action step(Prince prince) {
        localPrince.readGlobalFlags(globalFlags);
        localPrince.readLocalFlags(new LocalFlags());
        localPrince.readPrince(prince);
        return localPrince.decide();
    }

    void setGlobalFlags(GlobalFlags flags) {
        this.globalFlags = flags;
    }

}
