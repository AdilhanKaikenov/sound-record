package com.epam.adk.oop.sound_record.main;

import com.epam.adk.oop.sound_record.entity.*;
import com.epam.adk.oop.sound_record.entity.enums.Genre;
import com.epam.adk.oop.sound_record.entity.enums.MusicInstrument;
import com.epam.adk.oop.sound_record.entity.impl.InstrimentalMusic;
import com.epam.adk.oop.sound_record.entity.impl.Song;

import java.util.List;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * The class with main method.
 *
 * @author Kaikenov Adilhan.
 */
public class Runner {

    /**
     * Application starting point.
     *
     * @param args input arguments array.
     */
    public static void main(String[] args) {

        Disk disk = new Disk();

        Performer singer1 = new Performer("Liza", "Soberano");
        Performer singer2 = new Performer("Michael", "Jackson");
        Performer singer3 = new Performer("Justin", "Timberlake");

        Track song1 = new Song("With You In My Life", 158, Genre.SOUNDTRACK, "Unknown");
        Track song2 = new Song("With You In My Life", 158, Genre.ALTERNATIVE, "Unknown");
        Track song3 = new InstrimentalMusic("Music of angels", 245, Genre.CLASSICAL,
                new MusicInstrument[]{MusicInstrument.PIANO});

        Playlist playlist1 = new Playlist();
        Playlist playlist2 = new Playlist();

        playlist1.addAll(song1, song2);
        playlist2.addAll(song3, song2, song1);

        Album album1 = new Album(new Performer[]{singer1}, playlist1);
        Album album2 = new Album(new Performer[]{singer2, singer3}, playlist2);

        disk.addAll(album1, album2);
        disk.sortByGenre();
        List<Track> tracks = disk.searchTrack(2, 2);
        Playlist.printTracks(tracks);
        System.out.println(disk);
        System.out.println(disk.getDuration());

    }
}
