package com.dumm.rabbitMq;
/**
 * Created by dumm on 2019/2/22.
 */

/**
 * @ProjectName: giteeLearn
 * @Package: com.dumm
 * @ClassName: SendMQ
 * @Description: java类作用描述
 * @Author: dumm
 * @Date： 2019/2/22
 */
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class SendMQ {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            String message = "Hello World!1111534444444444";
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
            System.out.println(" [x] Sent '" + message + "'");
        }
    }
}