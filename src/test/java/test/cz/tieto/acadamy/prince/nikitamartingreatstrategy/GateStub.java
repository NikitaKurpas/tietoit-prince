package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
 * Created by Nikita on 14-Apr-14.
 */
public class GateStub implements Field {
    @Override
    public Equipment getEquipment() {
        return null;
    }

    @Override
    public Obstacle getObstacle() {
        return null;
    }

    @Override
    public boolean isGate() {
        return true;
    }
}
