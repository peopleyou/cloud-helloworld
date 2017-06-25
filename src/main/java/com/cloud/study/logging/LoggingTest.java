package com.cloud.study.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by yuanyouz on 2017/6/25.
 */
@Service
public class LoggingTest {

    //都是能打出来的
//    private static final Log LOG = LogFactory.getLog(LoggingTest.class);
    private static final Logger LOG = LoggerFactory.getLogger(LoggingTest.class);

    public void doSomething() {
        LOG.info("doSomething begin");
        LOG.info("doSomething end");
    }
}
