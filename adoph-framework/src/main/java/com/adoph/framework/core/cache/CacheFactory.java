package com.adoph.framework.core.cache;

import com.adoph.framework.core.cache.service.RedisCacheService;
import com.adoph.framework.core.cache.service.impl.RedisCache;

/**
 * 缓存工厂
 *
 * @author Adohp
 * @version v1.0
 * @date 2017/9/22
 */
public class CacheFactory {

    private CacheFactory() {
    }

    /**
     * Redis缓存
     *
     */
    private static RedisCacheService<String, Object> redisCache;

    /**
     * Redis 字符串缓存
     * <p>
     * volatile
     * (1)作用：
     *  1.保证内存可见性（不适用寄存器等缓存）
     *  2.禁止指令重排序
     * (2)使用场景：（源自Java并发编程实战）
     *  1.对变量的写入操作不依赖变量的当前值，或者你能确保只有单个线程更新变量的值
     *  2.该变量不会与其他状态变量一起纳入不变性条件
     *  3.在访问变量时不需要加锁
     *  synchronized:
     *  1.可见性
     *  2.原子性
     *
     * 去掉volatile关键字
     */
    private static RedisCacheService<String, String> stringRedisCache;

    /**
     * 获取Redis缓存
     *
     * @return RedisCacheService
     */
    public static RedisCacheService<String, Object> getRedisCache() {
        // 双重检查
        if (redisCache == null) {
            synchronized (CacheFactory.class) {
                if (redisCache == null) {
                    redisCache = new RedisCache<>(false);
                }
            }
        }
        return redisCache;
    }

    /**
     * 获取Redis缓存
     * <p>
     * 双重检查的作用：
     * 1.第一次检查，如果存在实例，直接返回。避免每次加锁，提高性能
     * 2.第二次检查：线程t1、t2获取实例，当前实例为空，当t1、t2同时通过第一次检查，t2拿到锁创建实例。
     * t1等待t2执行完成，此时实例已经创建，t1拿到锁继续创建实例，导致重复创建实例的问题（降低程序效率）。
     * 为了避免这种问题，在获取到锁后再进行第二次检查，如果实例已经存在则直接返回。
     *
     * @return RedisCacheService
     */
    public static RedisCacheService<String, String> getStringRedisCache() {
        // 双重检查
        if (stringRedisCache == null) {
            synchronized (CacheFactory.class) {
                if (stringRedisCache == null) {
                    stringRedisCache = new RedisCache<>(true);
                }
            }
        }
        return stringRedisCache;
    }

}
