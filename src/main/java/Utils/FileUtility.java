package Utils;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {

    public String getPropertyKeyValue(String key) throws Throwable {
        FileInputStream fis = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
        Properties p = new Properties();
        p.load(fis);
        return p.getProperty(key);
    }
}
