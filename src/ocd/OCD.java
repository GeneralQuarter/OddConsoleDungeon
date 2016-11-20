package ocd;

import ocd.controller.OCDController;
import ocd.dao.DAOFactory;
import org.fusesource.jansi.AnsiConsole;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Created by t00191774 on 16/11/2016.
 *
 */
public class OCD {
    public static void main(String[] args) {
        //Initialization
        AnsiConsole.systemInstall();
        OCDConsole.clearScreen();
        OCDSplashScreen screen = new OCDSplashScreen();
        DAOFactory daoFactory = DAOFactory.getDAOFactory(DAOFactory.ORACLE);

        //Start game
        OCDController controller = new OCDController(daoFactory);

        //Exit
        daoFactory.actionsOnClose();
        AnsiConsole.systemUninstall();
    }
}
