package com.github.sl1907.mccommandgen.commands;

import com.github.sl1907.mccommandgen.commands.arguments.Argument;
import com.github.sl1907.mccommandgen.commands.arguments.DoubleArgument;
import com.github.sl1907.mccommandgen.commands.arguments.PlayerArgument;

public class TeleportCommand extends Command {

    private final String[] aliases = {"tp", "teleport"};
    private static final String[] usages = {
            "<destination>",
            "<targets> <destination>",
            "<location>",
            "<targets> <location>",
            "<targets> <location> <rotation>",
            "<targets> <location> facing <facingLocation>",
            "<targets> <location> facing entity <facingEntity> [<facingAnchor>]"
    };

    private static final String description = "Teleport to a set of coordinates or teleport another player/entity";

    public TeleportCommand() {
        super("teleport", description, "/teleport <args>", usages);
    }

    @Override
    public CommandBuilder<? extends Command> build(String... args) {
        return new CommandBuilder<>(this);
    }

    public enum ArgumentSets {
        COORDINATES(DoubleArgument.class, DoubleArgument.class, DoubleArgument.class, PlayerArgument.class),
        TARGETS_COORDINATES,
        LOCATION,
        TARGETS_LOCATION,
        TARGETS_LOCATION_ROTATION,
        TARGETS_LOCATION_FACING,
        TARGETS_LOCATION_FACING_ENTITY,
        TARGETS_LOCATION_FACING_ENTITY_ANCHOR;

        @SafeVarargs
        ArgumentSets(Class<? extends Argument>... args) {

        }
    }
}
