import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Fallen
 * Date: 2017/3/9
 * Time: 14:10
 * Usage:
 */
public class test {
    public static void main(String[] args) throws Exception {
        File file = new File("D:\\Temp\\48084485-9b83-4c80-83ae-48239e6901ce.txt");
        file.createNewFile();
        OutputStream out = new FileOutputStream(file);
    }
}
