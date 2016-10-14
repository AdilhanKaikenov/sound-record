package com.epam.adk.oop.sound_record.entity;

import com.epam.adk.oop.sound_record.service.PropertyManager;

import java.util.Random;

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

    public Song() {
    }

    public String getTextAuthor() {
        return textAuthor;
    }

    public void setTextAuthor(String textAuthor) {
        this.textAuthor = textAuthor;
    }

    /**
     *
     */
    public static class SongBuilder {

        private Song song;
        private Random random = new Random();
        private String genreValues = PropertyManager.getInstance().getProperty("genres");

        private void createSong(){
            song = new Song();
        }

        void buildTitle(){
            song.setTitle("Song title");
        }

        void buildDuration(){
            song.setDuration(random.nextInt(180) + 120);
        }

        void buildGenre(){
            String[] genres = genreValues.split(",");
            int index = random.nextInt(genres.length);
            song.setGenre(Track.Genre.valueOf(genres[index]));
        }

        private void buildTextAuthor(){
            song.setTextAuthor("Unknown");
        }

        public Song buildSong(){
            createSong();
            buildTitle();
            buildDuration();
            buildGenre();
            buildTextAuthor();
            return song;
        }
    }
}
