package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import org.mockito.Mockito;

/**
 * Created by Nikita on 12. 5. 2014.
 */
public class ObstacleFactory {

    public static Field getPitfall() {
        Field pitfallField = Mockito.mock(Field.class);
        Mockito.when(pitfallField.getObstacle()).thenReturn(new Obstacle() {
            @Override
            public int getId() {
                return 0;
            }

            @Override
            public String getName() {
                return "pitfall";
            }

            @Override
            public String getProperty(String s) {
                return null;
            }
        });
        Mockito.when(pitfallField.getEquipment()).thenReturn(null);
        Mockito.when(pitfallField.isGate()).thenReturn(false);
        return pitfallField;
    }

    public static Field getEmptyField() {
        Field field = Mockito.mock(Field.class);
        Mockito.when(field.isGate()).thenReturn(false);
        Mockito.when(field.getObstacle()).thenReturn(null);
        Mockito.when(field.getEquipment()).thenReturn(null);
        return field;
    }
}
