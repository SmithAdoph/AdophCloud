package com.adoph.test.jvm;

import java.util.HashMap;
import java.util.Map;

/**
 * todo: 描述
 *
 * @author adoph
 * @version v1.0
 * @date 2020/7/29
 */
public class AnonymousInnerClassOOMTest {

    public static void main(String[] args) {
        String name = "test";

        for (;;) {
            HashMap<String, Object> hashMap = new HashMap<String, Object>() {
                {
                    put("t1", "t1");
                    put("t2", name);
                }
            };
            System.out.println(hashMap.get("t1"));
        }

    }
}
