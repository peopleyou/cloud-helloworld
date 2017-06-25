package com.cloud.study.data;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanyouz on 2017/6/18.
 */
@ConfigurationProperties(prefix="my")
@Component
public class YAMLData {
    private List<String> servers = new ArrayList<String>();

    public List<String> getServers() {
        return this.servers;
    }
}
