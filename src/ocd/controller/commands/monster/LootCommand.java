package ocd.controller.commands.monster;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Item;
import ocd.dao.entities.Monster;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.ItemDAO;
import ocd.dao.interfaces.MonsterDAO;

import java.util.List;

/**
 * Created by Quentin Gangler on 23/11/2016.
 *
 */
public class LootCommand extends OCDCommand{

    private MonsterDAO monsterDAO;
    private ItemDAO itemDAO;
    private EntityDAO entityDAO;

    public LootCommand(MonsterDAO monsterDAO, ItemDAO itemDAO, EntityDAO entityDAO) {
        super("loot", 0, "consult the loot of the monster fought");
        this.monsterDAO = monsterDAO;
        this.itemDAO = itemDAO;
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            Monster monster = monsterDAO.getCurrentMonsterOfAdventurer(OCDController.currentAdventurer);
            if (monster != null) {
                Entity entity = entityDAO.find(monster.getEntityID());
                if(entity != null) {
                    List<Item> loot = itemDAO.consultLoot(OCDController.currentAdventurer);
                    OCDConsole.printlnRender("@|cyan,bold Loot of " + monster.getMonsterName() + ":|@");
                    for (Item item : loot) {
                        OCDConsole.printRender(item.toString());
                    }
                }
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
