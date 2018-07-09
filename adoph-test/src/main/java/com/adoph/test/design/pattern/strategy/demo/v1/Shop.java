package com.adoph.test.design.pattern.strategy.demo.v1;

import java.util.List;

/**
 * 商店
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/7/3
 */
public class Shop {
    public void sell(Product p) {
        if (p.getPrice() >= 100) {
            System.out.println(p.getPrice() - 30);
        } else {
            System.out.println(p.getPrice());
        }
    }
}
