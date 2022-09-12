package com.adoph.test.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * todo 描述
 *
 * @author tangqd
 * @version 1.0
 * @since 2021/6/24
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringJdbcConfig.class)
public class DBProxyTest {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test() {
        jdbcTemplate.query("select schema()", resultSet -> {
            System.out.println(111);
            System.out.println(111);
        });
    }

}
