package ocd.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quentin Gangler on 20/11/2016.
 *
 */
public abstract class OCDCommand {

    private String name;
    private int numArgs;
    private List<String> args;
    private String description;
    protected List<OCDCommand> subCommands;

    public OCDCommand(String name, int numArgs, String description) {
        this.name = name;
        this.numArgs = numArgs;
        this.description = description;
        this.subCommands = new ArrayList<>();
    }

    public abstract void execute();

    public abstract String getSyntax();

    public String getHelpText() {
        String subHelp = "";
        for(OCDCommand command : subCommands) {
            subHelp+= "\t" + command.getHelpText();
        }
        return "@|yellow,bold " + getSyntax() + "|@ - " + getDescription() + "\n" + subHelp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumArgs() {
        return numArgs;
    }

    public void setNumArgs(int numArgs) {
        this.numArgs = numArgs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }

    public List<OCDCommand> getSubCommands() {
        return subCommands;
    }

    public boolean hasSubCommands() {
        return subCommands.size() != 0;
    }
}
