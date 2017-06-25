package com.cloud.study.data;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by yuanyouz on 2017/6/18.
 */
@Component
public class AppPropData {

    @Value("${name}")
    private String name;
    @Value("${my.uuid}")
    private String uuid;

    public String getName() {
        return name;
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public String toString() {
        return "AppPropData{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
