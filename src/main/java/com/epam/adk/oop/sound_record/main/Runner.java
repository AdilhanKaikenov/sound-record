package com.epam.adk.oop.sound_record.main;

import com.epam.adk.oop.sound_record.entity.*;
import com.epam.adk.oop.sound_record.builder.AlbumBuilder;
import com.epam.adk.oop.sound_record.service.FinderTracksByDuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 * <p>
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

        Disk disk = new Disk();
        FinderTracksByDuration finder = new FinderTracksByDuration();

        AlbumBuilder builder = new AlbumBuilder();
        Album album = builder.buildAlbum();

        disk.add(album);

        Collections.sort(album.getComponents(), Album.SORTER_BY_TRACK_GENRE);

        log.info("Sorted disk: {}", disk);

        log.info("Search result: ");
        ArrayList<Track> found = finder.find(3, 3, disk);
        Album.printTracks(found);



    }
}
