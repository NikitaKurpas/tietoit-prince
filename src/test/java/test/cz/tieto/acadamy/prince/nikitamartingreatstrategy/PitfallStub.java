package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Obstacle;

/**
 * Created by Nikita on 07/04/2014.
 */
public class PitfallStub implements Obstacle {
    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return "pitfall";
    }

    @Override
    public String getProperty(String propertyName) {
        return null;
    }
}
