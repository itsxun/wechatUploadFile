package xin.fallen.serviceimpl;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import xin.fallen.service.FileManagerSer;
import xin.fallen.util.PropReader;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Fallen
 * Date: 2017/3/9
 * Time: 14:05
 * Usage:
 */
@Service
public class FileManagerSerImpl implements FileManagerSer {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
    private Logger log = LoggerFactory.getLogger(this.getClass());

    public String FileDurable(String busType, File file) {
        String rootStr = PropReader.getProperty(busType);
        String fileName = file.getName();
        File root = new File(rootStr);
        if (!root.isDirectory()) {
            root.mkdir();
        }
        String dirStr = root.getAbsolutePath() + File.separator + sdf.format(new Date());
        File dir = new File(dirStr);
        if (!dir.exists() || !dir.isDirectory()) {
            dir.mkdir();
        }
        try {
            FileUtils.copyFileToDirectory(file, dir);
        } catch (IOException e) {
            log.error("文件存储失败，原因是：{}", e.getMessage());
            return null;
        }
        if (new File(dirStr + File.separator + fileName).isFile()) {
            return dirStr + File.separator + fileName;
        }
        return null;
    }
}
