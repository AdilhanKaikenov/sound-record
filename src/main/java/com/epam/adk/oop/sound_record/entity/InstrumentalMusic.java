package com.epam.adk.oop.sound_record.entity;

import com.epam.adk.oop.sound_record.service.PropertyManager;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class InstrumentalMusic extends Track {

    private ArrayList<MusicInstrument> instruments;

    public InstrumentalMusic(String title, int duration, Genre genre, ArrayList<MusicInstrument> instruments) {
        super(title, duration, genre);
        this.instruments = instruments;
    }

    public InstrumentalMusic() {
    }

    public ArrayList<MusicInstrument> getInstruments() {
        return instruments;
    }

    public void setInstruments(ArrayList<MusicInstrument> instruments) {
        this.instruments = instruments;
    }

    /**
     * Created by Kaikenov Adilhan on 11.10.2016.
     * Enumeration of Music Instruments.
     *
     * @author Kaikenov Adilhan.
     */
    public enum MusicInstrument {

        SAXOPHONE("Saxophone"),
        PIANO("Piano"),
        GUITAR("Guitar"),
        VIOLIN("Violin");

        private String name;

        MusicInstrument(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    /**
     *
     */
    public static class InstrumentalMusicBuilder {

        private InstrumentalMusic music;
        private Random random = new Random();
        private String genreValues = PropertyManager.getInstance().getProperty("genres");
        private String instrumentValues = PropertyManager.getInstance().getProperty("music.instruments");

        private void createInstrumentalMusic(){
            music = new InstrumentalMusic();
        }

        void buildTitle(){
            music.setTitle("Instrumental Music title");
        }


        void buildDuration(){
            music.setDuration(random.nextInt(180) + 120);
        }

        void buildGenre(){
            String[] genres = genreValues.split(",");
            int index = random.nextInt(genres.length);
            music.setGenre(Track.Genre.valueOf(genres[index]));
        }

        private void buildMusicInstruments(){
            String[] instruments = instrumentValues.split(",");
            int number = random.nextInt(7);
            if (number == 0) {
                number++;
            }
            ArrayList<MusicInstrument> musicInstruments = new ArrayList<>(number);
            for (int i = 0; i < number; i++) {
                int index = random.nextInt(instruments.length);
                musicInstruments.add(MusicInstrument.valueOf(instruments[index]));
            }
            music.setInstruments(musicInstruments);
        }

        private InstrumentalMusic getInstrumentalMusic() {
            return music;
        }

        public InstrumentalMusic buildInstrumentalMusic(){
            createInstrumentalMusic();
            this.buildTitle();
            this.buildDuration();
            this.buildGenre();
            buildMusicInstruments();
            return getInstrumentalMusic();
        }
    }
}
