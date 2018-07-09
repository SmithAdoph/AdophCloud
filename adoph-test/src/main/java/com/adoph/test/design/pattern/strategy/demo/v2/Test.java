package com.adoph.test.design.pattern.strategy.demo.v2;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/3
 */
public class Test {
    public static void main(String[] args) {
        Product p  = new Product("西瓜", 200);
        p.setDiscount(new ActDiscount());
        Shop shop = new Shop();
        shop.sell(p);
    }
}
