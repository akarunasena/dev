package au.com.anushka.mywave.assign.command.impl;

import au.com.anushka.mywave.assign.command.AbstractCommand;
import au.com.anushka.mywave.assign.model.Robot;
import au.com.anushka.mywave.assign.model.TableTop;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Performs a Move Operation on the Robot
 */
public class Move extends AbstractCommand {

    public Boolean execute(final Robot robot,final TableTop tableTop) {

        final Boolean valid = valid(robot, tableTop);

        if (valid){

            //Move X or Y According to the Direction
            final Integer moveX = moveHorizontal(robot);
            final Integer moveY = moveVertical(robot);

            //Set the New Locations
            robot.setLocationY(moveY);
            robot.setLocationX(moveX);

            //Set the Current Command as Previous Command
            robot.setPreviousCommand(this);

            return true;

        }

        return false;
    }

    public Boolean valid(final Robot robot,final TableTop tableTop) {

        //First Command Can only be a PLACE
        if(robot.getPreviousCommand() == null){
            return false;
        }

        //Calculate X or Y According to the Direction
        final Integer moveX = moveHorizontal(robot);
        final Integer moveY = moveVertical(robot);

        //If Set X location is Greater than table width invalid
        //Or Negative is Invalid
        if (moveX > tableTop.getWidth() || moveX < 0){
            return false;
        }

        //If Set Y location is Greater than table height invalid
        //Or Negative is Invalid
        if (moveY > tableTop.getHeight() || moveY < 0) {
            return false;
        }

        return true;
    }

   private Integer moveVertical(final Robot robot){
        //Direction North Will Add 1 Step
        if (Robot.Direction.NORTH.equals(robot.getDirection())){
            return  robot.getLocationY() + 1;
        //Direction South Will Substract 1 Step
        }else if (Robot.Direction.SOUTH.equals(robot.getDirection())){
            return  robot.getLocationY() - 1;

        }

        return robot.getLocationY();
    }

    private Integer moveHorizontal(final Robot robot){

        //Direction West Will Substract 1 Step
        if (Robot.Direction.WEST.equals(robot.getDirection())) {
            return robot.getLocationX() - 1;
        //Direction East Will Add 1 Step
        }else if (Robot.Direction.EAST.equals(robot.getDirection())){
            return robot.getLocationX() + 1;
        }

        return robot.getLocationX();
    }
}