package com.epam.adk.oop.sound_record.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class Disk extends AbstractComposite<Album> {

    private static final Logger log = LoggerFactory.getLogger(Disk.class);
    private static final String SING_TO_SPLIT_TIME = ":";

    public void sortByGenre(){
        for (Album album : getMusicUnits()){
            List<Track> musicUnits = album.getPlaylist().getMusicUnits();
            Collections.sort(musicUnits);
        }
    }

    public List<Track> searchTrack(int minMinute, int maxMinute){
        List<Track> result = new ArrayList<>();
        List<Album> musicUnits = getMusicUnits();
        if (musicUnits == null) {
            log.error("Error in Disk class, searchTrack() method. musicUnits = null");
            throw new NullPointerException();
        }

        for (Album album : musicUnits) {
            Playlist playlist = album.getPlaylist();

            for (Track track : playlist.getMusicUnits()) {
                String duration = track.getDuration();
                String[] split = duration.split(SING_TO_SPLIT_TIME);

                int minute = Integer.valueOf(split[0]);

                // condition for the selection
                if (minute <= maxMinute && minute >= minMinute) {
                    result.add(track);
                }
            }
        }
        return result;
    }

}
