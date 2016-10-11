package com.epam.adk.oop.sound_record.factory;

import com.epam.adk.oop.sound_record.entity.Track;
import com.epam.adk.oop.sound_record.entity.enums.Genre;
import com.epam.adk.oop.sound_record.entity.enums.MusicInstrument;
import com.epam.adk.oop.sound_record.entity.impl.InstrumentalMusic;
import com.epam.adk.oop.sound_record.entity.impl.Song;
import com.epam.adk.oop.sound_record.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

public class SongFactory {

    private static final Logger log = LoggerFactory.getLogger(SongFactory.class);

    private static Random random = new Random();

    private static String genreValues = PropertyManager.getInstance().getProperty("genres");
    private static String instrumentValues = PropertyManager.getInstance().getProperty("music.instruments");

    private static final int MAX_NUMBER_OF_INSTRUMENTS = 5;
    private static final String SIGN_TO_SPLIT = ",";

    public Track[] createSongs(int number) {
        Track[] songs = new Track[number];
        for (int i = 0; i < number; i++) {
            String title = "Song nameless_" + i;
            Song song = new Song(title, generateDuration(), generateGenre(), "Unknown");
            log.debug("{}", song);
            songs[i] = song;
        }
        return songs;
    }

    public Track[] createInstrumentalMusics(int number) {
        Track[] instrumentalMusics = new Track[number];
        for (int i = 0; i < number; i++) {
            String title = "Music nameless_" + i;
            InstrumentalMusic music = new InstrumentalMusic(
                    title, generateDuration(), generateGenre(), generateInstruments()
            );
            instrumentalMusics[i] = music;
        }
        return instrumentalMusics;
    }

    private int generateDuration() {
        return random.nextInt(180) + 120;
    }

    private Genre generateGenre() {
        String[] genres = genreValues.split(SIGN_TO_SPLIT);
        int index = random.nextInt(genres.length);
        return Genre.valueOf(genres[index]);
    }

    private MusicInstrument[] generateInstruments() {
        String[] instruments = instrumentValues.split(SIGN_TO_SPLIT);
        int number = random.nextInt(MAX_NUMBER_OF_INSTRUMENTS);
        MusicInstrument[] musicInstruments = new MusicInstrument[number];
        for (int i = 0; i < number; i++) {
            int index = random.nextInt(instruments.length);
            MusicInstrument musicInstrument = MusicInstrument.valueOf(instruments[index]);
            musicInstruments[i] = musicInstrument;
        }
        return musicInstruments;
    }

}
