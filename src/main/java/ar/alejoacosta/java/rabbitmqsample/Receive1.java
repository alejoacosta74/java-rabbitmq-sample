package ar.alejoacosta.java.rabbitmqsample;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Receive1 {
    private static final String QUEUE_NAME = "myqueue";

    public void consume () throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println("Waiting for messages...");
        MyConsumer consumer=new MyConsumer(channel);
        channel.basicConsume(QUEUE_NAME, true, consumer);
    }
}

class MyConsumer extends DefaultConsumer {
    private String storedMessage;

    public MyConsumer(Object channelRecv) {
        super((Channel) channelRecv);
    }

    public String getStoredMessage() {
        return storedMessage;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
            throws IOException {
        String message = new String(body, "UTF-8");
        System.out.println(" [x] Received '" + message + "'");
        storedMessage = message; // store message here
    }
}