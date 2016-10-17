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

    public InstrumentalMusic() {
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
    private enum MusicInstrument {

        SAXOPHONE("Saxophone"),
        PIANO("Piano"),
        GUITAR("Guitar"),
        VIOLIN("Violin");

        private String name;

        MusicInstrument(String name) {
            this.name = name;
        }
    }

    /**
     * InstrumentalMusic Builder inner class.
     */
    public static class InstrumentalMusicBuilder {

        private InstrumentalMusic music;
        private Random random = new Random();
        private static String genreValues = PropertyManager.getInstance().getProperty("genres");
        private static String instrumentValues = PropertyManager.getInstance().getProperty("music.instruments");
        private static final String SIGN_TO_SPLIT = ",";

        private void createInstrumentalMusic(){
            music = new InstrumentalMusic();
        }

        private void buildTitle(){
            music.setTitle("Instrumental Music title");
        }


        private void buildDuration(){
            music.setDuration(random.nextInt(180) + 120);
        }

        private void buildGenre(){
            String[] genres = genreValues.split(SIGN_TO_SPLIT);
            int index = random.nextInt(genres.length);
            music.setGenre(Track.Genre.valueOf(genres[index]));
        }

        private void buildMusicInstruments(){
            String[] instruments = instrumentValues.split(SIGN_TO_SPLIT);
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

        /**
         * The method for building InstrumentalMusic.
         *
         * @return new InstrumentalMusic.
         */
        public InstrumentalMusic buildInstrumentalMusic(){
            createInstrumentalMusic();
            buildTitle();
            buildDuration();
            buildGenre();
            buildMusicInstruments();
            return music;
        }
    }
}
