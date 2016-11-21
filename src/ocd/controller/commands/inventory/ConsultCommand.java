package ocd.controller.commands.inventory;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Item;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.InventoryDAO;

import java.util.List;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class ConsultCommand extends OCDCommand{

    private InventoryDAO inventoryDAO;
    private EntityDAO entityDAO;

    public ConsultCommand(InventoryDAO inventoryDAO, EntityDAO entityDAO) {
        super("consult", 0, "display the inventory and equipped items of the adventurer");
        this.inventoryDAO = inventoryDAO;
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            Entity entity = entityDAO.find(OCDController.currentAdventurer.getEntityID());
            if (entity != null) {
                OCDConsole.printlnRender("@|cyan,bold Inventory:|@");
                List<Item> inventory = inventoryDAO.getInventory(entity);
                for (Item item : inventory) {
                    OCDConsole.printlnRender(item.toString());
                }
                OCDConsole.printlnRender("@|cyan,bold Equipment:|@");
                List<Item> equipment = inventoryDAO.getEquipment(entity);
                for (Item item : equipment) {
                    OCDConsole.printlnRender(item.toString());
                }
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
