package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.LocalPrince;
import cz.tieto.princegame.common.action.JumpBackward;
import cz.tieto.princegame.common.gameobject.Field;
import cz.tieto.princegame.common.gameobject.Obstacle;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/** 
* LocalPrince Tester. 
* 
* @author <Authors name> 
* @since <pre>Apr 7, 2014</pre> 
* @version 1.0 
*/ 
public class LocalPrinceTest { 

    @Test
    public void testPitfall() {
        LocalPrince prince = new LocalPrince(new PrinceStub() {
            @Override
            public Field look(int direction) {
                if (direction == -1) {
                    return new FieldStub() {
                        @Override
                        public Obstacle getObstacle() {
                            return new PitfallStub();
                        }
                    };
                }
                if (direction == 1) {
                    return null;
                }
                if (direction == 0) {
                    return new FieldStub();
                }
                throw new IllegalArgumentException();
            }
        });

        assertTrue(prince.decide() instanceof JumpBackward);

    }
/** 
* 
* Method: move(int direction) 
* 
*/ 
@Test
public void testMove() throws Exception {

}

/** 
* 
* Method: jump(int direction) 
* 
*/ 
@Test
public void testJump() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: pickUp() 
* 
*/ 
@Test
public void testPickUp() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: decide() 
* 
*/ 
@Test
public void testDecide() throws Exception { 
//TODO: Test goes here... 
} 


} 
