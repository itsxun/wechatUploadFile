package xin.fallen.util;

import java.io.*;
import java.util.Properties;

/**
 * Author: Fallen
 * Date: 2017/3/9
 * Time: 13:54
 * Usage:
 */
public class PropReader {
    private static Properties props=new Properties();

    public static boolean propInit() {
        File config = FileFinder.find("config.properties");
        if (config == null) {
            return false;
        }
        try {
            InputStream in = new FileInputStream(config);
            props.load(in);
        } catch (Exception e) {
            e.printStackTrace();
//            throw new RuntimeException("配置文件记载出错");
        }
        return true;
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }
}
