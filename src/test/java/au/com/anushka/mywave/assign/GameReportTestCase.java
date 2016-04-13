package au.com.anushka.mywave.assign;

import au.com.anushka.mywave.assign.command.impl.Report;
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
public class GameReportTestCase {

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
    public void test_In_Valid_Report_Without_Place_Test() throws Exception{

        final Boolean reportValid = game.report();

        assertFalse("In Valid Report", reportValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(0));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(0));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.NORTH);

    }

    @Test
    public void test_Valid_Report_After_Place_Test() throws Exception{

        final Boolean palcetValid = game.place(3,2, Robot.Direction.SOUTH);

        assertTrue("Valid Placement", palcetValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

        final Boolean reportValid = game.report();

        assertTrue("Valid Report", reportValid);
        assertEquals("Unchanged X", game.getRobot().getLocationX(), new Integer(3));
        assertEquals("Unchanged Y", game.getRobot().getLocationY(), new Integer(2));
        assertEquals("Unchanged Direction", game.getRobot().getDirection(), Robot.Direction.SOUTH);

        final Report previousCommand = (Report)game.getRobot().getPreviousCommand();
        assertEquals("Check Report", previousCommand.getLastReport(), "Output: 3,2,SOUTH");


    }
}
