package ocd.controller.commands.shop;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Item;
import ocd.dao.interfaces.ItemDAO;

import java.util.List;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class ConsultCommand extends OCDCommand {

    private ItemDAO itemDAO;

    public ConsultCommand(ItemDAO itemDAO) {
        super("consult", 0, "consult the items in the shop");
        this.itemDAO = itemDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            List<Item> itemsInShop = itemDAO.consultShop(OCDController.currentAdventurer);
            for (Item item : itemsInShop) {
                OCDConsole.printRender(item.toString());
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
