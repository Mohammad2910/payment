package group18.domain;

import group18.domain.model.Merchant;
import group18.domain.model.Payment;
import group18.domain.model.Customer;
import group18.domain.ports.IBankWrapper;

public class PaymentRegistration {

    private final InMemoryStorage inMemoryStorage = InMemoryStorage.instance();
    //private final BankWrapper dtuBank;
    private final IBankWrapper bankWrapper;

    public PaymentRegistration(IBankWrapper bankWrapper) {
        this.bankWrapper = bankWrapper;
    }

    /**
     * @param payment
     * @return
     */
    public void createPayment(Payment payment) {

        // TODO different cases to create a payment
        /*
         FIXME add checks:
            - Check merchantId
            - Check token
            - Check amount
         */

        Customer customer = inMemoryStorage.getCustomer(payment.getToken());
        Merchant merchant = inMemoryStorage.getMerchant(payment.getMerchantId());

        String customerBankAccountId = customer != null ? customer.getBankAccountId() : null;
        String merchantBankAccountId = merchant != null ? merchant.getBankAccountId() : null;

        if(customerBankAccountId == null) throw new IllegalArgumentException("customer not found");
        if(merchantBankAccountId == null) throw new IllegalArgumentException("merchant not found");

        if(payment.getAmount() != null && Integer.parseInt(payment.getAmount()) <= 0) throw new IllegalArgumentException("amount is not correct");

        //TODO here check if token is valid

        try {
            // Transfer money
            bankWrapper.transferMoneyFromTo(customerBankAccountId, merchantBankAccountId, payment.getAmount());

            // Add payment
            inMemoryStorage.addPaymentToStorage(payment);
        } catch (Exception e) {
            // TODO: propagate error to user
            System.out.println("createPayment failed");
            System.out.println(e.getMessage());
        }
    }
}


