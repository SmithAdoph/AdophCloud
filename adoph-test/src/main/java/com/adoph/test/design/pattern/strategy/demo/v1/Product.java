package com.adoph.test.design.pattern.strategy.demo.v1;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/3
 */
public class Product {

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}