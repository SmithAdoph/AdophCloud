package com.adoph.framework.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * JSON转换工具类
 *
 * @author Adoph
 * @version v1.0
 * @date 2017/12/29
 */
public class JSONUtils {

    private JSONUtils() {
    }

    public static String toJSONString(Object o) {
        return JSON.toJSONString(o);
    }

    public static Map<String, Object> toMap(JSONObject object) {
        return JSON.parseObject(object.toJSONString(), new TypeReference<Map<String, Object>>() {
        });
    }
}
