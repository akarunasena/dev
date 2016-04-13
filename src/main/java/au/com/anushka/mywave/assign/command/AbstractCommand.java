package au.com.anushka.mywave.assign.command;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Abstract Command that needs to be implemented to have a Concrete Command
 *
 * Provides extensible framework to implement more Commands
 */
public abstract class AbstractCommand implements Command{

    /**
     * Command Type Holder
     */
    private CommandType commandType;

    /**
     *
     * Get Command Type
     *
     * @return Command Type
     */
    public CommandType getCommandType() {
        return commandType;
    }

    /**
     * Set Command Type
     *
     * @param commandType Command Type
     */
    public void setCommandType(CommandType commandType) {
        this.commandType = commandType;
    }
}
