package group18.domain;


import group18.domain.model.Payment;
import group18.domain.model.Customer;
import group18.domain.model.Merchant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class InMemoryStorage {

    private static List<Payment> payments = new ArrayList<Payment>();

    private static Map<String, Customer> customers = new HashMap<>(); // key -> token (or list of tokens?), value -> customer
    private static Map<String, Merchant> merchants = new HashMap<>(); // key -> merchantId, value -> merchant

    private static InMemoryStorage instance;
    // Test
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

    private InMemoryStorage() {}

    public static InMemoryStorage instance() {
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

    public void addCustomerToStorage(String token, Customer c) {
        customers.put(token, c);
    }

    public void addMerchantToStorage(Merchant m) {
        merchants.put(m.getMerchantId(), m);
    }

    public Customer getCustomer(String token) {
        return customers.get(token);
    }

    public Merchant getMerchant(String merchantId){
       return merchants.get(merchantId);
    }

}


