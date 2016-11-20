package ocd.dao.oracle;

import ocd.OCDConsole;

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
            OCDConsole.printlnError("Cannot open file ocd.ini (Does it exist?)");
        } finally {
            try {
                if (fileStream != null) {
                    fileStream.close();
                }
            } catch (IOException e) {
                OCDConsole.printlnError("Error closing the input stream: " + e.getMessage());
            }
        }
    }

    public String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
