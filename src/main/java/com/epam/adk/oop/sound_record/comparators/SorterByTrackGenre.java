package com.epam.adk.oop.sound_record.comparators;

import com.epam.adk.oop.sound_record.entity.Track;

import java.util.Comparator;

/**
 * Created by Kaikenov Adilhan on 12.10.2016.
 * A Comparator that sorts Track objects as by Genre.
 *
 * @author Kaikenov Adilhan.
 * @see Comparator
 */
public class SorterByTrackGenre implements Comparator<Track> {

    @Override
    public int compare(Track track1, Track track2) {

        String genre1 = String.valueOf(track1.getGenre());
        String genre2 = String.valueOf(track2.getGenre());

        return genre1.compareTo(genre2);
    }
}