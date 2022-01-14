package group18.adapters;

import group18.domain.model.Customer;
import group18.domain.ports.ICustomerDataAccess;

public class CustomerDataAccess implements ICustomerDataAccess {

    @Override
    public Customer getCustomerId(String customerId,
            String bankAccountId,
            String name) {
        return new Customer("c-id","c-bank","c-name");
    }
}
