package com.cloud.study.file.converter;

import org.jodconverter.OfficeDocumentConverter;
import org.jodconverter.boot.autoconfigure.JodConverterProperties;
import org.jodconverter.office.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

/**
 * Created by 37300 on 2017/7/11.
 */
@Service
public class OfficeDocumentConverterService {

    @Resource
    private JodConverterProperties jodConverterProperties;

    @Resource
    private OfficeManager officeManager;

    public void converWpsByConfig() {
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File("I:\\XMMZ\\file-user\\1.wps"),
                    new File("I:\\XMMZ\\file-user\\wps.pdf"));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    public void converWordByConfig() {
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File("I:\\XMMZ\\file-user\\1.docx"),
                    new File("I:\\XMMZ\\file-user\\word.pdf"));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    public void converExcelByConfig() {
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File("I:\\XMMZ\\file-user\\1.xlsx"),
                    new File("I:\\XMMZ\\file-user\\excel.pdf"));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    public void converPPTByConfig() {
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File("I:\\XMMZ\\file-user\\1.pptx"),
                    new File("I:\\XMMZ\\file-user\\ppt.pdf"));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    public void converTXTByConfig() {
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File("I:\\XMMZ\\file-user\\1.txt"),
                    new File("I:\\XMMZ\\file-user\\txt.pdf"));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    public void convert2HtmlByConfig() {
        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
        try {
            converter.convert(new File("I:\\XMMZ\\file-user\\月新闻稿.docx"),
                    new File("I:\\XMMZ\\file-user\\word.html"));
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }


    public void converFileByExternal() {
        Process pro = null;
        OfficeManager officeManager = null;
        try {
            // 启动OpenOffice的服务
            String command = jodConverterProperties.getOfficeHome()
                    + "\\program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=2002;urp;StarOffice.ServiceManager\" -nofirststartwizard";
            pro = Runtime.getRuntime().exec(command);
            ExternalOfficeManagerBuilder externalOfficeManagerBuilder = new ExternalOfficeManagerBuilder();
            officeManager = externalOfficeManagerBuilder.build();
            if (!officeManager.isRunning()) {
                officeManager.start();
            }
            OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
            converter.convert(new File("I:\\XMMZ\\file-user\\1.docx"),
                    new File("I:\\XMMZ\\file-user\\1.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                officeManager.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (pro != null) {
                // 封闭OpenOffice服务的进程
                pro.destroy();
            }
        }
    }
}
