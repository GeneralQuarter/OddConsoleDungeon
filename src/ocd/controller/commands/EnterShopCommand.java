package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.interfaces.EntityDAO;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class EnterShopCommand extends OCDCommand {

    private EntityDAO entityDAO;

    public EnterShopCommand(EntityDAO entityDAO) {
        super("shop.enter", 0, "move the adventurer to the shop");
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            if (entityDAO.changeStatus(
                    entityDAO.find(OCDController.currentAdventurer.getEntityID()),
                    "shop")) {
                OCDController.currentAdventurer.setStatus("shop");
                OCDConsole.printlnSuccess(OCDController.currentAdventurer.getName() + " enters the shop");
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
