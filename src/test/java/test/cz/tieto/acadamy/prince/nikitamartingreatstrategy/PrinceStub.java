package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

//import cz.tieto.acadamy.prince.nikitamartingreatstrategy.Context;
//import cz.tieto.acadamy.prince.nikitamartingreatstrategy.Direction;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.LocalPrince;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.NikitaMartinGreatStrategy;
import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Nikita on 07/04/2014.
 */
class PrinceStub implements Prince {

    @Override
    public Field look(int distance) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<Equipment> getInventory() {
        return new ArrayList<>();
    }

    @Override
    public int getMaxHealth() {
        return 50;
    }

    @Override
    public int getHealth() {
        return 50;
    }

    @Override
    public int getId() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getProperty(String propertyName) {
        throw new UnsupportedOperationException();
    }
}

