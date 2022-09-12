package com.adoph.framework.util.bean;

import lombok.Data;

import java.util.List;

@Data
public class Menu {

    private String id;
    private String pid;
    private String url;
    private Integer sort;
    private List<Menu> children;


    public Menu(String id, String pid, String url) {
        this.id = id;
        this.pid = pid;
        this.url = url;
    }

}