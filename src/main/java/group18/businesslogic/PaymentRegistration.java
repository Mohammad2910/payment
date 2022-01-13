package group18.businesslogic;

import group18.model.Merchant;
import group18.model.Payment;
import group18.model.Customer;

public class PaymentRegistration {

    private final InMemoryStorage inMemoryStorage;
    private final BankService bankService;

    public PaymentRegistration(InMemoryStorage inMemoryStorage, BankService bankService) {
        this.inMemoryStorage = inMemoryStorage;
        this.bankService = bankService;
    }


    public Payment createPayment(Payment payment) {

        // TODO different cases to create a payment
        /*
         FIXME add checks:
            - Check merchantId
            - Check token
            - Check amount
         */

        // If above is correct then
        /*
        try {
            BankService dtuBank = new BankServiceService().getBankServicePort();
            // Bank service
            dtuBank.transferMoneyFromTo(c.getBankAccount(),m.getBankAccount(), BigDecimal.valueOf(Integer.parseInt(payment.getAmount())),"Transfer Money");
        } catch (BankServiceException_Exception e) {
            e.printStackTrace();
        }
         */
        Customer customer = inMemoryStorage.getCustomer(payment.getToken());
        Merchant merchant = inMemoryStorage.getMerchant(payment.getMerchantId());

        String customerBankAccountId = customer != null ? customer.getBankAccountId() : null;
        String merchantBankAccountId = merchant != null ? merchant.getBankAccountId() : null;

        if(customerBankAccountId == null) throw new IllegalArgumentException("customer not found");
        if(merchantBankAccountId == null) throw new IllegalArgumentException("merchant not found");

        if(payment.getAmount() != null && Integer.parseInt(payment.getAmount()) <= 0) throw new IllegalArgumentException("amount is not correct");

        //TODO here check if token is valid

        bankService.transferMoneyFromTo(customerBankAccountId, merchantBankAccountId, payment.getAmount());

        return payment;
    }



}


