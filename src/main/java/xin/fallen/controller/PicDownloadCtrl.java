package xin.fallen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xin.fallen.service.PicDownloadSer;

import javax.annotation.Resource;

/**
 * Author: Fallen
 * Date: 2017/3/9
 * Time: 14:51
 * Usage:
 */
@Controller
@RequestMapping("pic")
public class PicDownloadCtrl {
    @Resource
    private PicDownloadSer picDownloadSerImpl;



}
