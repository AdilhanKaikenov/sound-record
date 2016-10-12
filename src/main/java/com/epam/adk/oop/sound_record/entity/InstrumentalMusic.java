package com.epam.adk.oop.sound_record.entity;

import com.epam.adk.oop.sound_record.entity.Track;
import com.epam.adk.oop.sound_record.entity.enums.Genre;
import com.epam.adk.oop.sound_record.entity.enums.MusicInstrument;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class InstrumentalMusic extends Track {

    private MusicInstrument[] instruments;

    public InstrumentalMusic(String title, int duration, Genre genre, MusicInstrument[] instruments) {
        super(title, duration, genre);
        this.instruments = instruments;
    }
}
