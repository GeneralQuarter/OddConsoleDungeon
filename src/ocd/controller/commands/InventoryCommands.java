package ocd.controller.commands;

import ocd.controller.OCDCommand;
import ocd.controller.commands.inventory.ConsultCommand;
import ocd.controller.commands.inventory.EquipCommand;
import ocd.controller.commands.inventory.UnEquipCommand;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.InventoryDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class InventoryCommands extends OCDCommand {

    public InventoryCommands(InventoryDAO inventoryDAO, EntityDAO entityDAO) {
        super("inventory", 1, "group of commands to interact with the adventurer inventories");

        subCommands.add(new ConsultCommand(inventoryDAO, entityDAO));
        subCommands.add(new EquipCommand(inventoryDAO, entityDAO));
        subCommands.add(new UnEquipCommand(inventoryDAO, entityDAO));
    }

    @Override
    public void execute() {

    }

    @Override
    public String getSyntax() {
        return getName() + " <action>";
    }
}
