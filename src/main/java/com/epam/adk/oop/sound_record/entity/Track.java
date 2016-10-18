package com.epam.adk.oop.sound_record.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Component
 */
public abstract class Track implements Component {

    private String title;
    private int duration;
    private Genre genre;

    public Track() {
    }

    @Override
    public String getDuration() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format(new Date(duration * 1000));
    }

    public Genre getGenre() {
        return genre;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return " - Song name: " + title +
                "; Genre: " + genre.getName() +
                "; Duration: " + getDuration() + ";";
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

    /**
     * Created by Kaikenov Adilhan on 11.10.2016.
     * Enumeration of Music genres.
     *
     * @author Kaikenov Adilhan.
     */
    public enum Genre {

        ALTERNATIVE("Alternative"),
        CLASSICAL("Classical"),
        JAZZ("Jazz"),
        POP("Pop"),
        SOUNDTRACK("Soundtrack");

        private String name;

        Genre(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
