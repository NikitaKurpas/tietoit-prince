package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
 * Created by Nikita on 07/04/2014.
 */
public class FieldStub implements Field {
    @Override
    public Equipment getEquipment() {
        return null;
    }

    @Override
    public Obstacle getObstacle() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isGate() {
        throw new UnsupportedOperationException();
    }
}
