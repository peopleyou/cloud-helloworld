package com.cloud.study.file.converter;

import com.cloud.study.App;
import org.jodconverter.boot.autoconfigure.JodConverterAutoConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * Created by 37300 on 2017/7/11.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {App.class, JodConverterAutoConfiguration.class})
public class OfficeDocumentConverterServiceTest {

    @Resource
    private OfficeDocumentConverterService converterService;

    @Test
    public void testConvertWps() throws Exception {
        converterService.converWpsByConfig();
        Thread.sleep(1000*20);
    }

    @Test
    public void testConvertWord() throws Exception {
        converterService.converWordByConfig();
        Thread.sleep(1000*20);
    }

    @Test
    public void testConvertExcel() throws Exception {
        converterService.converExcelByConfig();
        Thread.sleep(1000*20);
    }

    @Test
    public void testConvertPpt() throws Exception {
        converterService.converPPTByConfig();
        Thread.sleep(1000*20);
    }

    @Test
    public void testConvertTxt() throws Exception {
        converterService.converTXTByConfig();
        Thread.sleep(1000*20);
    }

    @Test
    public void testConvert2Html() throws Exception {
        converterService.convert2HtmlByConfig();
        Thread.sleep(1000*20);
    }


}
