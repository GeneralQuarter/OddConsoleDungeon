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
    private OCDCommand currentCommand;
    private String name;
    private List<String> args;

    public OCDCommandParser(List<OCDCommand> commands) {
        this.commands = commands;
    }

    public OCDCommand parseCommand(String line) {
        if (isCommandEmpty(Arrays.asList(line.split(" ")))) {
            if (findCommand(name, commands, args)) {
                if (validateCommandSyntax()) {
                    return currentCommand;
                }
            }
        }
        return null;
    }

    private boolean findCommand(String name, List<OCDCommand> commands, List<String> args) {
        for(OCDCommand command : commands) {
            if(command.getName().equals(name)) {
                if (command.hasSubCommands()) {
                    if (isCommandEmpty(args)) {
                        return findCommand(
                                args.get(0),
                                command.getSubCommands(),
                                args.subList(1, args.size()));
                    } else {
                        OCDConsole.printlnError("Syntax error: " + command.getSyntax());
                        return false;
                    }
                } else {
                    currentCommand = command;
                    this.name = name;
                    this.args = args;
                    return true;
                }
            }
        }
        OCDConsole.printlnError("Command not found.");
        return false;
    }

    private boolean isCommandEmpty(List<String> args) {
        if(args.size() > 0 && !args.get(0).isEmpty()) {
            this.name = args.get(0);
            this.args = args.subList(1, args.size());
            return true;
        } else {
            OCDConsole.printlnError("Empty command. Try again ?");
            return false;
        }
    }

    private boolean validateCommandSyntax() {
        if (args.size() == currentCommand.getNumArgs()) {
            currentCommand.setArgs(args);
            return true;
        } else {
            OCDConsole.printlnError("Syntax error: " + currentCommand.getSyntax());
            return false;
        }
    }
}
