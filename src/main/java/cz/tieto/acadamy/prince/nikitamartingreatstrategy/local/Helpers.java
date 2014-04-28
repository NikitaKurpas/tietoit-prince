package cz.tieto.acadamy.prince.nikitamartingreatstrategy.local;

import cz.tieto.princegame.common.gameobject.Field;

/**
 * Created by Nikita on 26. 4. 2014.
 */
public class Helpers {

    public static boolean isEquipmentField(Field field) {
        return (field.getEquipment() != null);
    }

    public static boolean isGateField(Field field) {
        return (field.isGate());
    }

    public static boolean isObstacleField(Field field) {
        return (field.getObstacle() != null);
    }
}
