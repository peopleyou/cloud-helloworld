package com.cloud.study.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 37300 on 2017/8/5.
 */
@Controller
@RequestMapping("/file")
public class FileMd5Controller {

    @RequestMapping(value = "/to-test-md5")
    public String toPreview() {
        return "fileMd5.html";
    }
}
