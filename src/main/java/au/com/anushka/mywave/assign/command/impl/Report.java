package au.com.anushka.mywave.assign.command.impl;

import au.com.anushka.mywave.assign.command.AbstractCommand;
import au.com.anushka.mywave.assign.model.Robot;
import au.com.anushka.mywave.assign.model.TableTop;

/**
 * Created by akarunasena on 8/09/2015.
 */

/**
 * Performs a Report Operation on the Robot
 */
public class Report extends AbstractCommand {

    //Set the Last Report
    private String lastReport;

    public String getLastReport() {
        return lastReport;
    }

    public void setLastReport(String lastReport) {
        this.lastReport = lastReport;
    }

    public Boolean execute(final Robot robot, final TableTop tableTop) {

        final Boolean valid = valid(robot, tableTop);

        if (valid) {

            final StringBuilder sb = new StringBuilder(128);
            sb.append("Output: ").append(robot.getLocationX()).append(",")
                    .append(robot.getLocationY()).append(",")
                    .append(robot.getDirection());

            this.lastReport = sb.toString();

            System.out.println(lastReport);

            //Set the Current Command as Previous Command
            robot.setPreviousCommand(this);

            return true;

        }

        return false;
    }

    public Boolean valid(final Robot robot, final TableTop tableTop) {

        //First Command Can only be a PLACE
        if (robot.getPreviousCommand() == null) {
            return false;
        }

        return true;
    }
}
