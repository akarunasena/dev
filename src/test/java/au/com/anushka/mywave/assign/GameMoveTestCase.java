package au.com.anushka.mywave.assign;

import au.com.anushka.mywave.assign.model.Game;
import au.com.anushka.mywave.assign.model.Robot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by akarunasena on 9/09/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/context-test.xml")
public class GameMoveTestCase {

    @Autowired
    private Game game;

    @Before
    public void setUp() {
        //Reset the Config for Testing
        game.getRobot().setLocationX(0);
        game.getRobot().setLocationY(0);
        game.getRobot().setDirection(Robot.Direction.NORTH);
        game.getRobot().setPreviousCommand(null);
    }

    @Test
    public void test_In_Valid_Move_Without_Place_Test() throws Exception{

        final Boolean moveValid = game.move();

        assertFalse("In Valid Movement", moveValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }

    @Test
    public void test_Valid_Move_After_Place_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.SOUTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

        final Boolean moveValid = game.move();

        assertTrue("Valid Movement", moveValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(1));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);
    }

    @Test
    public void test_InValid_Move_Out_OF_Play_West_Test() throws Exception{

        final Boolean placeValid = game.place(0,0, Robot.Direction.WEST);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.WEST);

        final Boolean moveValid = game.move();

        assertFalse("In Valid Movement", moveValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.WEST);
    }

    @Test
    public void test_InValid_Move_Out_OF_Play_South_Test() throws Exception{

        final Boolean placeValid = game.place(0,0, Robot.Direction.SOUTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

        final Boolean moveValid = game.move();

        assertFalse("In Valid Movement", moveValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);
    }

    @Test
    public void test_InValid_Move_Out_OF_Play_North_Test() throws Exception{

        final Boolean placeValid = game.place(2,5, Robot.Direction.NORTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(2));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(5));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

        final Boolean moveValid = game.move();

        assertFalse("In Valid Movement", moveValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(2));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(5));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);
    }

    @Test
    public void test_InValid_Move_Out_OF_Play_East_Test() throws Exception{

        final Boolean placeValid = game.place(5,2, Robot.Direction.EAST);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(5));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.EAST);

        final Boolean moveValid = game.move();

        assertFalse("In Valid Movement", moveValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(5));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.EAST);
    }
}
