package POO_Collection_Optional.Exercise5.portfolio;

import POO_Collection_Optional.Exercise2.bank.BankAccount;

public class User {

    private String name;
    private BankAccount userAccount;
    private Portfolio portfolio ;

    public User(String name, BankAccount userAccount, Portfolio portfolio) {
        this.name = name;
        this.userAccount = userAccount;
        this.portfolio = portfolio;
    }
}
