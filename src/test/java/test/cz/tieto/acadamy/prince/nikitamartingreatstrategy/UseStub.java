package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.princegame.common.action.Action;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Obstacle;

/**
 * Created by Nikita on 14-Apr-14.
 */
public class UseStub implements Action {

    public void use(Equipment equipment, Obstacle obstacle) {
        if (obstacle.getName().equals("dragon")) {
            ((DragonStub) obstacle).health -= 8;
        }
    }
}
