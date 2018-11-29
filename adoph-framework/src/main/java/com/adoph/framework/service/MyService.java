package com.adoph.framework.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/6/4
 */
public interface MyService {
    @Transactional
    void test();
}
