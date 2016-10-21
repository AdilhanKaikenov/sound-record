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

    private Song() {
    }

    private void setTextAuthor(String textAuthor) {
        this.textAuthor = textAuthor;
    }

    /**
     * Song Builder inner class.
     */
    public static class SongBuilder {

        private Song song;
        private Random random = new Random();
        private static String genreValues = PropertyManager.getInstance().getProperty("genres");
        private static final String SIGN_TO_SPLIT = ",";

        private void createSong(){
            song = new Song();
        }

        private void buildTitle(){
            song.setTitle("Song title");
        }

        private void buildDuration(){
            song.setDuration(random.nextInt(180) + 120);
        }

        private void buildGenre(){
            String[] genres = genreValues.split(SIGN_TO_SPLIT);
            int index = random.nextInt(genres.length);
            song.setGenre(Track.Genre.valueOf(genres[index]));
        }

        private void buildTextAuthor(){
            song.setTextAuthor("Unknown");
        }

        /**
         * The method for building Song.
         *
         * @return new Song.
         */
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
