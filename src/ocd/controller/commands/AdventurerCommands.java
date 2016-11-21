package ocd.controller.commands;

import ocd.controller.OCDCommand;
import ocd.controller.commands.adventurers.CreateCommand;
import ocd.controller.commands.adventurers.ListCommand;
import ocd.controller.commands.adventurers.SwitchCommand;
import ocd.dao.interfaces.AdventurerDAO;
import ocd.dao.interfaces.LordDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class AdventurerCommands extends OCDCommand {

    public AdventurerCommands(LordDAO lordDAO, AdventurerDAO adventurerDAO) {
        super("adventurer", 1, "group of commands for an adventurer");

        subCommands.add(new CreateCommand(adventurerDAO));
        subCommands.add(new ListCommand(adventurerDAO));
        subCommands.add(new SwitchCommand(lordDAO, adventurerDAO));
    }

    @Override
    public void execute() {

    }

    @Override
    public String getSyntax() {
        return getName() + " <action>";
    }
}
