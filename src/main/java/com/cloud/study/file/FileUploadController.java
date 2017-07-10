package com.cloud.study.file;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * Created by 37300 on 2017/7/10.
 */
@Controller
@RequestMapping("file")
public class FileUploadController {

    @RequestMapping(value = "/to-upload")
    public String toUpload() {
        return "fileUpload.html";
    }


    @PostMapping(value = "/upload")
    public void upload(@RequestParam(value = "file", required = false) MultipartFile file) {

        System.out.println("开始");
        String path = "I:\\XMMZ\\file-user";
        String fileName = file.getOriginalFilename();
        System.out.println(path);
        File targetFile = new File(path, fileName);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("文件大小：" + targetFile.getTotalSpace());
    }
}
