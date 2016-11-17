package dao.oracle;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by t00191774 on 17/11/2016.
 *
 */
public class OCDProperties {
    private final String FILENAME = "ocd.ini";

    private Properties prop;

    public OCDProperties() {
        prop = new Properties();

        InputStream fileStream = null;
        try {
            fileStream = getClass().getClassLoader().getResourceAsStream(FILENAME);
            prop.load(fileStream);
        } catch (Exception e) {
            System.err.println("Error opening properties file: " + e.getMessage());
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                System.err.println("Error closing the input stream: " + e.getMessage());
            }
        }
    }

    public String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
