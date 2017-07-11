package com.cloud.study.file.converter;

import java.io.IOException;

/**
 * Created by 37300 on 2017/7/11.
 */
public class OpenOfficeStarter {

    public static void main(String[] args) {
        // 启动OpenOffice的服务
        String command = "I:\\Applications\\OpenOffice4\\program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=2002;urp;StarOffice.ServiceManager\" -nofirststartwizard";
        try {
            Process pro = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
