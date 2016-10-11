package com.epam.adk.oop.sound_record.main;

import com.epam.adk.oop.sound_record.entity.*;
import com.epam.adk.oop.sound_record.factory.SongFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        Disk disk = new Disk();

        Performer singer = new Performer("Liza", "Soberano");

        SongFactory factory = new SongFactory();

        Track[] songs = factory.createSongs(5);
        Track[] instrumentalMusics = factory.createInstrumentalMusics(3);

        Playlist playlist = new Playlist();

        playlist.addAll(songs);
        playlist.addAll(instrumentalMusics);

        Album album = new Album(new Performer[]{singer}, playlist);

        disk.add(album);
        disk.sortByGenre();
        System.out.println(disk);

    }
}
