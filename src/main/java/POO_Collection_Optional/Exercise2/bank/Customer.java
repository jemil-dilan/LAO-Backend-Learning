package POO_Collection_Optional.Exercise2.bank;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private int idNumber;
    private List<BankAccount> accounts = new ArrayList<BankAccount>();

    public Customer(String name, int idNumber, List<BankAccount> accounts) {
        this.name = name;
        this.idNumber = idNumber;
        this.accounts = accounts;
    }
}
