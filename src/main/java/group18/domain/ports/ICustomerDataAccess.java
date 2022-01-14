package group18.domain.ports;

import group18.domain.model.Customer;

public interface ICustomerDataAccess {
    Customer getCustomerId(String customerId,
                           String bankAccountId,
                           String name);
}
