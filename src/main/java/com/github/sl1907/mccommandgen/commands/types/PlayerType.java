package com.github.sl1907.mccommandgen.commands.types;

import com.github.sl1907.mccommandgen.utils.MojangLookup;

import java.util.UUID;

public class PlayerType {

    private UUID uuid;
    private final String name;

    public PlayerType(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public PlayerType(String name) {
        this.name = name;
        MojangLookup.get(this.name)
            .whenComplete((uuid1, throwable) -> {
                if (throwable != null) {
                    this.uuid = null;
                    throw new RuntimeException(throwable);
                } else {
                    this.uuid = uuid1;
                }
            }
        );
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public String getName() {
        return this.name;
    }
}
