package ocd;

import java.util.Scanner;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
class OCDSplashScreen {
    private String logo;
    private String motd;

    OCDSplashScreen() {
        try {
            logo = new Scanner(getClass().getClassLoader().getResourceAsStream("logo.txt")).useDelimiter("\\Z").next();
        } catch (Exception e) {
            OCDConsole.printlnError("Can't open logo.txt: " + e.getMessage());
            logo = "";
        }
        try {
            motd = new Scanner(getClass().getClassLoader().getResourceAsStream("motd.txt")).useDelimiter("\\Z").next();
        } catch (Exception e) {
            OCDConsole.printlnError("Can't open motd.txt: " + e.getMessage());
            motd = "";
        }
    }

    void show() {
        OCDConsole.printWithAttributes(logo, "white", "bold");
        OCDConsole.lineReturn();
        OCDConsole.printlnRender(motd);
    }
}
