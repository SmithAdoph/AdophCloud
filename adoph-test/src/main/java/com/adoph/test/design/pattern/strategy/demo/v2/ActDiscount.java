package com.adoph.test.design.pattern.strategy.demo.v2;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/3
 */
public class ActDiscount implements Discount {
    @Override
    public int calculate(Product p) {
        return p.getPrice() * 80 / 100;
    }
}
