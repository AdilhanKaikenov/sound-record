package com.epam.adk.oop.sound_record.entity;

import com.epam.adk.oop.sound_record.comparators.SorterByTrackGenre;
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

    public static final Comparator<Track> SORTER_BY_TRACK_GENRE = new SorterByTrackGenre();
    private ArrayList<Performer> performers;

    public Album() {
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

    public void setPerformers(ArrayList<Performer> performers) {
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
}
