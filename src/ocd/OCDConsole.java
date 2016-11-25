package ocd;

import static org.fusesource.jansi.Ansi.ansi;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class OCDConsole {

    static void clearScreen() {
        System.out.println(ansi().eraseScreen());
    }

    static void lineReturn() {
        System.out.print("\n");
    }

    public static void printlnError(String msg) {
        OCDConsole.printWithAttributes(msg, "bg_red", "white", "bold");
        lineReturn();
    }

    public static void printlnSuccess(String msg) {
        OCDConsole.printWithAttributes(msg, "bg_green", "white", "bold");
        lineReturn();
    }

    static void printWithAttributes(String msg, String... attributes) {
        System.out.print(ansi().render("@|" + String.join(",", attributes) + " " + msg + "|@"));
    }

    public static void printlnRender(String msg) {
        printRender(msg);
        lineReturn();
    }

    public static void printRender(String msg) {
        System.out.print(ansi().render(msg));
    }
}
