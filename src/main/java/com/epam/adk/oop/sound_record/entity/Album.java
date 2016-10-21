package com.epam.adk.oop.sound_record.entity;

import com.epam.adk.oop.sound_record.comparators.SorterByTrackGenre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Component
 */
public class Album extends AbstractComposite<Track> implements Component {

    private static final Logger log = LoggerFactory.getLogger(Album.class);

    public static final Comparator<Track> SORTER_BY_TRACK_GENRE = new SorterByTrackGenre();
    private List<Performer> performers;

    private Album() {
    }

    /**
     * The method provides the names of all performers of the songs.
     *
     * @return the names of all performers.
     */
    public String getPerformers() {
        StringBuilder sb = new StringBuilder();
        for (Performer performer : performers) {
            sb.append(performer).append("; ");
        }
        return sb.toString();
    }

    private void setPerformers(List<Performer> performers) {
        this.performers = performers;
    }

    public static void printTracks(List<Track> tracks){
        if (tracks == null) {
            log.error("In Playlist class, printTracks() method. Argument = null");
            throw new NullPointerException();
        }
        log.debug("In Playlist class, printTracks() method. Argument size = {}", tracks.size());
        for (Track track : tracks) {
            log.info(track.toString());
        }
    }

    @Override
    public String toString() {
        return "\t\t" + "ALBUM: " + "\n" + "Performers: " +
                getPerformers() + "\n" + super.toString();
    }

    /**
     * Builder inner class.
     */
    public static class Builder {

        private final Logger log = LoggerFactory.getLogger(Builder.class);

        private Album album;
        private Random random = new Random();

        private static final int MAX_TRACK_NUMBER = 7;
        private static final int MAX_PERFORMERS_NUMBER = 2;
        private static final int MIN_NUMBER = 1;

        private void createNewAlbum(){
            log.debug("Creating new Album...");
            album = new Album();
        }

        private void buildPerformers(){
            List<Performer> performers = new ArrayList<>();
            int performersNum = random.nextInt(MAX_PERFORMERS_NUMBER) + MIN_NUMBER;
            for (int i = 0; i < performersNum; i++) {
                performers.add(new Performer("Name", "Surname_" + i));
            }
            log.debug("Number of performers = {}", performers.size());
            album.setPerformers(performers);
        }

        private void buildTracks(){
            List<Track> tracks = new ArrayList<>();
            int trackNum = random.nextInt(MAX_TRACK_NUMBER - MIN_NUMBER) + MIN_NUMBER;
            List<Track> songs = createSongs(trackNum);
            List<Track> instrumentalMusics = createInstrumentalMusics(trackNum);
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
        private List<Track> createSongs(int number) {
            log.debug("Entering createSongs(number = {})", number);
            Song.SongBuilder builder = new Song.SongBuilder();
            List<Track> songs = new ArrayList<>(number);
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
        private List<Track> createInstrumentalMusics(int number) {
            log.debug("Entering createInstrumentalMusics(number = {})", number);
            InstrumentalMusic.InstrumentalMusicBuilder builder = new InstrumentalMusic.InstrumentalMusicBuilder();
            List<Track> instrumentalMusics = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                instrumentalMusics.add(builder.buildInstrumentalMusic());
            }
            return instrumentalMusics;
        }
    }
}
