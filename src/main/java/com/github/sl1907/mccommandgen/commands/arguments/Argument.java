package com.github.sl1907.mccommandgen.commands.arguments;

public abstract class Argument {

    private String name;
    private Object value;

    public Argument(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public abstract String getName();

    public abstract Object getValue();

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
