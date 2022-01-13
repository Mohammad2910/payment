package group18.businesslogic;


import group18.model.Payment;
import group18.model.Customer;
import group18.model.Merchant;

import java.util.List;
import java.util.Map;


public class InMemoryStorage {

    private static List<Payment> payments;
    private static Map<String, Customer> customers; // key -> token, value -> customer
    /*
        Map<ArrayList<String>, Customer> customers = new HasMap<String, Customer>
        ArrayList<String> tokenList = new ArrayList<String>();
        getGeneratedTokens()
        for (int i = 0; i <
        tokenList.add("token1");
        tokenList.add("token2");
        tokenList.add("token3");
        tokenList.add("token4");

        customers.put(tokenList, customer );
     */
    private static Map<String, Merchant> merchants; // key -> merchantId, value -> merchant
    private static InMemoryStorage instance;

    private InMemoryStorage() {}

    public InMemoryStorage instance() {
        if(instance == null) {
            instance = new InMemoryStorage();
            return instance;
        }
        return instance;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void addPaymentToStorage(Payment p) {
        payments.add(p);
    }

    public Customer getCustomer(String token) {
        return customers.get(token);
    }

    public Merchant getMerchant(String merchantId){
       return merchants.get(merchantId);
    }

}


