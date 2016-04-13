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
public class GameRightTestCase {

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
    public void test_In_Valid_Right_Without_Place_Test() throws Exception{

        final Boolean RightValid = game.right();

        assertFalse("In Valid right", RightValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }

    @Test
    public void test_Valid_Right_After_SOUTH_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.SOUTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

        final Boolean RightValid = game.right();

        assertTrue("Valid right", RightValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.WEST);

    }

    @Test
    public void test_Valid_Right_After_EAST_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.EAST);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.EAST);

        final Boolean RightValid = game.right();

        assertTrue("Valid right", RightValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

    }

    @Test
    public void test_Valid_Right_After_NORTH_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.NORTH);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

        final Boolean RightValid = game.right();

        assertTrue("Valid right", RightValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.EAST);

    }

    @Test
    public void test_Valid_Right_After_WEST_Test() throws Exception{

        final Boolean placeValid = game.place(3,2, Robot.Direction.WEST);

        assertTrue("Valid Placement", placeValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.WEST);

        final Boolean RightValid = game.right();

        assertTrue("Valid right", RightValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }
}
