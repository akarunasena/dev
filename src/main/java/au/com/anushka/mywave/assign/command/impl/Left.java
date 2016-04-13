package au.com.anushka.mywave.assign.command.impl;

import au.com.anushka.mywave.assign.command.AbstractCommand;
import au.com.anushka.mywave.assign.model.Robot;
import au.com.anushka.mywave.assign.model.TableTop;

/**
 * Created by akarunasena on 9/09/2015.
 */

/**
 * Performs a Left Operation on the Robot
 */
public class Left extends AbstractCommand {

    public Boolean execute(Robot robot, TableTop tableTop) {

        final Boolean valid = valid(robot, tableTop);

        if (valid) {

            //Direction North will be WEST
            if (Robot.Direction.NORTH.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.WEST);
            //Direction WEST will be SOUTH
            } else if (Robot.Direction.WEST.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.SOUTH);
            //Direction SOUTH will be EAST
            } else if (Robot.Direction.SOUTH.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.EAST);
            //Direction EAST will be NORTH
            } else if (Robot.Direction.EAST.equals(robot.getDirection())) {
                robot.setDirection(Robot.Direction.NORTH);
            }
            robot.setPreviousCommand(this);

            return true;

        }

        return false;
    }

}
