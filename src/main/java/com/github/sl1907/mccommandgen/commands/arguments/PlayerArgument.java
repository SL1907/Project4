package com.github.sl1907.mccommandgen.commands.arguments;

public class PlayerArgument extends Argument {

    private Object value;

    public PlayerArgument(Object value) {
        super("Player", value);
        this.value = value;
    }

    @Override
    public String getName() {
        return "Player";
    }

    @Override
    public Object getValue() {
        return this.value;
    }
}
