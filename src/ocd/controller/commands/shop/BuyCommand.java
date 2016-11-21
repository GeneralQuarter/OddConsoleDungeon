package ocd.controller.commands.shop;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.interfaces.AdventurerDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class BuyCommand extends OCDCommand{

    private AdventurerDAO adventurerDAO;

    public BuyCommand(AdventurerDAO adventurerDAO) {
        super("buy", 1, "buy an item");
        this.adventurerDAO = adventurerDAO;
    }

    @Override
    public void execute() {
        String idString = getArgs().get(0);
        try {
            int itemID = Integer.parseInt(idString);
            if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
                if (adventurerDAO.buyItem(OCDController.currentAdventurer, itemID)) {
                    OCDConsole.printlnSuccess("Buy successful");
                }
            }
        } catch (NumberFormatException e) {
            OCDConsole.printlnError("The item id " + idString + " is not a number.");
        }
    }

    @Override
    public String getSyntax() {
        return getName() + " <item id>";
    }
}
