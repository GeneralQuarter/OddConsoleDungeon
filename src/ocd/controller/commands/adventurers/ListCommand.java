package ocd.controller.commands.adventurers;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Adventurer;
import ocd.dao.interfaces.AdventurerDAO;

import java.util.List;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class ListCommand extends OCDCommand{

    private AdventurerDAO adventurerDAO;

    public ListCommand(AdventurerDAO adventurerDAO) {
        super("list", 0, "list all of your adventurers");
        this.adventurerDAO = adventurerDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected()) {
            List<Adventurer> adventurers = adventurerDAO.getAdventurersOfLord(OCDController.currentLord);
            for (Adventurer adventurer : adventurers) {
                if (OCDController.hasCurrentAdventurer() &&
                        adventurer.getId() == OCDController.currentAdventurer.getId()) {
                    OCDController.currentAdventurer.setStatus(adventurer.getStatus());
                }
                OCDConsole.printlnRender(adventurer.toString());
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
