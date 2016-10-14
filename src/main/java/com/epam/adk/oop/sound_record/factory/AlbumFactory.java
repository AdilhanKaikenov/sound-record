package com.epam.adk.oop.sound_record.factory;

import com.epam.adk.oop.sound_record.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.epam.adk.oop.sound_record.entity.InstrumentalMusic.InstrumentalMusicBuilder;
import static com.epam.adk.oop.sound_record.entity.Song.SongBuilder;

import java.util.ArrayList;
import java.util.Random;

/**
 * TODO: Использовать паттерн Builder, придумать как сделать лучше.
 *
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

        /**
         * The method for creating Songs.
         *
         * @param number the number of songs to create.
         * @return the number of songs randomly created.
         */
        public static ArrayList<Track> createSongs(int number) {
            log.debug("Entering createSongs(number = {})", number);
            SongBuilder builder = new SongBuilder();
            ArrayList<Track> songs = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                songs.add(builder.buildSong());
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
            InstrumentalMusicBuilder builder = new InstrumentalMusicBuilder();
            log.debug("Entering createInstrumentalMusics(number = {})", number);
            ArrayList<Track> instrumentalMusics = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                instrumentalMusics.add(builder.buildInstrumentalMusic());
            }
            return instrumentalMusics;
        }
    }
}
