package com.epam.adk.oop.sound_record.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Component
 */
public class Album extends AbstractComposite<Track> implements Component {

    private static final Logger log = LoggerFactory.getLogger(Album.class);

    public static final Comparator<Track> BY_TRACK_GENRE = new SorterByTrackGenre();
    private ArrayList<Performer> performers;

    public Album(ArrayList<Performer> performers, List<Track> components) {
        super(components);
        this.performers = performers;
    }

    public Album(ArrayList<Performer> performers) {
        this.performers = performers;
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
     * Created by Kaikenov Adilhan on 12.10.2016.
     * A Comparator that sorts {@code Track} objects as by Genre.
     *
     * @author Kaikenov Adilhan.
     * @see Comparator
     */
    private static class SorterByTrackGenre implements Comparator<Track> {

        @Override
        public int compare(Track track1, Track track2) {

            String genre1 = String.valueOf(track1.getGenre());
            String genre2 = String.valueOf(track2.getGenre());

            return genre1.compareTo(genre2);
        }
    }
}
