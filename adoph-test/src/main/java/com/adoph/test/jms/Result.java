package com.adoph.test.jms;

/**
 * 推送消息结果
 *
 * @author Adoph
 * @version v1.0
 * @date 2019/1/9
 */
public class Result {

    /**
     * 状态
     */
    private String status;

    /**
     * 状态码
     */
    private int code;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
