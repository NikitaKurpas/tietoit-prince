package cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables;

/**
* Created by Nikita on 07/04/2014.
*/
public class Direction {
    public static final int BACKWARD = -1;
    public static final int CURRENT = 0;
    public static final int FORWARD = 1;
    private int direction = FORWARD;

    public int changeDirection(boolean override) {
        int direction = this.direction * -1;
        if (override) {
            System.out.println("[DEBUG] OVERWRITTEN DIRECTION");
            this.direction = direction;
        }
        return direction;
    }

    public int getDirection() {
        return this.direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }
}
