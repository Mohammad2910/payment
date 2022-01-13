package group18.businesslogic;

import group18.model.Merchant;
import group18.model.Payment;
import group18.model.Customer;

public class PaymentRegistration {

    private final InMemoryStorage inMemoryStorage = InMemoryStorage.instance();
    private final BankWrapper dtuBank;

    public PaymentRegistration(BankWrapper dtuBank) {
        this.dtuBank = dtuBank;
    }

    /**
     * @param payment
     * @return
     */
    public Payment createPayment(Payment payment) {

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
            dtuBank.transferMoneyFromTo(customerBankAccountId, merchantBankAccountId, payment.getAmount());

            // Add payment
            inMemoryStorage.addPaymentToStorage(payment);
        } catch (Exception e) {
            // TODO: propagate error to user
            System.out.println("createPayment failed");
            System.out.println(e.getMessage());
        }

        return payment;
    }
}


