package com.epam.adk.oop.sound_record.entity;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class Song extends Track {

    private String textAuthor;

    public Song(String title, int duration, Genre genre, String textAuthor) {
        super(title, duration, genre);
        this.textAuthor = textAuthor;
    }
}
