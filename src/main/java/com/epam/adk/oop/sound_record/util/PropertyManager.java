package com.epam.adk.oop.sound_record.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kaikenov Adilhan on 11.10.2016.
 *
 * @author Kaikenov Adilhan.
 */
public class PropertyManager {

    private static final Logger log = LoggerFactory.getLogger(PropertyManager.class);

    private static final String PROPERTY_FILE_NAME = "app.properties";
    private static PropertyManager instance;
    private final Properties properties;

    public static PropertyManager getInstance() {
        if (instance == null) {
            instance = new PropertyManager();
        }
        return instance;
    }

    private PropertyManager() {
        log.debug("In constructor SongPropertyManager().");
        properties = new Properties();
        ClassLoader classLoader = PropertyManager.class.getClassLoader();
        try (InputStream in = classLoader.getResourceAsStream(PROPERTY_FILE_NAME)) {
            log.debug("Load property file...");
            properties.load(in);
        } catch (Exception e) {
            log.error("Couldn't load properties from file '{}'. Check the file name.", PROPERTY_FILE_NAME, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * The method gives a property by key.
     *
     * @param key key of value
     * @return property was loaded from resources.
     */
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
