package group18.payment.domain;

import group18.payment.adapters.bankTransfer.BankTransferService;
import group18.payment.domain.cache.PaymentsCache;
import group18.payment.domain.model.Payment;

import java.math.BigDecimal;

public class PaymentService {

    private final PaymentsCache cache;
    private final BankTransferService bank;

    public PaymentService(PaymentsCache cache, BankTransferService bank) {
        this.cache = cache;
        this.bank = bank;
    }

    /**
     * @param p
     */
    public void transferMoney(Payment p) throws Exception {
        // Transfer money
        BigDecimal amountBD = p.getAmount() != null ? new BigDecimal(p.getAmount()) : null;
        if (amountBD != null && amountBD.intValue() <= 0) {
            throw new IllegalArgumentException("amount can not be negative or null");
        }
        bank.transferMoneyFromTo(p.getMerchantBankAccount(), p.getCustomerBankAccount(), amountBD);
        cache.addPayment(p);
    }



}


