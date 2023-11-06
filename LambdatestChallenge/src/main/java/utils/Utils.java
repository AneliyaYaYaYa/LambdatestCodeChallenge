package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    private static final String MAP = "src/test/resources/map.properties";
    public static final Logger LOGGER = LogManager.getRootLogger();

    private static Properties loadProperties(String url) {
        Properties properties = new Properties();

        try {
            properties.load(Files.newInputStream(Paths.get(url)));
        } catch (IOException ex) {
            LOGGER.error("Loading properties failed!");
        }
        return properties;
    }

    public static String getUIMappingByKey(String key) {
        String value = loadProperties(MAP).getProperty(key);
        return value != null ? value : key;
    }
}
