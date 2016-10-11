package com.epam.adk.oop.sound_record.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class Playlist extends AbstractComposite<Track> {

    private static final Logger log = LoggerFactory.getLogger(Playlist.class);

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
        return "\nPlaylist: \n" + super.toString();
    }
}
