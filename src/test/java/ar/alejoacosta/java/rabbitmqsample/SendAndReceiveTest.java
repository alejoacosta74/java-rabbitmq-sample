package ar.alejoacosta.java.rabbitmqsample;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.*;

class SendAndReceiveTest {

    @Test
    void sendMessage() {
        Send send = new Send();
        try {
            send.produce("test message");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    @Test
    void receiveMessage(){
        Receive1 receive = new Receive1();
        try {
            receive.consume();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}