package com.github.sl1907.mccommandgen.commands;

public abstract class Command {

    private final String command;
    private final String description;
    private final String usage;
    private String[] options;

    public Command(String command, String description, String usage, String[] options) {
        this.command = command;
        this.description = description;
        this.usage = usage;
        this.options = options;
    }

    public String getCommand() {
        return this.command;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUsage() {
        return this.usage;
    }

    public String[] getOptions() {
        return this.options;
    }

    public abstract CommandBuilder<? extends Command> build(String... args);
}
