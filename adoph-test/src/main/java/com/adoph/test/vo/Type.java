package com.adoph.test.vo;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @date 2018/6/4
 */
public enum Type {
    SYS_TYPE_ADMIN(1, "系统管理员"),
    SYS_TYPE_USER(2, "普通用户");

    private int index;
    private String text;

    Type(int index, String text) {
        this.index = index;
        this.text = text;
    }

    public int getIndex() {
        return index;
    }

    public String getText() {
        return text;
    }
}
