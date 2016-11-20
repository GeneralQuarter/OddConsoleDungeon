package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Entity;
import ocd.dao.interfaces.EntityDAO;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class StatusCommand extends OCDCommand{

    private EntityDAO entityDAO;

    public StatusCommand(EntityDAO entityDAO) {
        super("status", 0, "display the status of the current adventurer");
        this.entityDAO = entityDAO;
    }

    @Override
    public void execute() {
        if (OCDController.verifyLordConnected() && OCDController.verifyCurrentAdventurer()) {
            Entity entity = entityDAO.find(OCDController.currentAdventurer.getEntityID());
            OCDController.currentAdventurer.setStatus(entity.getStatus());
            OCDConsole.printlnRender(entity.toString());
        }
    }

    @Override
    public String getSyntax() {
        return getName();
    }
}
