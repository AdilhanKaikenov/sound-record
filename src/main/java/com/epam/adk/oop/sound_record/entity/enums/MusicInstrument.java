package com.epam.adk.oop.sound_record.entity.enums;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public enum MusicInstrument {

    SAXOPHONE("Saxophone"),
    PIANO("Piano"),
    GUITAR("Guitar"),
    VIOLIN("Violin");

    private String name;

    MusicInstrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
