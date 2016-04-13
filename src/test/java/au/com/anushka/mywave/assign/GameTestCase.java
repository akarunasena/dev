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
public class GameTestCase {

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
    public void test_Game_Commands_Scenario_A() throws Exception{

        game.place(0, 0, Robot.Direction.NORTH);

        game.move();

        game.report();

        final Report previousCommand = (Report)game.getRobot().getPreviousCommand();

        assertEquals("Report for Output", previousCommand.getLastReport(), "Output: 0,1,NORTH");

    }

    @Test
    public void test_Game_Commands_Scenario_B() throws Exception{

        game.place(0,0, Robot.Direction.NORTH);

        game.left();

        game.report();

        final Report previousCommand = (Report)game.getRobot().getPreviousCommand();

        assertEquals("Report for Output", previousCommand.getLastReport(), "Output: 0,0,WEST");

    }

    @Test
    public void test_Game_Commands_Scenario_C() throws Exception{

        game.place(1,2, Robot.Direction.EAST);

        game.move();

        game.move();

        game.left();

        game.move();

        game.report();

        final Report previousCommand = (Report)game.getRobot().getPreviousCommand();

        assertEquals("Report for Output", previousCommand.getLastReport(), "Output: 3,3,NORTH");

    }

}
