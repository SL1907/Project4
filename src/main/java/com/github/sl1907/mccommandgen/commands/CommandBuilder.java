package com.github.sl1907.mccommandgen.commands;

public class CommandBuilder<T extends Command> {

    private final Command command;

    public CommandBuilder(Command command) {
        this.command = command;
    }

}
