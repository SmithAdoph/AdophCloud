package com.adoph.framework.log.service;

import lombok.Data;

@Data
public class BaseResponse {

    public BaseResponse(int status, String errorMsg) {
        this.status = status;
        this.errorMsg = errorMsg;
    }

    private int status = 200;
    private String errorMsg;

}
