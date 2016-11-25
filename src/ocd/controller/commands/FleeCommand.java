package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.interfaces.AdventurerDAO;

/**
 * Created by Quentin Gangler on 24/11/2016.
 *
 */
public class FleeCommand extends OCDCommand {

    private AdventurerDAO adventurerDAO;

    public FleeCommand(AdventurerDAO adventurerDAO) {
        super("flee", 0, "flee the dungeon");
        this.adventurerDAO = adventurerDAO;
    }

    @Override
    public void execute() {
        if (OCDController.isLordConnected() && OCDController.verifyCurrentAdventurer()) {
            if (adventurerDAO.flee(OCDController.currentAdventurer)) {
                OCDConsole.printlnSuccess("You fled! (We can call you pussycat now)");
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
