package cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.Direction;
import cz.tieto.acadamy.prince.nikitamartingreatstrategy.variables.GlobalFlags;
import cz.tieto.princegame.common.GameStrategy;
import cz.tieto.princegame.common.action.*;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Prince;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.junit.Assert.*;

/**
 * LocalPrince Tester.
 *
 * @author <Authors name>
 * @since <pre>Apr 7, 2014</pre>
 * @version 1.0
 */
public class EndFieldTest {

    @Test
    public void notGettingStuckInTheRightMostField() {
        Map<String, GameStrategy> strategies = buildStrategies();

        for (Map.Entry<String, GameStrategy> entry : strategies.entrySet()) {
            notGettingStuckInTheRightMostField(entry.getKey(), entry.getValue());
        }
    }

    @Test
    public void notGettingStuckInTheLeftMostField() {
        Map<String, GameStrategy> strategies = buildStrategies();

        for (Map.Entry<String, GameStrategy> entry : strategies.entrySet()) {
            notGettingStuckInTheLeftMostField(entry.getKey(), entry.getValue());
        }
    }

    private Map<String, GameStrategy> buildStrategies() {
        Map<String, GameStrategy> strategies = new HashMap<>();

        NikitaMartinGreatStrategy strategyForward = new NikitaMartinGreatStrategy();
        // STRATEGY DEPENDENT
        // Set direction of a strategy
        GlobalFlags flags = new GlobalFlags();
        flags.DIRECTION.setDirection(Direction.FORWARD);
        strategyForward.setGlobalFlags(flags);
        // STRATEGY DEPENDENT

        strategies.put("strategy forward", strategyForward);

        NikitaMartinGreatStrategy strategyBackward = new NikitaMartinGreatStrategy();
        flags = new GlobalFlags();
        flags.DIRECTION.setDirection(Direction.BACKWARD);
        strategyBackward.setGlobalFlags(flags);

        strategies.put("strategy backward", strategyBackward);
        return strategies;
    }

    public void notGettingStuckInTheRightMostField(String name, GameStrategy strategy) {
        // GIVEN: The prince stands at the rightmost field
        Prince princeMock = Mockito.mock(Prince.class);

        Mockito.when(princeMock.look(1)).thenReturn(null);

        Field fieldMock0 = Mockito.mock(Field.class);
        Mockito.when(princeMock.look(0)).thenReturn(fieldMock0);

        Field fieldMockBackward = Mockito.mock(Field.class);
        Mockito.when(princeMock.look(-1)).thenReturn(fieldMockBackward);

        // WHEN:  He is going ot make a step
        Action action = strategy.step(princeMock);

        // THEN:  He does not move in the forward direction
        assertFalse(name, action instanceof MoveForward);

        // AND:   He does not jump in the forward direction
        assertFalse(name, action instanceof JumpForward);
    }

    public void notGettingStuckInTheLeftMostField(String name, GameStrategy strategy) {
        // GIVEN: The prince stands at the rightmost field
        Prince princeMock = Mockito.mock(Prince.class);

        Mockito.when(princeMock.look(-1)).thenReturn(null);

        Field fieldMock0 = Mockito.mock(Field.class);
        Mockito.when(princeMock.look(0)).thenReturn(fieldMock0);

        Field fieldMockForeward = Mockito.mock(Field.class);
        Mockito.when(princeMock.look(1)).thenReturn(fieldMockForeward);

        // WHEN:  He is going ot make a step
        Action action = strategy.step(princeMock);

        // THEN:  He does not move in the forward direction
        assertFalse(name, action instanceof MoveBackward);

        // AND:   He does not jump in the forward direction
        assertFalse(name, action instanceof JumpBackward);
    }

}
