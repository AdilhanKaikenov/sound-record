package com.epam.adk.oop.sound_record.service;

import com.epam.adk.oop.sound_record.entity.Album;
import com.epam.adk.oop.sound_record.entity.Disk;
import com.epam.adk.oop.sound_record.entity.Track;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaikenov Adilhan on 12.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class FinderTracksByDuration {

    private static final Logger log = LoggerFactory.getLogger(FinderTracksByDuration.class);
    private static final String SING_TO_SPLIT_TIME = ":";

    /**
     * The method to search for all tracks in the range of minutes.
     *
     * @param minMinute the lower bound (minute) for the search.
     * @param maxMinute the upper bound (minute) for the search.
     * @param disk      disk with playlists.
     * @return          a list of the found songs.
     */
    public List<Track> find(int minMinute, int maxMinute, Disk disk) {

        log.debug("Min. minute = {}, Max. minute = {}", minMinute, maxMinute);
        if (minMinute > maxMinute) {
            log.error("Error in FinderTracksByDuration class, find() method. Min.minute mustn't be less than Max.minute.");
            throw new IllegalArgumentException();
        }
        if (disk == null) {
            log.error("Error in FinderTracksByDuration class, find() method. Argument = null");
            throw new NullPointerException();
        }
        List<Track> result = new ArrayList<>();
        List<Album> albums = disk.getComponents();

        for (Album album : albums) {
            List<Track> tracks = album.getComponents();

            for (Track track : tracks) {
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
