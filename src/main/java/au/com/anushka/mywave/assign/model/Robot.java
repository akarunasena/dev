package au.com.anushka.mywave.assign.model;

import au.com.anushka.mywave.assign.command.Command;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Denotes a Robot in the Game
 */
public class Robot {

    /**
     * Current X Location of the Robot
     */
    private Integer locationX;

    /**
     * Current Y Location of the Robot
     */
    private Integer locationY;

    /**
     * Current Direction of the Robot
     */
    private Direction direction;

    /**
     * Last Executed Command on the Robot
     */
    private Command previousCommand;

    public enum Direction{
        NORTH,
        SOUTH,
        EAST,
        WEST
    }

    public Robot() {
    }

    public Robot(final Robot robot) {
        this.locationX = robot.getLocationX();
        this.locationY = robot.getLocationY();
        this.direction = robot.getDirection();
        this.previousCommand = robot.getPreviousCommand();
    }

    public Robot(final Integer locationX,final Integer locationY,final Direction direction) {
        this.locationX = locationX;
        this.locationY = locationY;
        this.direction = direction;
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

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Command getPreviousCommand() {
        return previousCommand;
    }

    public void setPreviousCommand(Command previousCommand) {
        this.previousCommand = previousCommand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (locationX != null ? !locationX.equals(robot.locationX) : robot.locationX != null) return false;
        if (locationY != null ? !locationY.equals(robot.locationY) : robot.locationY != null) return false;
        if (direction != robot.direction) return false;
        return !(previousCommand != null ? !previousCommand.equals(robot.previousCommand) : robot.previousCommand != null);

    }

    @Override
    public int hashCode() {
        int result = locationX != null ? locationX.hashCode() : 0;
        result = 31 * result + (locationY != null ? locationY.hashCode() : 0);
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (previousCommand != null ? previousCommand.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "locationX=" + locationX +
                ", locationY=" + locationY +
                ", direction=" + direction +
                ", previousCommand=" + previousCommand +
                '}';
    }
}
