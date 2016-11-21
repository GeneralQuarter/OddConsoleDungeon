package ocd.controller.commands;

import ocd.controller.OCDCommand;
import ocd.controller.commands.shop.*;
import ocd.controller.commands.shop.ExitCommand;
import ocd.dao.interfaces.AdventurerDAO;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.ItemDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class ShopCommands extends OCDCommand {

    public ShopCommands(ItemDAO itemDAO, EntityDAO entityDAO, AdventurerDAO adventurerDAO) {
        super("shop", 1, "group of commands for the shop");

        subCommands.add(new ConsultCommand(itemDAO));
        subCommands.add(new EnterCommand(entityDAO));
        subCommands.add(new BuyCommand(adventurerDAO));
        subCommands.add(new SellCommand(adventurerDAO));
        subCommands.add(new ExitCommand(entityDAO));
    }

    @Override
    public void execute() {

    }

    @Override
    public String getSyntax() {
        return getName() + " <action>";
    }
}
