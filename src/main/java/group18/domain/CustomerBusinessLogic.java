package group18.domain;

import group18.adapters.CustomerDataAccess;
import group18.domain.model.Customer;
import group18.domain.ports.ICustomerDataAccess;

public class CustomerBusinessLogic {
    ICustomerDataAccess _custDataAccess;

    public CustomerBusinessLogic(){
        _custDataAccess = new CustomerDataAccess();
    }
    public Customer getCustomerName(String customerId, String bankAccountId, String name){
        return _custDataAccess.getCustomerId(customerId,bankAccountId,name);
    }
}
