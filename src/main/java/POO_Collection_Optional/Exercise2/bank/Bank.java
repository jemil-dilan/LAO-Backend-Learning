package POO_Collection_Optional.Exercise2.bank;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bank {

    private LinkedHashSet<BankAccount> bankAccounts;
    private Set<Customer> customers;

    public Bank(LinkedHashSet<BankAccount> bankAccounts, Set<Customer> customers) {

        this.bankAccounts = bankAccounts;
        this.customers = customers;
    }

    public void addNewCustomer(Customer owner){

        bankAccounts.add(new BankAccount(bankAccounts.getLast().getAccountNumber() + 1, owner, 0));
        customers.add(owner);
    }

    public void removeCustomer(Customer customer){

        bankAccounts.removeAll(customer.getAccounts());
        customers.remove(customer);
    }
}
