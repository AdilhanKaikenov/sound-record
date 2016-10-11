package com.epam.adk.oop.sound_record.entity.enums;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public enum Genre {

    ALTERNATIVE("Alternative"),
    CLASSICAL("Classical"),
    JAZZ("Jazz"),
    POP("Pop"),
    SOUNDTRACK("Soundtrack");

    private String name;

    Genre(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
