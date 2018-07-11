package com.adoph.test.design.pattern.chain.v2;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/11
 */
public class Request<T> {
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
