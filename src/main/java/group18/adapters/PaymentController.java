package group18.adapters;

import dtu.ws.fastmoney.BankServiceService;
import group18.domain.PaymentRegistration;
import group18.domain.model.Payment;
import group18.domain.ports.IBankWrapper;
import messaging.Event;
import messaging.MessageQueue;

public class PaymentController {
    MessageQueue queue;
    BankServiceService bankService = new BankServiceService();
    IBankWrapper bankWrapper = new BankWrapper(bankService);
    PaymentRegistration payService = new PaymentRegistration(bankWrapper);


    public PaymentController(MessageQueue q) {
        queue = q;
        queue.addHandler("InitiatePayment",this::handlePaymentInitiation);
    }

    public void handlePaymentInitiation(Event e){
        var p = e.getArgument(0, Payment.class);
        payService.createPayment(p);
    }
}
