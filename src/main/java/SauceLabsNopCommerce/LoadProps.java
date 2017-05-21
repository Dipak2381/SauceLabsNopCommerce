package SauceLabsNopCommerce;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by DIPAK on 5/14/2017.
 */
public class LoadProps extends Basepage
{
    //static Properties properties;
    // static FileInputStream inputStream;

    public String getProperty(String key)
    {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream= new FileInputStream("src/test/Resources/config.properties");
            properties.load(inputStream);
        }catch (Exception e)
        {
            e.fillInStackTrace();
        }
        return properties.getProperty(key);
    }
}
