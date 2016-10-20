package com.epam.adk.oop.sound_record.builder;

import com.epam.adk.oop.sound_record.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.epam.adk.oop.sound_record.entity.InstrumentalMusic.InstrumentalMusicBuilder;
import static com.epam.adk.oop.sound_record.entity.Song.SongBuilder;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kaikenov Adilhan on 12.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class AlbumBuilder {

    private static final Logger log = LoggerFactory.getLogger(AlbumBuilder.class);

    private Album album;
    private static Random random = new Random();

    private static final int MAX_TRACK_NUMBER = 7;
    private static final int MAX_PERFORMERS_NUMBER = 2;
    private static final int MIN_NUMBER = 1;

    private void createNewAlbum(){
        log.debug("Creating new Album...");
        album = new Album();
    }

    private void buildPerformers(){
        ArrayList<Performer> performers = new ArrayList<>();
        int performersNum = random.nextInt(MAX_PERFORMERS_NUMBER) + MIN_NUMBER;
        for (int i = 0; i < performersNum; i++) {
            performers.add(new Performer("Name", "Surname_" + i));
        }
        log.debug("Number of performers = {}", performers.size());
        album.setPerformers(performers);
    }

    private void buildTracks(){
        ArrayList<Track> tracks = new ArrayList<>();
        int trackNum = random.nextInt(MAX_TRACK_NUMBER - MIN_NUMBER) + MIN_NUMBER;
        ArrayList<Track> songs = createSongs(trackNum);
        ArrayList<Track> instrumentalMusics = createInstrumentalMusics(trackNum);
        tracks.addAll(songs);
        tracks.addAll(instrumentalMusics);
        log.debug("Number of tracks = {}", tracks.size());
        album.setComponents(tracks);
    }

    /**
     * The method for building Album randomly.
     *
     * @return new Album.
     */
    public Album buildAlbum() {
        createNewAlbum();
        buildPerformers();
        buildTracks();
        return album;
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
        log.debug("Entering createInstrumentalMusics(number = {})", number);
        InstrumentalMusicBuilder builder = new InstrumentalMusicBuilder();
        ArrayList<Track> instrumentalMusics = new ArrayList<>(number);
        for (int i = 0; i < number; i++) {
            instrumentalMusics.add(builder.buildInstrumentalMusic());
        }
        return instrumentalMusics;
    }
}
