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

    public boolean add(T composite) {
        if (composite == null) {
            log.error("Error in {} class, add() method. Argument = null", super.getClass().getSimpleName());
            throw new NullPointerException();
        }
        return components.add(composite);
    }

    public List<T> getComponents() {
        return new ArrayList<>(components);
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

    public void setComponents(List<T> components) {
        this.components = components;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractComposite<?> that = (AbstractComposite<?>) o;

        return components != null ? components.equals(that.components) : that.components == null;

    }

    @Override
    public int hashCode() {
        return components != null ? components.hashCode() : 0;
    }
}
