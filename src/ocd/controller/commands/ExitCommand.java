package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class ExitCommand extends OCDCommand{

    public ExitCommand() {
        super("exit", 0, "Exit the game");
    }

    @Override
    public void execute() {
        OCDConsole.printlnSuccess("Exiting the game...");
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
