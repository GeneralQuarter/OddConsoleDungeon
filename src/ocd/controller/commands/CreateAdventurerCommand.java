package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Adventurer;
import ocd.dao.interfaces.AdventurerDAO;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class CreateAdventurerCommand extends OCDCommand{

    private AdventurerDAO adventurerDAO;

    public CreateAdventurerCommand(AdventurerDAO adventurerDAO) {
        super("adventurers.create", 1, "create a new adventurer");
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
