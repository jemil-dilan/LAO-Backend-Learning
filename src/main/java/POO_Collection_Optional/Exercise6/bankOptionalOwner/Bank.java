package POO_Collection_Optional.Exercise6.bankOptionalOwner;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
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

        customer.getAccounts().forEach(bankAccounts::remove);
        customers.remove(customer);
    }

    public Optional<Customer> findCustomerByAccountNumber(int accountNumber){

        return bankAccounts.stream()
                .filter(bankAccount ->  Objects.equals(bankAccount.getAccountNumber(), accountNumber))
                .map(BankAccount::getOwner)
                .filter(customer ->  customers.contains(customer))
                .findFirst();
    }
}
