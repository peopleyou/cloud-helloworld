package com.cloud.study.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by yuanyouz on 2017/6/25.
 */
@RestController
@RequestMapping("mvc")
public class MVCController {

    @RequestMapping("get-data")
    public MVCData getData() {
        return new MVCData("hello", 12, "地址");
    }

    @RequestMapping("get-fastjson-data")
    public FastJsonData getFastjsonData() {
        return new FastJsonData("hello", new Date(), 12, 1, null);
    }
}
