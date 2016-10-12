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

    public Track(String title, int duration, Genre genre) {
        this.title = title;
        this.duration = duration;
        this.genre = genre;
    }

    @Override
    public String getDuration() {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format(new Date(duration * 1000));
    }

    public Genre getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return " - Song name: " + title +
                "; Genre: " + genre.getName() +
                "; Duration: " + getDuration() + ";";
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
