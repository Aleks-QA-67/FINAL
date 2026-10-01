package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties props = new Properties();

    static {
        try (InputStream in = ConfigLoader.class.getClassLoader()
                .getResourceAsStream("config.properties")) {
            if (in == null) throw new RuntimeException("config.properties not found in classpath");
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String get(String key) { return props.getProperty(key); }
    public static String get(String key, String defaultValue) { return props.getProperty(key, defaultValue); }
}