package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

//import cz.tieto.acadamy.originalPrince.nikitamartingreatstrategy.Context;
//import cz.tieto.acadamy.originalPrince.nikitamartingreatstrategy.Direction;
import cz.tieto.princegame.common.gameobject.Equipment;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;

import java.util.*;

/**
 * Created by Nikita on 07/04/2014.
 */
class PrinceStub implements Prince {

    int health = 50;
    int maxHealth = 50;

    List<Equipment> equipment = new ArrayList<>();

    String map = "e,e,e,e,e,e,e,e,e,e,e,e,e,e,e,g,e,e,e,e";
    int position = 0;
    List<String> mapList = new ArrayList<>();

    public PrinceStub() {
        String[] map_ = map.split(",");

        Collections.addAll(mapList, map_);
    }

    @Override
    public Field look(int distance) {
        System.out.println(position);
        String field = "";
        if (distance == 1) {
            if (position + 1 > mapList.size() - 1) {
                return null;
            }
            field = mapList.get(position + 1);
        } else if (distance == -1) {
            if (position - 1 < 0) {
                return null;
            }
            field = mapList.get(position - 1);
        } else if (distance == 0) {
            field = mapList.get(position);
        }
        if ("e".equals(field)) return new FieldStub();
        if ("g".equals(field)) return new GateStub();

        // default action
        return null;
    }

    public void addItem() {
        if (mapList.get(position).equals("s")) {
            equipment.add(new Equipment() {
                @Override
                public int getId() {
                    return 0;
                }

                @Override
                public String getName() {
                    return "sword";
                }

                @Override
                public String getProperty(String s) {
                    return null;
                }
            });
        }
    }

    @Override
    public Collection<Equipment> getInventory() {
        return equipment;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getHealth() {
        return health;
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

