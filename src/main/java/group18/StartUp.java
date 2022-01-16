package group18;

import group18.adapters.PaymentController;
import messaging.implementations.RabbitMqQueue;

public class StartUp {
    public static void main(String[] args) {
        System.out.println("Start up now!");
        var mq = new RabbitMqQueue("localhost");
        new PaymentController(mq);
    }
}
