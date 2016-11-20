package ocd.controller;

import ocd.OCDConsole;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public class OCDCommandParser {

    private List<OCDCommand> commands;

    public OCDCommandParser(List<OCDCommand> commands) {
        this.commands = commands;
    }

    public OCDCommand parseCommand(String line) {
        List<String> lineSplit = Arrays.asList(line.split(" "));
        if(lineSplit.size() > 0 && !lineSplit.get(0).isEmpty()) {
            String name = lineSplit.get(0);
            OCDCommand commandFound = getCommand(name);
            if(commandFound != null) {
                List<String> attributes = lineSplit.subList(1, lineSplit.size());
                if(attributes.size() == commandFound.getNumArgs()) {
                    commandFound.setArgs(attributes);
                    return commandFound;
                } else {
                    OCDConsole.printlnError("Syntax error: " + commandFound.getSyntax());
                }
            } else {
                OCDConsole.printlnError("Command not found.");
            }
        } else {
            OCDConsole.printlnError("Empty command. Try again ?");
        }
        return null;
    }

    private OCDCommand getCommand(String name) {
        for(OCDCommand command : commands) {
            if(command.getName().equals(name)) {
                return command;
            }
        }
        return null;
    }
}
