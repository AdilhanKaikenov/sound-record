package com.epam.adk.oop.sound_record.entity;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class Disk extends AbstractComposite<Album> {

    @Override
    public String toString() {
        return "Total duration = " + getDuration() + " minutes. \n" + super.toString();
    }
}
