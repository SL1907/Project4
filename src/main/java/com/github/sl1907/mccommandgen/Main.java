package com.github.sl1907.mccommandgen;

import com.github.sl1907.mccommandgen.commands.types.PlayerType;

public class Main {


    public static void main(String[] args) {
        PlayerType type = new PlayerType("Cecer");
        System.out.println(type.getUuid());
        System.out.println(type.getName());
    }


}
