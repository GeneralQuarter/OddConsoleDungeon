package ocd.controller.commands;

import ocd.OCDConsole;
import ocd.controller.OCDCommand;
import ocd.dao.interfaces.LordDAO;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class RegisterCommand extends OCDCommand{
    private LordDAO lordDAO;

    public RegisterCommand(LordDAO lordDAO) {
        super("register", 3, "create a new lord account");
        this.lordDAO = lordDAO;
    }

    @Override
    public void execute() {
        String login = getArgs().get(0);
        String pass1 = getArgs().get(1);
        String pass2 = getArgs().get(2);
        if (lordDAO.createLord(login, pass1, pass2)) {
            OCDConsole.printlnSuccess("Lord " + login + " created! Use the login command to connect");
        }
    }

    @Override
    public String getSyntax() {
        return getName() + " <lord name> <password> <repeat password>";
    }
}
