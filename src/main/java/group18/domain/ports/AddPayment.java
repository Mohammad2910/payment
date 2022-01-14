package group18.domain.ports;

import group18.domain.model.Payment;

public interface AddPayment {
    void createPayment(Payment payment);
}
