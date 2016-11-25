package ocd.dao.oracle;

import ocd.OCDConsole;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by t00191774 on 17/11/2016.
 *
 */
class OCDProperties {

    private Properties prop;

    OCDProperties() {
        prop = new Properties();

        InputStream fileStream = null;
        try {
            String fileName = "ocd.ini";
            fileStream = getClass().getClassLoader().getResourceAsStream(fileName);
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

    String getProperty(String propertyName) {
        return prop.getProperty(propertyName);
    }
}
