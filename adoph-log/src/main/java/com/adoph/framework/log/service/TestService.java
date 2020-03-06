package com.adoph.framework.log;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    @LogApi(operator = "test", op = LogApi.Operation.CREATE, serviceModule = "数据源", serviceDesc = "新增数据源")
    public void test() {
        System.out.println("test新增数据源操作");
    }

}
