package group18.domain.ports;

import group18.domain.PaymentRegistration;

public interface IBankWrapper {
    void transferMoneyFromTo(String customerBankAccount, String merchantBankAccount, String amount) throws Exception;
}
