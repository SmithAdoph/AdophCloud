package com.adoph.test.jms;

/**
 * 消息体
 *
 * @author Adoph
 * @version v1.0
 * @date 2019/1/9
 */
public class Message {

    /**
     * 消息内容
     */
    private Object msg;

    /**
     * 消息主题
     */
    private String topic;

    /**
     * 消息标签
     */
    private String tag;

    /**
     * 关键标识
     */
    private String key;

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
