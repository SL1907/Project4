package com.github.sl1907.mccommandgen.commands.arguments;

public class DoubleArgument extends Argument {
    private double value;

    public DoubleArgument(double value) {
        super("Double", value);
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "DoubleArgument{name=" + this.getName() + ", value=" + value + "}";
    }

    @Override
    public String getName() {
        return "double";
    }
}
