package ocd.controller.commands;

import ocd.controller.OCDCommand;
import ocd.controller.commands.monster.*;
import ocd.controller.commands.monster.StatusCommand;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.InventoryDAO;
import ocd.dao.interfaces.ItemDAO;
import ocd.dao.interfaces.MonsterDAO;

/**
 * Created by Quentin Gangler on 23/11/2016.
 *
 */
public class MonsterCommands extends OCDCommand{

    public MonsterCommands(MonsterDAO monsterDAO, EntityDAO entityDAO, ItemDAO itemDAO, InventoryDAO inventoryDAO) {
        super("monster", 1, "group of commands related to the monster fought");

        subCommands.add(new StatusCommand(monsterDAO, entityDAO));
        subCommands.add(new LootCommand(monsterDAO, itemDAO, entityDAO));
        subCommands.add(new TakeCommand(monsterDAO, entityDAO, inventoryDAO));
    }

    @Override
    public void execute() {

    }

    @Override
    public String getSyntax() {
        return getName() + " <action>";
    }
}
