package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.entities.Monster;
import ocd.dao.interfaces.AdventurerDAO;
import ocd.dao.interfaces.EntityDAO;
import ocd.dao.interfaces.MonsterDAO;

/**
 * Created by Quentin Gangler on 21/11/2016.
 *
 */
public class FightCommand extends OCDCommand {

    private AdventurerDAO adventurerDAO;
    private MonsterDAO monsterDAO;
    private EntityDAO entityDAO;

    public FightCommand(AdventurerDAO adventurerDAO, MonsterDAO monsterDAO, EntityDAO entityDAO) {
        super("fight", 0, "fight the next monster in the dungeon");
        this.adventurerDAO = adventurerDAO;
        this.monsterDAO = monsterDAO;
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            if (adventurerDAO.nextFight(OCDController.currentAdventurer)) {
                Monster monster = monsterDAO.getCurrentMonsterOfAdventurer(OCDController.currentAdventurer);
                Entity adventurerEntity = entityDAO.find(OCDController.currentAdventurer.getEntityID());
                if (adventurerEntity.getStatus().equals("dead")) {
                    OCDConsole.printlnError("WASTED!");
                    OCDConsole.printlnRender("@|cyan,bold You died fighting the evil in the dungeon |@");
                } else {
                    if (monster != null) {
                        OCDConsole.printlnSuccess("YOU DEFEATED");
                        OCDConsole.printlnRender("@|cyan,bold You killed " + monster.getMonsterName() + "|@");
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
