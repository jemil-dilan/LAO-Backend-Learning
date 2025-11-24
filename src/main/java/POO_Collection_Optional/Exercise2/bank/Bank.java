package POO_Collection_Optional.Exercise2.bank;

import java.util.LinkedHashSet;
import java.util.Set;

public class Bank {

    private LinkedHashSet<BankAccount> bankAccounts;
    private Set<Customer> customers;

    public Bank(Set<BankAccount> bankAccounts, Set<Customer> customers) {

        this.bankAccounts = new LinkedHashSet<BankAccount>(bankAccounts);
        this.customers = customers;
    }

    public void addNewCustomer(Customer owner){

        BankAccount bankAccount = new BankAccount(bankAccounts.getLast().getAccountNumber() + 1, owner,0);
        bankAccounts.add(bankAccount);

        owner.addAccount(bankAccount);
        customers.add(owner);
    }

    public void removeCustomer(Customer customer){

        bankAccounts.removeAll(customer.getAccounts());
        customers.remove(customer);
    }

    public void listAllBankAccounts(){

        System.out.println("List Of bank accounts");
        bankAccounts.forEach(System.out::println);
    }

    public void listAllCustomers(){

        System.out.println("List of bank customers");
        customers.forEach(System.out::println);
    }
}
