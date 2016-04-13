package au.com.anushka.mywave.assign.model;

import au.com.anushka.mywave.assign.command.Command;
import au.com.anushka.mywave.assign.command.impl.*;

import java.util.Map;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Denotes the Game and Its Operations
 */
public class Game {

    /**
     * Game has a Table Top
     */
     private TableTop tableTop;

    /**
     *Game has a Robot
     */
    private Robot robot;

    /**
     * Game has a Set of Commands to manipulate the Robot
     */
    private Map<Command.CommandType,Command> commandMap;

    public Boolean executeCommand(final Command.CommandType commandType, final String commandLine){

        if (Command.CommandType.PLACE.equals(commandType)){
            final String[] params = commandLine.split(",");
            if(params.length != 3) return false;
            final Integer x = Integer.valueOf(params[0]);
            final Integer y = Integer.valueOf(params[1]);
            final Robot.Direction direction= Robot.Direction.valueOf(params[2]);
            return place(x, y, direction);

        }else if (Command.CommandType.MOVE.equals(commandType)){
            return move();

        }else if (Command.CommandType.REPORT.equals(commandType)){
            return report();

        }else if (Command.CommandType.RIGHT.equals(commandType)){
            return right();

        }else if (Command.CommandType.LEFT.equals(commandType)){
            return left();
        }
        return false;
    }

    /**
     * Performs a Place on the Robot
     * @return True if executed
     */
    public Boolean place(final Integer x, final Integer y, final Robot.Direction direction){

        final Place commandPlace = (Place)commandMap.get(Command.CommandType.PLACE);

        //Set Direction and X and Y
        commandPlace.setLocationX(x);
        commandPlace.setLocationY(y);
        commandPlace.setDirection(direction);

        return commandPlace.execute(robot, tableTop);

    }

    /**
     * Performs a Move on the Robot
     * @return True if executed
     */
    public Boolean move(){

        final Move commandMove = (Move)commandMap.get(Command.CommandType.MOVE);

        //Execute the Movement
        return commandMove.execute(robot, tableTop);

    }

    /**
     * Performs a Report on the Robot
     * @return True if executed
     */
    public Boolean report(){

        final Report commandReport = (Report)commandMap.get(Command.CommandType.REPORT);

        //Execute the Movement
        return commandReport.execute(robot, tableTop);
    }


    /**
     * Performs a Left on the Robot
     * @return True if executed
     */
    public Boolean left(){

        final Left commandLeft = (Left)commandMap.get(Command.CommandType.LEFT);

        //Execute the Left
        return commandLeft.execute(robot, tableTop);
    }

    /**
     * Performs a Right on the Robot
     * @return True if executed
     */
    public Boolean right(){

        final Right commandRight = (Right)commandMap.get(Command.CommandType.RIGHT);

        //Execute the right
        return commandRight.execute(robot, tableTop);

    }

    public TableTop getTableTop() {
        return tableTop;
    }

    public void setTableTop(TableTop tableTop) {
        this.tableTop = tableTop;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }

    public Map<Command.CommandType, Command> getCommandMap() {
        return commandMap;
    }

    public void setCommandMap(Map<Command.CommandType, Command> commandMap) {
        this.commandMap = commandMap;
    }

}
