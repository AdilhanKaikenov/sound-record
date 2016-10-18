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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Performer performer = (Performer) o;

        if (firstName != null ? !firstName.equals(performer.firstName) : performer.firstName != null) return false;
        return lastName != null ? lastName.equals(performer.lastName) : performer.lastName == null;

    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
