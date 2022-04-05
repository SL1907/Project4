package com.github.sl1907.mccommandgen.commands.arguments;

import com.github.sl1907.mccommandgen.commands.types.PlayerType;

public class PlayerArgument extends Argument<PlayerType> {

    private final PlayerType value;

    public PlayerArgument(PlayerType value) {
        super(value);
        this.value = value;
    }

    @Override
    public String toString() {
        return "PlayerArgument{" +
                "value=" + value +
                '}';
    }

    @Override
    public PlayerType getValue() {
        return this.value;
    }
}
