package group18.businesslogic;

import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;

import java.math.BigDecimal;

public class BankWrapper {

    private final BankService bank;

    // TODO: Replace class object to the interface
    public BankWrapper(BankServiceService bankService) {
        this.bank = bankService.getBankServicePort();
    }

    /**
     * Tranfer money from deptor to creditor
     *
     * @param customerBankAccount
     * @param merchantBankAccount
     * @param amount
     */
    public void transferMoneyFromTo(String customerBankAccount, String merchantBankAccount, String amount) throws Exception {
        BigDecimal castedAmount = new BigDecimal(amount);
        try {
            bank.transferMoneyFromTo(customerBankAccount, merchantBankAccount, castedAmount, "Payment Description.");
        } catch (BankServiceException_Exception e) {
            // TODO: Throe custom error
            throw new Exception(e.getMessage());
        }
    }
}
