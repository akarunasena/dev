package au.com.anushka.mywave.assign.command;

import au.com.anushka.mywave.assign.model.Robot;
import au.com.anushka.mywave.assign.model.TableTop;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * a Command needs to implement valid and execute
 */
public interface Command {

    /**
     * Command Types Allowed
     */
    public enum CommandType{
        MOVE,
        PLACE,
        REPORT,
        LEFT,
        RIGHT
    }

    /**
     * Get the Command Type
     * @return Command Type
     */
    public CommandType getCommandType();

    /**
     * Exceution logic of the command to operate on the robot
     * @param robot Robot for executing the command
     * @param tableTop Table top for the robot to move
     */
    public Boolean execute(final Robot robot,final TableTop tableTop);

    /**
     * Check the command is valid to execute
     * @param robot Robot for executing the command
     * @param tableTop Table top for the robot to move
     * @return True if valid
     */
    public Boolean valid(final Robot robot,final TableTop tableTop);

}
