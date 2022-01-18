package group18.payment.adapters.payment;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class PaymentPayload {
    String requestId, merchantId, token, merchantBankAccountId, customerBankAccount, amount;
}
