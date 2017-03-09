package xin.fallen.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import xin.fallen.service.FileManagerSer;
import xin.fallen.util.PropReader;
import xin.fallen.vo.JsonResult;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Author: Fallen
 * Date: 2017/3/9
 * Time: 14:26
 * Usage:
 */
@Controller
@RequestMapping("/file")
public class FileDurableCtrl {
    private Logger log = LoggerFactory.getLogger(this.getClass());
    @Resource
    private FileManagerSer fileManagerSerImpl;

    @ResponseBody
    @RequestMapping("/save")
    public JsonResult fileSave(@RequestParam("fileUpload") MultipartFile fileEx, String busType) {
        JsonResult jr = new JsonResult();
        String suffix = fileEx.getOriginalFilename().substring(fileEx.getOriginalFilename().lastIndexOf("."));
        File file = new File(PropReader.getProperty("tempDir") + File.separator + UUID.randomUUID().toString() + suffix);
        try {
            fileEx.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件取出发生错误，原因是：{}", e.getMessage());
            jr.setRes("0");
            jr.setMsg("请求已收到，然而把文件弄出来发生错误了，呵呵...");
            return jr;
        }
        String res = fileManagerSerImpl.FileDurable(busType, file);
        if (res == null) {
            jr.setRes("0");
            jr.setMsg("失败，原因看日志");
        } else {
            jr.setRes("1");
            jr.setMsg("成功!可喜可贺!");
            jr.setData(res);
        }
        return jr;
    }
}
