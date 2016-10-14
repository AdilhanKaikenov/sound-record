package com.epam.adk.oop.sound_record.builder;

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
public class AlbumBuilder {

    private static final Logger log = LoggerFactory.getLogger(AlbumBuilder.class);

    private static Random random = new Random();

    private static final int MAX_TRACK_NUMBER = 7;
    private static final int MAX_PERFORMERS_NUMBER = 2;
    private static final int MIN_NUMBER = 1;

    /**
     * The method for creating Album randomly.
     *
     * @return new Album.
     */
    public static Album buildAlbum() {
        ArrayList<Track> tracks = new ArrayList<>();
        ArrayList<Performer> performers = new ArrayList<>();
        int trackNum = random.nextInt(MAX_TRACK_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        int performersNum = random.nextInt(MAX_PERFORMERS_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        log.debug("Entering buildAlbum(Number: songs = {}, instr.musics = {}, performers = {})",
                trackNum, trackNum, performersNum);
        for (int i = 0; i < performersNum; i++) {
            performers.add(new Performer("SingerName", "SingerLastName_" + i));
        }
        ArrayList<Track> songs = createSongs(trackNum);
        ArrayList<Track> instrumentalMusics = createInstrumentalMusics(trackNum);
        tracks.addAll(songs);
        tracks.addAll(instrumentalMusics);
        log.debug("Creating Album. Parameters: performers number = {}, tracks number = {}", performers.size(), tracks.size());
        return new Album(performers, tracks);
    }

    /**
     * The method for creating Songs randomly.
     *
     * @param number the number of songs to create.
     * @return the number of songs randomly created.
     */
    private static ArrayList<Track> createSongs(int number) {
        log.debug("Entering createSongs(number = {})", number);
        SongBuilder builder = new SongBuilder();
        ArrayList<Track> songs = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            songs.add(builder.buildSong());
        }
        return songs;
    }

    /**
     * The method for creating Instrumental Musics randomly.
     *
     * @param number the number of instrumental music to create.
     * @return the number of instrumental music randomly created.
     */
    private static ArrayList<Track> createInstrumentalMusics(int number) {
        InstrumentalMusicBuilder builder = new InstrumentalMusicBuilder();
        log.debug("Entering createInstrumentalMusics(number = {})", number);
        ArrayList<Track> instrumentalMusics = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            instrumentalMusics.add(builder.buildInstrumentalMusic());
        }
        return instrumentalMusics;
    }
}
