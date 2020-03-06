package com.adoph.framework.log.service;

import com.adoph.framework.log.LogApi;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @LogApi(operator = "test", op = LogApi.Operation.CREATE, serviceModule = "数据源", serviceDesc = "新增数据源")
    public BaseResponse test() {
        System.out.println("test新增数据源操作");
        return new BaseResponse(404, "找不到请求地址");
    }

}
