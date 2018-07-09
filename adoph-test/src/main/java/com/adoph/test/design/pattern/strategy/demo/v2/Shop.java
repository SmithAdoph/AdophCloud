package com.adoph.test.design.pattern.strategy.demo.v2;

/**
 * 商店
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/3
 */
public class Shop {
    public void sell(Product p) {
        System.out.println(p.getDiscount().calculate(p));
    }
}
