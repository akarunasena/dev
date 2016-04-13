package au.com.anushka.mywave.assign;

import au.com.anushka.mywave.assign.model.Game;
import au.com.anushka.mywave.assign.model.Robot;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by akarunasena on 29/08/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/context-test.xml")
public class GamePlaceTestCase {

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
    public void test_Valid_Place_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.SOUTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

    }

    @Test
    public void test_Valid_Multiple_Place_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.SOUTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

        final Boolean placeValid1 = game.place(2,3, Robot.Direction.NORTH);

        assertTrue("Valid Placement", placeValid1);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(2));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(3));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }

    @Test
    public void test_InValid_X_Location_Place_Test() throws Exception{

        final Boolean placeValid = game.place(7,2, Robot.Direction.SOUTH);

        assertFalse("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }

    @Test
    public void test_InValid_Y_Location_PlaceTest() throws Exception{

        final Boolean placeValid = game.place(3,7, Robot.Direction.SOUTH);

        assertFalse("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }
}
