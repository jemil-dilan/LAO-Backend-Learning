package POO_Collection_Optional.Exercise5.portfolio;

import POO_Collection_Optional.Exercise2.bank.BankAccount;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String name;
    private BankAccount userAccount;
    private List<Portfolio> accounts = new ArrayList<Portfolio>();

    public User(String name, BankAccount userAccount, List<Portfolio> accounts) {
        this.name = name;
        this.userAccount = userAccount;
        this.accounts = accounts;
    }
}
