package com.adoph.test.proxy.task;

/**
 * TODO
 *
 * @author Adoph
 * @version v1.0
 * @since 2018/6/26
 */
public abstract class AbstractTask {
    /**
     * 任务名称
     */
    private String name;

    /**
     * 任务标识
     */
    private String flag;

    /**
     * 任务执行内容
     */
    abstract void exec();
}
