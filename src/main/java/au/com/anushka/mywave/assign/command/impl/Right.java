package au.com.anushka.mywave.assign.command.impl;

import au.com.anushka.mywave.assign.command.AbstractCommand;
import au.com.anushka.mywave.assign.model.Robot;
import au.com.anushka.mywave.assign.model.TableTop;

/**
 * Created by akarunasena on 9/09/2015.
 */

/**
 * Performs a Right Operation on the Robot
 */
public class Right extends AbstractCommand {

    public Boolean execute(Robot robot, TableTop tableTop) {

        final Boolean valid = valid(robot, tableTop);

        if (valid) {

            //Direction North will be EAST
            if (Robot.Direction.NORTH.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.EAST);
                //Direction WEST will be NORTH
            } else if (Robot.Direction.WEST.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.NORTH);
                //Direction SOUTH will be WEST
            } else if (Robot.Direction.SOUTH.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.WEST);
                //Direction EAST will be SOUTH
            } else if (Robot.Direction.EAST.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.SOUTH);
            }
            robot.setPreviousCommand(this);

            return true;

        }

        return false;
    }
}
