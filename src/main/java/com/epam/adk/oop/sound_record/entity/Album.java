package com.epam.adk.oop.sound_record.entity;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 * @see Component
 */
public class Album implements Component {

    private Performer[] performers;
    private Playlist playlist;

    public Album(Performer[] performers, Playlist playlist) {
        this.performers = performers;
        this.playlist = playlist;
    }

    @Override
    public String getDuration() {
        return playlist.getDuration();
    }

    /**
     * The method provides the names of all performers of the songs.
     *
     * @return the names of all performers.
     */
    public String getPerformers() {
        StringBuilder sb = new StringBuilder();
        for (Performer performer : performers) {
            sb.append(performer).append(", ");
        }
        return sb.toString();
    }

    public Playlist getPlaylist() {
        return playlist;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t\t").append("ALBUM: ").append("\n").append("Performers: ");
        for (Performer performer : performers){
            sb.append(performer);
            if (performers.length > 1){
                sb.append("; ");
            }
        }
        sb.append(playlist);
        return sb.toString();
    }
}
