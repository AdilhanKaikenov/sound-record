package com.epam.adk.oop.sound_record.entity;

import java.util.ArrayList;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class InstrumentalMusic extends Track {

    private ArrayList<MusicInstrument> instruments;

    public InstrumentalMusic(String title, int duration, Genre genre, ArrayList<MusicInstrument> instruments) {
        super(title, duration, genre);
        this.instruments = instruments;
    }

    /**
     * Created by Kaikenov Adilhan on 11.10.2016.
     * Enumeration of Music Instruments.
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
}
