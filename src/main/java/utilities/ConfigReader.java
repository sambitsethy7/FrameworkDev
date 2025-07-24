package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;

    static {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static List<String> getExpectedMenuItems(){
        Properties prop=new Properties();
        try{
            FileInputStream fis=new FileInputStream("src/test/resources/testdata/expectedMenu.properties");
            prop.load(fis);
        } catch(IOException e){
            e.printStackTrace();
        }
        String menu = prop.getProperty("left.menu.items");
        return Arrays.asList(menu.split(","));
    }
}
