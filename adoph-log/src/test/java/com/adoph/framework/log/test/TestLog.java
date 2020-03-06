package com.adoph.framework.log.test;

import com.adoph.framework.log.Application;
import com.adoph.framework.log.service.TestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@SpringBootTest(classes = Application .class)
@RunWith(SpringRunner.class)
public class TestLog {

    @Resource
    private TestService testService;

    @Test
    public void test() {
        testService.test();
    }
}
