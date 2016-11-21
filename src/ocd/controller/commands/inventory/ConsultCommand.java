package ocd.controller.commands.inventory;

import ocd.controller.OCDCommand;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class ConsultCommand extends OCDCommand{

    public ConsultCommand(String name, int numArgs, String description) {
        super("consult", 0, "display the inventory and equipped items of the adventurer");
    }

    @Override
    public void execute() {

    }

    @Override
    public String getSyntax() {
        return null;
    }
}
