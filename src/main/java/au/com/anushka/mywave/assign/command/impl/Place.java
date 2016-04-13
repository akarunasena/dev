package au.com.anushka.mywave.assign.command.impl;

import au.com.anushka.mywave.assign.command.AbstractCommand;
import au.com.anushka.mywave.assign.model.Robot;
import au.com.anushka.mywave.assign.model.TableTop;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Performs a Place Operation on the Robot
 */
public class Place extends AbstractCommand {

    /**
     * X Coordinate of the Place
     */
    private Integer locationX;

    /**
     * Y Coordinate of the Place
     */
    private Integer locationY;

    /**
     * Direction of the Robot
     */
    private Robot.Direction direction;

    public Boolean execute(final Robot robot, final TableTop tableTop) {

        final Boolean valid = valid(robot, tableTop);

        if (valid) {

            //Set Locations and Direction
            robot.setLocationX(this.locationX);
            robot.setLocationY(this.locationY);
            robot.setDirection(this.direction);

            //Set the Current Command as Previous Command
            robot.setPreviousCommand(this);

            return true;

        }

        return false;
    }

    public Boolean valid(final Robot robot, final TableTop tableTop) {

        //If Set X location is Greater than table width invalid
        if (this.locationX > tableTop.getWidth()) {
            return false;
        }

        //If Set Y location is Greater than table height invalid
        if (this.locationY > tableTop.getHeight()) {
            return false;
        }

        return true;
    }

    public Integer getLocationX() {
        return locationX;
    }

    public void setLocationX(Integer locationX) {
        this.locationX = locationX;
    }

    public Integer getLocationY() {
        return locationY;
    }

    public void setLocationY(Integer locationY) {
        this.locationY = locationY;
    }

    public Robot.Direction getDirection() {
        return direction;
    }

    public void setDirection(Robot.Direction direction) {
        this.direction = direction;
    }
}
