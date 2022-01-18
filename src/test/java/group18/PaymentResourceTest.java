package group18;

import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceService;
import group18.payment.adapters.bankTransfer.BankTransferService;
import group18.payment.adapters.bankTransfer.impl.WsBankTransferService;
import group18.payment.adapters.payment.PaymentPayload;
import group18.payment.adapters.payment.PaymentResource;
import group18.payment.domain.PaymentService;
import group18.payment.domain.cache.PaymentsCache;
import group18.payment.domain.cache.impl.PaymentsInMemory;
import group18.payment.utilities.messaging.Event;
import group18.payment.utilities.messaging.MessageQueue;
import group18.payment.utilities.messaging.impl.RabbitMqQueue;

import java.util.UUID;

public class PaymentResourceTest {

    PaymentsCache cache = PaymentsInMemory.instance();
    BankService bankService = new BankServiceService().getBankServicePort();
    BankTransferService bank = new WsBankTransferService(bankService);

    PaymentService paymentService = new PaymentService(cache, bank);
    MessageQueue messageQueue = new RabbitMqQueue();

    PaymentResource p = new PaymentResource(messageQueue, paymentService);

   public void testHandlePaymentRequestedEvent() {
        var event = new Event("PaymentRequested", new Object[] {UUID.randomUUID().toString(), new PaymentPayload("123", "124", "1000", null, null, null)});
        p.handlePaymentRequestedEvent(event);
   }


}