package com.github.sl1907.mccommandgen.commands.arguments;

public abstract class Argument<T> {

    private T value;

    public Argument(T value) {
        this.value = value;
    }

    public abstract T getValue();

    public void setValue(T value) {
        this.value = value;
    }
}
