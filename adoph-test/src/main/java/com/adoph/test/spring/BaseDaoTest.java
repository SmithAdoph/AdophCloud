package com.adoph.test.spring;

import com.adoph.framework.TestJpaApplication;
import com.adoph.framework.service.MyService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * 基础BaseDao测试
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/6/3
 */
@SpringBootTest(classes = TestJpaApplication.class)
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class BaseDaoTest {

    @Resource
    private MyService myService;

    @Test
    public void test() {
        myService.test();
    }
}
