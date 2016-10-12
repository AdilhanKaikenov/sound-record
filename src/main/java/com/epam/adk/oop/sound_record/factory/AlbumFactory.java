package com.epam.adk.oop.sound_record.factory;

import com.epam.adk.oop.sound_record.entity.*;
import com.epam.adk.oop.sound_record.service.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.epam.adk.oop.sound_record.entity.InstrumentalMusic.MusicInstrument;
import static com.epam.adk.oop.sound_record.entity.Track.Genre;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kaikenov Adilhan on 12.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class AlbumFactory {

    private static final Logger log = LoggerFactory.getLogger(AlbumFactory.class);

    private static Random random = new Random();

    private static final int MAX_TRACK_NUMBER = 7;
    private static final int MAX_PERFORMERS_NUMBER = 2;
    private static final int MIN_NUMBER = 1;

    /**
     * The method for creating Album randomly.
     *
     * @return new Album.
     */
    public static Album createAlbum() {
        ArrayList<Track> tracks = new ArrayList<>();
        ArrayList<Performer> performers = new ArrayList<>();
        int trackNum = random.nextInt(MAX_TRACK_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        int performersNum = random.nextInt(MAX_PERFORMERS_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        log.debug("Entering createAlbum(Number: songs = {}, instr.musics = {}, performers = {})",
                trackNum, trackNum, performersNum);
        for (int i = 0; i < performersNum; i++){
            performers.add(new Performer("SingerName", "SingerLastName_" + i));
        }
        ArrayList<Track> songs = SongFactory.createSongs(trackNum);
        ArrayList<Track> instrumentalMusics = SongFactory.createInstrumentalMusics(trackNum);
        tracks.addAll(songs);
        tracks.addAll(instrumentalMusics);
        log.debug("Creating Album. Parameters: performers number = {}, tracks number = {}", performers.size(), tracks.size());
        return new Album(performers, tracks);
    }

    /**
     * Created by Kaikenov Adilhan on 11.10.2016.
     *
     * @author Kaikenov Adilhan.
     */
    private static class SongFactory {

        private static final Logger log = LoggerFactory.getLogger(SongFactory.class);

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
        public static ArrayList<Track> createSongs(int number) {
            log.debug("Entering createSongs(number = {})", number);
            ArrayList<Track> songs = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                String title = "Song nameless_" + i;
                int duration = generateDuration();
                Genre genre = generateGenre();
                log.debug("Creating song. Parameters: {}, {}, {}", title, duration, genre);
                songs.add(new Song(title, duration, genre, "Unknown"));
            }
            return songs;
        }

        /**
         * The method for creating Instrumental Musics.
         *
         * @param number the number of instrumental music to create.
         * @return the number of instrumental music randomly created.
         */
        public static ArrayList<Track> createInstrumentalMusics(int number) {
            log.debug("Entering createInstrumentalMusics(number = {})", number);
            ArrayList<Track> instrumentalMusics = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                String title = "Music nameless_" + i;
                int duration = generateDuration();
                Genre genre = generateGenre();
                ArrayList<MusicInstrument> musicInstruments = generateInstruments();
                log.debug("Creating instrumental music. Parameters: {}, {}, {}, instruments number = {}",
                        title, duration, genre, musicInstruments);
                instrumentalMusics.add(new InstrumentalMusic(title, duration, genre, musicInstruments));
            }
            return instrumentalMusics;
        }

        private static int generateDuration() {
            return random.nextInt(180) + 120;
        }

        private static Genre generateGenre() {
            String[] genres = genreValues.split(SIGN_TO_SPLIT);
            int index = random.nextInt(genres.length);
            return Genre.valueOf(genres[index]);
        }

        private static ArrayList<MusicInstrument> generateInstruments() {
            String[] instruments = instrumentValues.split(SIGN_TO_SPLIT);
            int number = random.nextInt(MAX_NUMBER_OF_INSTRUMENTS);
            if (number == 0) {
                number++;
            }
            ArrayList<MusicInstrument> musicInstruments = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                int index = random.nextInt(instruments.length);
                musicInstruments.add(MusicInstrument.valueOf(instruments[index]));
            }
            return musicInstruments;
        }
    }
}
