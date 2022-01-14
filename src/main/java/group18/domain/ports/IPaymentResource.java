package group18.domain.ports;

import group18.domain.model.Payment;

import javax.ws.rs.core.Response;

public interface IPaymentResource {
    Response add(Payment payment);
}
