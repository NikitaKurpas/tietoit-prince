package test.cz.tieto.acadamy.prince.nikitamartingreatstrategy;

import cz.tieto.acadamy.prince.nikitamartingreatstrategy.LocalPrince;
import cz.tieto.princegame.common.action.*;
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
        PrinceStub princeStub = new PrinceStub();

        while (true) {
            LocalPrince prince = new LocalPrince(princeStub);
            Action action = prince.decide();
            System.out.println("action = " + action.getClass());
            if (action instanceof MoveForward) {
                princeStub.position += 1;
                continue;
            }
            if (action instanceof MoveBackward) {
                princeStub.position -= 1;
                continue;
            }
            if (action instanceof JumpForward) {
                princeStub.position += 2;
                continue;
            }
            if (action instanceof JumpBackward) {
                princeStub.position -= 2;
                continue;
            }
            if (action instanceof EnterGate) {
                System.out.println("WIN");
                assertTrue(true);
                break;
            }
            if (action instanceof Heal) {
                princeStub.health += 5;
                continue;
            }
        }
//        assertTrue(prince.decide() instanceof JumpBackward);
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
