package com.adoph.test.jms;

/**
 * 消息发送客户端
 *
 * @author Adoph
 * @version v1.0
 * @date 2019/1/9
 */
public class MessageClient {

    /**
     * 发送消息
     *
     * @param msg      消息体
     * @param executor 执行业务代码
     * @param callback 回调
     * @return Result
     */
    public static Result post(Message msg, BusinessExecutor executor, PostMessageCallback callback) {
        //1.写入一条待处理的消息至全局的存储介质（比如： Redis等）
        //2.业务操作
        executor.execute();
        //3.更新全局消息为已处理
        //4.推送消息至消息中间件
        send(msg);
        //5.根据发送消息结果执行回调
        callback.success();
        return new Result();
    }

    public static void send(Message msg) {
        System.out.println("发送消息到消息中间件：" + msg.getMsg());
    }

}
