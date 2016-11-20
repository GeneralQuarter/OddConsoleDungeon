package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;

import java.util.List;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class HelpCommand extends OCDCommand {
    private List<OCDCommand> commands;

    public HelpCommand(List<OCDCommand> commands) {
        super("help", 0, "List all the commands and their description");
        this.commands = commands;
    }

    @Override
    public void execute() {
        OCDConsole.printlnRender("@|cyan,bold Commands: |@");
        for(OCDCommand command : commands) {
            OCDConsole.printRender(command.getHelpText());
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
