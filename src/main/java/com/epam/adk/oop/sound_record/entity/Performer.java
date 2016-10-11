package com.epam.adk.oop.sound_record.entity;

/**
 * Created by Kaikenov Adilhan on 10.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class Performer {

    private String firstName;
    private String lastName;

    public Performer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
