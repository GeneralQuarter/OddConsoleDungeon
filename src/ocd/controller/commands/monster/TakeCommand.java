package ocd.controller.commands.monster;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Monster;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.InventoryDAO;
import ocd.dao.interfaces.MonsterDAO;

/**
 * Created by Quentin Gangler on 23/11/2016.
 *
 */
public class TakeCommand extends OCDCommand {

    private MonsterDAO monsterDAO;
    private EntityDAO entityDAO;
    private InventoryDAO inventoryDAO;

    public TakeCommand(MonsterDAO monsterDAO, EntityDAO entityDAO, InventoryDAO inventoryDAO) {
        super("take", 1, "take an item from the loot of the monster");
        this.monsterDAO = monsterDAO;
        this.entityDAO = entityDAO;
        this.inventoryDAO = inventoryDAO;
    }

    @Override
    public void execute() {
        String idString = getArgs().get(0);
        try {
            int itemID = Integer.parseInt(idString);
            if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
                Monster monster = monsterDAO.getCurrentMonsterOfAdventurer(OCDController.currentAdventurer);
                if (monster != null) {
                    Entity monsterEntity = entityDAO.find(monster.getEntityID());
                    Entity adventurerEntity = entityDAO.find(OCDController.currentAdventurer.getEntityID());
                    if (monsterEntity != null && adventurerEntity != null) {
                        if (inventoryDAO.moveItem(monsterEntity.getEquipmentId(), adventurerEntity.getInventoryId(), itemID)) {
                            OCDConsole.printlnSuccess("Item looted.");
                        }
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
