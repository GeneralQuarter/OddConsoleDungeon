package ocd.controller.commands.adventurers;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Lord;
import ocd.dao.interfaces.AdventurerDAO;
import ocd.dao.interfaces.LordDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class SwitchCommand extends OCDCommand {

    private LordDAO lordDAO;
    private AdventurerDAO adventurerDAO;

    public SwitchCommand(LordDAO lordDAO, AdventurerDAO adventurerDAO) {
        super("switch", 1, "change to another adventurer");
        this.lordDAO = lordDAO;
        this.adventurerDAO = adventurerDAO;
    }

    @Override
    public void execute() {
        String idString = getArgs().get(0);
        try {
            int adventurerID = Integer.parseInt(idString);
            if (OCDController.verifyLordConnected()) {
                if (lordDAO.switchAdventurer(OCDController.currentLord, adventurerID)) {
                    Lord lord = lordDAO.find(OCDController.currentLord.getId());
                    if(lord != null) {
                        OCDController.currentLord = lord;
                        Adventurer adventurer = adventurerDAO.find(lord.getCurrentAdventurer());
                        if (adventurer != null) {
                            OCDController.currentAdventurer = adventurer;
                            OCDConsole.printlnSuccess("Switched to " + adventurer.getName());
                        }
                    }
                }
            }
        } catch (NumberFormatException e) {
            OCDConsole.printlnError("The id " + idString + " is not a number.");
        }
    }

    @Override
    public String getSyntax() {
        return getName() + " <adventurer id>";
    }
}
