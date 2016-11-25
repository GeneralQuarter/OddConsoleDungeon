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
                List<Item> inventory = inventoryDAO.getInventory(entity);
                OCDConsole.printlnRender("@|cyan,bold Inventory (" +
                        + inventory.size() + "/12):|@");
                for (Item item : inventory) {
                    OCDConsole.printRender(item.toString());
                }
                List<Item> equipment = inventoryDAO.getEquipment(entity);
                OCDConsole.printlnRender("@|cyan,bold Equipment (" +
                         + equipment.size() + "):|@");
                double totalBonusHealth = 0.0;
                double totalBonusDefense = 0.0;
                double totalBonusAttack = 0.0;
                double totalBonusCritical = 0.0;
                for (Item item : equipment) {
                    OCDConsole.printRender(item.toString());
                    totalBonusAttack += item.getBonusAttack();
                    totalBonusCritical += item.getBonusCritical();
                    totalBonusDefense += item.getBonusDefense();
                    totalBonusHealth += item.getBonusHealth();
                }
                OCDConsole.printlnRender("@|cyan,bold \nTotal bonuses: |@" +
                        " health = @|green,bold " + totalBonusHealth + "%|@" +
                        ", defense = @|green,bold " + totalBonusDefense + "%|@" +
                        ", attack = @|green,bold " + totalBonusAttack + "%|@" +
                        ", critical = @|green,bold " + totalBonusCritical + "%|@");
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
