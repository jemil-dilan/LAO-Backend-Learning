package POO_Collection_Optional.Exercise6.bankOptionalOwner;

import java.util.LinkedList;
import java.util.List;

public class Customer {

    private String name;
    private int idNumber;
    private List<BankAccount> accounts;

    public Customer(String name, int idNumber, List<BankAccount> accounts) {
        this.name = name;
        this.idNumber = idNumber;
        this.accounts = new LinkedList<>(accounts) ;
    }

    public void addAccount(BankAccount account){

        accounts.add(account);
    }

    public void removeAccount (BankAccount account){

        accounts.remove(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}
