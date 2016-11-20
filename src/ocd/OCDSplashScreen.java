package ocd;

import java.util.Scanner;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class OCDSplashScreen {

    public OCDSplashScreen() {
        try {
            String logo = new Scanner(getClass().getClassLoader().getResourceAsStream("logo.txt")).useDelimiter("\\Z").next();
            String motd = new Scanner(getClass().getClassLoader().getResourceAsStream("motd.txt")).useDelimiter("\\Z").next();
            OCDConsole.printWithAttributes(logo, "white", "bold");
            OCDConsole.lineReturn();
            OCDConsole.printlnRender(motd);
        } catch (Exception e) {
            OCDConsole.printlnError("Can't open logo.txt: " + e.getMessage());
        }
    }
}
