package com.epam.adk.oop.sound_record.entity.impl;

import com.epam.adk.oop.sound_record.entity.Track;
import com.epam.adk.oop.sound_record.entity.enums.Genre;
import com.epam.adk.oop.sound_record.entity.enums.MusicInstrument;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class InstrimentalMusic extends Track {

    private MusicInstrument[] instruments;

    public InstrimentalMusic(String title, int duration, Genre genre, MusicInstrument[] instruments) {
        super(title, duration, genre);
        this.instruments = instruments;
    }
}
