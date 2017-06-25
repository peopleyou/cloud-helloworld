package com.cloud.study;

import com.cloud.study.data.AppPropData;
import com.cloud.study.data.YAMLData;
import com.cloud.study.logging.LoggingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Hello world!
 */
@Configuration
@RestController
@EnableAutoConfiguration
@ComponentScan
public class App {

    @Resource
    private AppPropData appPropData;
    @Resource
    private YAMLData yamlData;
    @Resource
    private LoggingTest loggingTest;

    @RequestMapping("/test-logging")
    void testLogging() {
        loggingTest.doSomething();
    }

    @RequestMapping("/")
    String home() {
        return "Hello World222!";
    }

    @RequestMapping("/print-app-prop")
    String printApplicationProp() {
        String appProp = appPropData.toString();
        return appProp;
    }

    @RequestMapping("/print-yaml-data")
    String printYAML() {
        List<String> servers = yamlData.getServers();
        return servers.toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(App.class, args);
    }
}
