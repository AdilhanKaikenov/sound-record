package com.epam.adk.oop.sound_record.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public abstract class AbstractComposite<T extends Component> {

    private static final Logger log = LoggerFactory.getLogger(AbstractComposite.class);

    private List<T> components;

    public AbstractComposite() {
        components = new ArrayList<>();
    }

    public AbstractComposite(List<T> components) {
        this.components = components;
    }

    public void add(T composite) {
        if (composite == null) {
            log.error("Error in {} class, add() method. Argument = null", super.getClass().getSimpleName());
            throw new NullPointerException();
        }
        components.add(composite);
    }

    public void add(ArrayList<T> components) {
        if (components == null) {
            log.error("Error in {} class, add() method. Argument = null", super.getClass().getSimpleName());
            throw new NullPointerException();
        }
        for (T component : components) {
            this.getComponents().add(component);
        }
    }

    public List<T> getComponents() {
        return components;
    }

    public String getDuration() {
        int total = 0;
        for (Component component : getComponents()) {
            String duration = component.getDuration();
            String[] split = duration.split(":");
            total += Integer.valueOf(split[0]) * 60 + Integer.valueOf(split[1]);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        return sdf.format(new Date(total * 1000));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Component component : components) {
            if (component != null) {
                sb.append(component).append("\n");
            }
        }
        return sb.toString();
    }
}
