package POO_Collection_Optional.Exercise2.bank;


import java.util.HashSet;
import java.util.Set;

public class Customer {

    private String name;
    private int idNumber;
    private Set<BankAccount> accounts;

    public Customer(String name, int idNumber) {
        this.name = name;
        this.idNumber = idNumber;
        this.accounts = new HashSet<BankAccount>();
    }

    public void setAccounts(Set<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public Set<BankAccount> getAccounts() {
        return accounts;
    }

    public void addAccount (BankAccount bankAccount){

        accounts.add(bankAccount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", idNumber=" + idNumber +
                "}";
    }
}
