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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Track track = (Track) o;

        if (duration != track.duration) return false;
        if (title != null ? !title.equals(track.title) : track.title != null) return false;
        return genre == track.genre;

    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + duration;
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        return result;
    }
}
