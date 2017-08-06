package com.cloud.study.file;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by 37300 on 2017/7/12.
 */
@Controller
@RequestMapping("/file")
public class FilePreviewController {
    @RequestMapping(value = "/to-test-preview")
    public String toPreview() {
        return "pdfFilePreview.html";
    }

    @RequestMapping(value = "/to-test-video-preview")
    public String toVideoPreview() {
        return "videoFilePreview.html";
    }

    @RequestMapping(value = "/to-preview-page")
    public String previewPage(@RequestParam("file") String file) throws UnsupportedEncodingException {
        if (StringUtils.isBlank(file)) {
            throw new RuntimeException("未指定参数：file");
        }

        String encodeURI = URLEncoder.encode("/file/load-pdf?file=" + file, "utf-8");
        return "redirect:viewer.html?file=" + encodeURI;
    }

    @RequestMapping(value = "/load-pdf", method = RequestMethod.GET)
    public void loadContract(@RequestParam("file") String file, HttpServletResponse response) throws Exception {
        if (StringUtils.isBlank(file)) {
            throw new RuntimeException("未指定参数：file");
        }
        File pdf = new File("I:\\XMMZ\\file-user\\" + file + ".pdf");

        //将文件读取为byte[]
        byte[] buffer = readInputStream(new FileInputStream(pdf));

        //将pdf输出
        response.reset();
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;filename=" + new String(pdf.getName().getBytes("UTF-8"), "ISO-8859-1"));
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

    public static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        int len;
        while((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }

        bos.close();
        return bos.toByteArray();
    }

}
