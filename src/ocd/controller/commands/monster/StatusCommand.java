package ocd.controller.commands.monster;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Monster;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.MonsterDAO;

/**
 * Created by Quentin Gangler on 23/11/2016.
 *
 */
public class StatusCommand extends OCDCommand{

    private MonsterDAO monsterDAO;
    private EntityDAO entityDAO;

    public StatusCommand(MonsterDAO monsterDAO, EntityDAO entityDAO) {
        super("status", 0, "display the status of the monster fought");
        this.monsterDAO = monsterDAO;
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            Monster monster = monsterDAO.getCurrentMonsterOfAdventurer(OCDController.currentAdventurer);
            if (monster != null) {
                Entity monsterEntity = entityDAO.find(monster.getEntityID());
                OCDConsole.printlnRender(monster.toString());
                OCDConsole.printlnRender(monsterEntity.toString());
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
