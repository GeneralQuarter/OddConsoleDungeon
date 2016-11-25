package ocd.controller.commands.inventory;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.InventoryDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class UnEquipCommand extends OCDCommand {
    private InventoryDAO inventoryDAO;
    private EntityDAO entityDAO;

    public UnEquipCommand(InventoryDAO inventoryDAO, EntityDAO entityDAO) {
        super("unequip", 1, "unequip an item from the adventurer's inventory");
        this.inventoryDAO = inventoryDAO;
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        String idString = getArgs().get(0);
        try {
            int itemID = Integer.parseInt(idString);
            if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
                Entity entity = entityDAO.find(OCDController.currentAdventurer.getEntityID());
                if (entity != null) {
                    if (inventoryDAO.unequipItem(entity, itemID)) {
                        OCDConsole.printlnSuccess("The item has been unequipped.");
                    }
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
