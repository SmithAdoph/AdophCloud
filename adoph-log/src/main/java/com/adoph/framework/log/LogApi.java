package com.adoph.test.log;

import java.lang.annotation.*;

/**
 * 日志注解：
 * 1、操作日志
 * 2、安全日志
 * <p>
 * 详细：
 * 1.操作人、操作时间、功能块、操作类型（增删改）、操作结果
 *
 * @author adoph
 * @version v1.0
 * @date 2019/12/3
 */
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.METHOD)
public @interface LogApi {

    /**
     * 操作人
     *
     * @return string
     */
    String operator();

    /**
     * 业务模块
     *
     * @return string
     */
    String serviceModule();

    /**
     * 业务描述
     *
     * @return string
     */
    String serviceDesc() default "";

    /**
     * 操作类型
     *
     * @return @see Operation
     */
    Operation op();

    /**
     * 操作结果
     *
     * @return @see OperateResult
     */
    OperateResult result() default OperateResult.SUCCESS;

    /**
     * 操作类型枚举
     */
    enum Operation {

        QUERY(0, "查询"),
        CREATE(1, "新增"),
        UPDATE(2, "更新"),
        DELETE(3, "删除");

        private Integer index;
        private String text;


        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        Operation(Integer index, String text) {
            this.index = index;
            this.text = text;
        }

    }

    /**
     * 操作结果枚举
     */
    enum OperateResult {

        SUCCESS(1, "成功"),
        FAILURE(2, "失败"),
        EXCEPTION(3, "异常");
        private Integer index;
        private String text;

        OperateResult(Integer index, String text) {
            this.index = index;
            this.text = text;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

}
