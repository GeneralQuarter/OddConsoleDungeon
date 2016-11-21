package ocd.controller.commands.adventurers;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Adventurer;
import ocd.dao.interfaces.AdventurerDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class CreateCommand extends OCDCommand {

    private AdventurerDAO adventurerDAO;

    public CreateCommand(AdventurerDAO adventurerDAO) {
        super("create", 1, "create a new adventurer");
        this.adventurerDAO = adventurerDAO;
    }

    @Override
    public void execute() {
        String name = getArgs().get(0);
        if (OCDController.verifyLordConnected()) {
            Adventurer adventurer = adventurerDAO.createAdventurer(OCDController.currentLord, name);
            if(adventurer != null) {
                OCDController.currentAdventurer = adventurer;
                OCDConsole.printlnSuccess("Adventurer created: ");
                OCDConsole.printlnRender(adventurer.toString());
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName() + " <adventurer name>";
    }
}
