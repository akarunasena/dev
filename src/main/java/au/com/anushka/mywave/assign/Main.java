package au.com.anushka.mywave.assign;

import au.com.anushka.mywave.assign.command.Command;
import au.com.anushka.mywave.assign.model.Game;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by akarunasena on 9/09/2015.
 */
public class Main {

    static Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args){

        BufferedReader br = null;
        try {

            //Load the Spring Configuration
            final ApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
            final Game game = (Game)context.getBean("game");

            //Load the file with the Commands
            final File commandFile = new File(game.getClass().getResource("/play.txt").getFile());

            br = new BufferedReader(new FileReader(commandFile));
            String line = br.readLine();

            while (line != null) {
                final String[] commands = line.split(" ");
                if(commands.length > 0){
                    final Command.CommandType commandType = Command.CommandType.valueOf(commands[0]);
                    String commandLine = null;
                    if(commands.length > 1) commandLine = commands[1];
                    final Boolean valid = game.executeCommand(commandType, commandLine);
                    log.debug("Execute Command Successfully : " + valid);
                }else {
                    log.error("No command found in line : " + line);
                }

                line = br.readLine();
            }
        } catch (Exception e){
            log.error("Error in Reading input", e);
        }finally {
            try {
                if(br != null)br.close();
            } catch (IOException e) {
                log.error("Error in Closing Reader", e);
            }
        }

    }
}
