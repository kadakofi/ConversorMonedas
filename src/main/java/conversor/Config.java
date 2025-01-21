package conversor;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    private static final Properties properties = new Properties();

    static {
        try (InputStream input = Config.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("Archivo config.properties no encontrado en resources.");
            }
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración: " + e.getMessage());
        }
    }

    public static String getApiKey() {
        return properties.getProperty("api.key");
    }

    public static String getApiUrl() {
        return properties.getProperty("api.url");
    }
}

