package com.github.sl1907.mccommandgen.commands.arguments;

public class DoubleArgument extends Argument<Double> {

    private final double value;

    public DoubleArgument(double value) {
        super(value);
        this.value = value;
    }

    public Double getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        return "DoubleArgument{value=" + this.value + "}";
    }
}
