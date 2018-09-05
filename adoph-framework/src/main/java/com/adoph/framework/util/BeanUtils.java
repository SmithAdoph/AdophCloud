package com.adoph.framework.util;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Bean工具类
 *
 * @author Adoph
 * @version 1.0
 * @since 2018/09/03
 */
public final class BeanUtils {

    private BeanUtils() {
    }

    /**
     * 数据拷贝
     *
     * @param src  源
     * @param dest 目标
     */
    public static void copy(Object src, Object dest) {
        if (src == null || dest == null) {
            return;
        }
        if (src instanceof JSONObject) {
            JSONObject object = (JSONObject) src;
            Map<String, Object> map = JSONUtils.toMap(object);
            copyMap2Bean(null, map, dest);
        } else if (src instanceof Map) {
            copyMap2Bean(null, (Map<?, ?>) src, dest);
        } else {
            copyBean2Bean(null, src, dest);
        }
    }

    /**
     * 设置字段值
     *
     * @param prefix 前缀
     * @param src    源对象
     * @param dest   目标对象
     * @param field  目标字段
     */
    private static void setFieldValue(String prefix, Map<?, ?> src, Object dest, Field field) {
        try {
            String value = getValue(prefix, src, field);
            if (value == null) {
                field.set(dest, null);
            } else {
                Class<?> clazz = field.getType();
                if (Long.class.isAssignableFrom(clazz)) {
                    field.set(dest, Long.valueOf(value));
                } else if (BigDecimal.class.isAssignableFrom(clazz)) {
                    field.set(dest, new BigDecimal(value));
                } else if (java.sql.Date.class.isAssignableFrom(clazz)) {// java.sql.Date
                    Timestamp date = DateUtils.parse(value);
                    if (date != null) {
                        field.set(dest, new java.sql.Date(date.getTime()));
                    }
                } else if (Date.class.isAssignableFrom(clazz)) {
                    Timestamp date = DateUtils.parse(value);
                    field.set(dest, date);
                } else if (String.class.isAssignableFrom(clazz)) {
                    field.set(dest, value);
                } else {
                    Constructor<?> c = clazz.getConstructor(String.class);
                    Object object = c.newInstance(value);
                    field.set(dest, object);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 取得属性值
     *
     * @param prefix 前缀
     * @param src    数据源
     * @param field  字段
     * @return String
     */
    private static String getValue(String prefix, Map<?, ?> src, Field field) {
        Object value;
        if (StringUtils.isValid(prefix)) {
            value = src.get(merge(prefix, field.getName()));
        } else {
            value = src.get(field.getName());
        }
        if (value instanceof Date) {
            value = DateUtils.formatFull((Date) value);
        }
        return StringUtils.isEmpty(value) ? null : value.toString();
    }

    /**
     * 取得字段值
     *
     * @param obj       目标对象
     * @param fieldName 字段名
     * @return
     */
    @SuppressWarnings("all")
    public static <T> T getFieldValue(Object obj, String fieldName) {
        if (obj == null) {
            return null;
        }
        Object value = null;
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.getName().equals(fieldName)) {
                    field.setAccessible(true);
                    value = field.get(obj);
                    break;
                }
            }
        } catch (Exception e) {
            //do nothing
        }
        return (T) value;
    }

    /**
     * 数据拷贝
     *
     * @param prefix 源前缀
     * @param src    源
     * @param dest   目标
     */
    public static void copy(String prefix, Object src, Object dest) {
        if (src == null || dest == null) {
            return;
        }
        if (src instanceof Map) {
            copyMap2Bean(prefix, (Map<?, ?>) src, dest);
        } else {
            copyBean2Bean(prefix, src, dest);
        }
    }

    /**
     * 拷贝Bean->Bean
     *
     * @param src  源
     * @param dest 目标
     */
    private static void copyBean2Bean(String prefix, Object src, Object dest) {
        Class<?> srcClass = src.getClass();
        Class<?> destClass = dest.getClass();
        try {
            if (srcClass.equals(destClass)) {// 源类型与目标类型相同
                Field[] fields = src.getClass().getDeclaredFields();
                for (Field field : fields) {
                    if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                        field.setAccessible(true);
                        field.set(dest, field.get(src));
                    }
                }
            } else {// 源类型与目标类型不同
                Field[] srcFields = src.getClass().getDeclaredFields();
                Field[] destFields = dest.getClass().getDeclaredFields();
                for (Field srcField : srcFields) {
                    for (Field destField : destFields) {
                        if (!Modifier.isStatic(srcField.getModifiers()) && !Modifier.isFinal(srcField.getModifiers())) {
                            if (!Modifier.isStatic(destField.getModifiers())
                                    && !Modifier.isFinal(destField.getModifiers())) {
                                if (srcField.getName().equals(destField.getName())
                                        && destField.getType().isAssignableFrom(srcField.getType())) {
                                    srcField.setAccessible(true);
                                    destField.setAccessible(true);
                                    Object srcValue = srcField.get(src);
                                    destField.set(dest, srcValue);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 是否是需要设置的字段
     *
     * @param field 字段
     * @return boolean
     */
    private static boolean isAccessField(Field field) {
        Class<?> clazz = field.getType();
        int m = field.getModifiers();
        // 是private
        // 非
        // static
        return (Modifier.isPrivate(m) || Modifier.isProtected(m))
                && !Modifier.isStatic(m)
                && (Number.class.isAssignableFrom(clazz) || Date.class.isAssignableFrom(clazz) || String.class.isAssignableFrom(clazz));
    }

    /**
     * 拷贝Map->Bean
     *
     * @param src  源
     * @param dest 目标
     */
    private static void copyMap2Bean(String prefix, Map<?, ?> src, Object dest) {
        Field[] fields = dest.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (isAccessField(field)) {
                field.setAccessible(true);
                if (isSetValueEnable(prefix, src, field)) {// 是否需要设置值,Map里面有的才映射过去
                    setFieldValue(prefix, src, dest, field);
                }
            }
        }
    }

    /**
     * 字段是否需要设置值
     *
     * @param prefix 前缀
     * @param src    数据源
     * @param field  字段
     * @return boolean
     */
    private static boolean isSetValueEnable(String prefix, Map<?, ?> src, Field field) {
        if (StringUtils.isValid(prefix)) {
            return src.containsKey(merge(prefix, field.getName()));
        }
        return src.containsKey(field.getName());
    }

    /**
     * 取得属性
     *
     * @param prefix 前缀
     * @param name   字段名
     * @return 下划线分割
     */
    private static String merge(String prefix, String name) {
        return prefix + "-" + name;
    }

    /**
     * Bean转换为Map格式
     *
     * @param bean 数据源
     * @return Map
     */
    public static Map<String, Object> toMap(Object bean) {
        if (bean == null) {
            return null;
        }
        Field[] fields = bean.getClass().getDeclaredFields();
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                if (!Modifier.isStatic(field.getModifiers())) {
                    map.put(field.getName(), field.get(bean));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public static void main(String[] args) {
    }
}