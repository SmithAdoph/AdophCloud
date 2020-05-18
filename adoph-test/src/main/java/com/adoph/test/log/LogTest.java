package com.adoph.test.log;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 一、日志的作用：
 * （1）问题追踪和排查
 * （2）描述业务轨迹（为（1）服务）
 * （3）采集用户行为
 * <p>
 * 二、什么时候打日志：
 * （1）复合操作
 * （2）业务逻辑流程（业务轨迹）
 * （3）查询结果在作为某个逻辑判断或者调用的输入参数时候
 * <p>
 * 三、日志内容：
 * （1）简洁
 * （2）人+对象+行为
 * （3）主谓宾
 * （4）输入+输出+异常信息+解决方法
 * <p>
 * 备注：
 * 1.影响业务主流程，必须告警通知
 * 2.告警通知：
 * a.应用名称+业务模块+业务操作
 * b.清晰的参数和过程描述
 * c.可选的处理方法（非常必要）
 *
 * @author adoph
 * @version v1.0
 * @date 2020/5/12
 */
@Slf4j
public class LogTest {

    /**
     * 场景一：单一操作（单一服务，不涉及多服务查询和聚合操作）
     * <p>
     * 结论：
     * 1、一般的查询不涉及修改逻辑的请求参数和查询结果均不打印
     * 2、用户行为通过自定义注解+aop等技术实现
     * 3、不需要异常处理，统一异常拦截器处理（框架层面实现）
     */
    @Test
    public void testQueryUserByParams() {
//        打印参数：一般用作用户行为的采集，建议不打印。除非有用户行为采集需求，而这种通常都是通过自定义注解+aop来实现
//        log.info("用户管理-根据条件查询用户信息，参数：{}", "{userName=adoph}");
//        避免打印查询结果，没有意义
//        log.info("根据条件查询用户信息，查询结果：{}", "[{userId=1,sex=1}]")
//        统一异常拦截处理：
        try {
            System.out.println("服务端异常");
        } catch (Exception e) {
//            1、打印异常堆栈信息
            log.error("服务端异常，异常信息：", e);
//            2、转换异常信息，返回前端
        }
    }

    /**
     * 场景二：复合操作（涉及多个服务或者写库+写缓存+发消息等）
     */
    @Test
    public void testAddUser() {
//        打印参数：建议不打印，在异常处理时才打印参数和具体的异常堆栈信息
//        通常逻辑上会存储创建人信息和创建时间已经足够
//        log.info("用户管理-添加用户，参数：{}", "{userName=adoph,sex=1,age=12}");

//            第一步 添加用户，入库【本地事务：可靠操作】
        System.out.println("入库");
        try {
//            第二步 写缓存【不可靠操作，必须try..catch..】
//            狭义的理解：比如非本地的一些写入操作认为是不可靠的，比如写缓存、调用第三方接口等
//            打印参数
            log.info("用户管理-添加用户-写缓存，参数：{}", "{userName=adoph,sex=1,age=12}");
            System.out.println("缓存");
        } catch (Exception e) {
//            不可预见异常
            log.error("用户管理-添加用户-写缓存异常，参数：{}", "{userName=adoph,sex=1,age=12}", e);
        }

        try {
//            第三步 初始化用户积分数据
            System.out.println("调用积分服务：初始化用户积分数据");
        } catch (Exception e) {
//            可预见异常：
            log.error("用户管理-添加用户：调用用户积分服务-初始化会员积分数据异常，请检查积分系统是否已经注册过该用户，参数：{}",
                    "{userName=adoph, userId=1}", e);
        }
    }

    /**
     * 场景三：业务轨迹
     *
     * 结论：
     * 1、固定格式
     */
    @Test
    public void testDescBus() {
        Long orderId = 1L;
        log.info("订单流程-{}：创建订单，订单信息：{}", orderId, "userId=1,userName=adoph,userPhone=133,orderType=快车");
        log.info("订单流程-{}：订单调度，订单信息：{}", orderId, "");
        log.info("订单流程-{}：订单服务中，订单信息：{}", orderId, "");
        log.info("订单流程-{}：订单结束，订单信息：{}", orderId, "");
        log.info("订单流程-{}：订单评价，订单信息：{}", orderId, "");
    }

}
