package group18.payment.adapters.payment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPayload {
    String requestId, merchantId, token, merchantBankAccountId, customerBankAccountId, amount;
}
