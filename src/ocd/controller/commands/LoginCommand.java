package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.controller.OCDController;
import ocd.dao.entities.Adventurer;
import ocd.dao.entities.Lord;
import ocd.dao.interfaces.AdventurerDAO;
import ocd.dao.interfaces.LordDAO;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class LoginCommand extends OCDCommand{
    private LordDAO lordDAO;
    private AdventurerDAO adventurerDAO;

    public LoginCommand(LordDAO lordDAO, AdventurerDAO adventurerDAO) {
        super("login", 2, "connect to play");
        this.lordDAO = lordDAO;
        this.adventurerDAO = adventurerDAO;
    }

    @Override
    public void execute() {
        String login = getArgs().get(0);
        String password = getArgs().get(1);
        Lord lord = lordDAO.connectUser(login, password);
        if (lord != null) {
            OCDController.currentLord = lord;
            OCDConsole.printlnSuccess("Connected with lord " + lord.getLogin());
            Adventurer adventurer = adventurerDAO.find(lord.getCurrentAdventurer());
            if (adventurer != null) {
                OCDController.currentAdventurer = adventurer;
            }
        }
    }

    @Override
    public String getSyntax() {
        return getName() + " <login> <password>";
    }
}
