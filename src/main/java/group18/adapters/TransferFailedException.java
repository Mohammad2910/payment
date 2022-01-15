package group18.adapters;

import dtu.ws.fastmoney.BankServiceException;
import dtu.ws.fastmoney.BankServiceException_Exception;

public class TransferFailedException extends BankServiceException_Exception {
    public TransferFailedException(String message, Throwable cause, BankServiceException faultInfo){super(message, faultInfo , cause);}
}
