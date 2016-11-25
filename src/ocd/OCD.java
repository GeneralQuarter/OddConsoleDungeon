package ocd;

import ocd.controller.OCDController;
import ocd.dao.DAOFactory;
import org.fusesource.jansi.AnsiConsole;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OCD {
    public static void main(String[] args) {
        //Initialization
        AnsiConsole.systemInstall();
        OCDConsole.clearScreen();

        OCDSplashScreen splashScreen = new OCDSplashScreen();
        splashScreen.show();

        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.ORACLE);

        //Start game
        OCDController controller = new OCDController(daoFactory);
        controller.startGame();

        //Exit
        if (daoFactory != null) {
            daoFactory.actionsOnClose();
        }
        AnsiConsole.systemUninstall();
    }
}
