package com.cloud.study.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.midi.Soundbank;
import java.io.File;

/**
 * Created by 37300 on 2017/7/10.
 */
@Controller
@RequestMapping("file")
public class MultiFileUploadController {

    @RequestMapping(value = "/to-multi-file")
    public String toUpload() {
        return "multiFileInput.html";
    }

    /**
     * 多文件上传
     * @param file
     * @return
     */
    @PostMapping(value = "/multi/upload")
    @ResponseBody
    public String fileUpload(MultipartFile file, String key, String acl, String AWSAccessKeyId) {
        if (file != null) {
            System.out.println(file.getSize());
        }
        System.out.println(key);
        System.out.println(acl);
        System.out.println(AWSAccessKeyId);
        return "ok";
    }
}
