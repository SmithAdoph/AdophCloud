package com.adoph.test.jms;

/**
 * 推送消息回调
 *
 * @author Adoph
 * @version v1.0
 * @date 2019/1/9
 */
public interface PostMessageCallback {

    /**
     * 异常
     *
     * @param errorCode 错误代码
     * @param errorMsg  错误信息，一般为自定义的Exception，暂用普通字符串代替
     */
    public void error(String errorCode, String errorMsg);


    /**
     * 成功，执行业务代码
     */
    public void success();

}
