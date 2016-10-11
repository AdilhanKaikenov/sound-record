package com.epam.adk.oop.sound_record.main;

import com.epam.adk.oop.sound_record.entity.*;
import com.epam.adk.oop.sound_record.factory.SongFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public class Runner {

    private static final Logger log = LoggerFactory.getLogger(Runner.class);

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) {
        log.info("<----------------------------------- MAIN METHOD START ----------------------------------->");
        Disk disk = new Disk();
        Performer singer = new Performer("Liza", "Soberano");

        // Creating tracks.
        SongFactory factory = new SongFactory();
        Track[] songs = factory.createSongs(5);
        Track[] instrumentalMusics = factory.createInstrumentalMusics(3);

        Playlist playlist = new Playlist();
        playlist.addAll(songs);
        playlist.addAll(instrumentalMusics);

        Album album = new Album(new Performer[]{singer}, playlist);

        disk.add(album);
        disk.sortByGenre(); // sorting
        log.info("{}", disk);

        log.info("Search result: ");
        List<Track> tracks = disk.searchTrack(3, 3);
        Playlist.printTracks(tracks);
        log.info("<----------------------------------- MAIN METHOD END ----------------------------------->\n\n");

    }
}
