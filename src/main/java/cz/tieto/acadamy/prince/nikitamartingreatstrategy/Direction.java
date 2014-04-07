package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

/**
* Created by Nikita on 07/04/2014.
*/
class Direction {
    public static final int BACKWARD = -1;
    public static final int FORWARD = 1;

    public static int changeDirection(int direction) {
        return direction * -1;
    }
}
