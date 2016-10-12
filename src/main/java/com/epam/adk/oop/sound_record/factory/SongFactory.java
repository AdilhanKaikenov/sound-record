package com.epam.adk.oop.sound_record.factory;

import com.epam.adk.oop.sound_record.entity.Track;
import com.epam.adk.oop.sound_record.entity.enums.Genre;
import com.epam.adk.oop.sound_record.entity.enums.MusicInstrument;
import com.epam.adk.oop.sound_record.entity.InstrumentalMusic;
import com.epam.adk.oop.sound_record.entity.Song;
import com.epam.adk.oop.sound_record.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class SongFactory {

    private static final Logger log = LoggerFactory.getLogger(SongFactory.class);

    private static Random random = new Random();

    private static String genreValues = PropertyManager.getInstance().getProperty("genres");
    private static String instrumentValues = PropertyManager.getInstance().getProperty("music.instruments");

    private static final int MAX_NUMBER_OF_INSTRUMENTS = 5;
    private static final String SIGN_TO_SPLIT = ",";

    /**
     * The method for creating Songs.
     *
     * @param number the number of songs to create.
     * @return the number of songs randomly created.
     */
    public Track[] createSongs(int number) {
        log.debug("Entering createSongs(number = {})", number);
        Track[] songs = new Track[number];
        for (int i = 0; i < number; i++) {
            String title = "Song nameless_" + i;
            int duration = generateDuration();
            Genre genre = generateGenre();
            log.debug("Creating song. Parameters: {}, {}, {}", title, duration, genre);
            Song song = new Song(title, duration, genre, "Unknown");
            songs[i] = song;
        }
        return songs;
    }

    /**
     * The method for creating Instrumental Musics.
     *
     * @param number the number of instrumental music to create.
     * @return the number of instrumental music randomly created.
     */
    public Track[] createInstrumentalMusics(int number) {
        log.debug("Entering createInstrumentalMusics(number = {})", number);
        Track[] instrumentalMusics = new Track[number];
        for (int i = 0; i < number; i++) {
            String title = "Music nameless_" + i;
            int duration = generateDuration();
            Genre genre = generateGenre();
            MusicInstrument[] musicInstruments = generateInstruments();
            log.debug("Creating instrumental music. Parameters: {}, {}, {}, instruments number = {}",
                    title, duration, genre, musicInstruments.length);
            InstrumentalMusic music = new InstrumentalMusic(title, duration, genre, musicInstruments);
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
        if (number == 0) {
            number++;
        }
        MusicInstrument[] musicInstruments = new MusicInstrument[number];
        for (int i = 0; i < number; i++) {
            int index = random.nextInt(instruments.length);
            MusicInstrument musicInstrument = MusicInstrument.valueOf(instruments[index]);
            musicInstruments[i] = musicInstrument;
        }
        return musicInstruments;
    }

}
