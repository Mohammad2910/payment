package group18.adapters;

import dtu.ws.fastmoney.BankService;
import dtu.ws.fastmoney.BankServiceException_Exception;
import dtu.ws.fastmoney.BankServiceService;
import group18.domain.ports.IBankWrapper;

import java.math.BigDecimal;

public class BankWrapper implements IBankWrapper {

    private final BankService bank;

    // TODO: Replace class object to the interface
    public BankWrapper(BankServiceService bankService) {
        this.bank = bankService.getBankServicePort();
    }

    /**
     * Transfer money from debitor to creditor
     *
     * @param customerBankAccount
     * @param merchantBankAccount
     * @param amount
     */

    @Override
    public void transferMoneyFromTo(String customerBankAccount, String merchantBankAccount, String amount) throws Exception {
        BigDecimal castedAmount = new BigDecimal(amount);
        try {
            bank.transferMoneyFromTo(customerBankAccount, merchantBankAccount, castedAmount, "Payment Description.");
        } catch (TransferFailedException e) {
            throw new TransferFailedException("Transfer from " + customerBankAccount + " to " + merchantBankAccount + " failed!" , e.getCause(), e.getFaultInfo());
        }
    }
}
