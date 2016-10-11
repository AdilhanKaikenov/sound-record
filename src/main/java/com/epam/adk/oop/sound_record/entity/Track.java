package com.epam.adk.oop.sound_record.entity;

import com.epam.adk.oop.sound_record.entity.enums.Genre;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Component
 */
public abstract class Track implements Component, Comparable<Track> {

    private String title;
    private int duration;
    private Genre genre;

    public Track(String title, int duration, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public int compareTo(Track track) {
        return genre.compareTo(track.getGenre());
    }

    @Override
    public String getDuration() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format(new Date(duration * 1000));
    }

    @Override
    public String toString() {
        return " - Song name: " + title +
                "; Genre: " + genre.getName() +
                "; Duration: " + getDuration() + ";";
    }

    public Genre getGenre() {
        return genre;
    }

}
