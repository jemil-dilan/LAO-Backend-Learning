package POO_Collection_Optional.Exercise2.bank;


import java.util.HashSet;
import java.util.Set;

public class Customer {

    private String name;
    private int idNumber;
    private Set<BankAccount> accounts;

    public Customer(String name, int idNumber, Set<BankAccount> accounts) {
        this.name = name;
        this.idNumber = idNumber;
        this.accounts = new HashSet<BankAccount>(accounts);
    }

    public Set<BankAccount> getAccounts() {
        return accounts;
    }
}
