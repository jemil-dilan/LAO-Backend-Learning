package POO_Collection_Optional.Exercise2.bank;

public class BankAccount {

    private int accountNumber;
    private Customer owner;
    private int balance;

    public BankAccount(int accountNumber, Customer owner, int balance) {

        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = Math.max(0, balance);
    }

    public void deposit(int amount){

        setBalance(this.balance + amount);
    }

    public void withdraw(int amount){

        if (this.balance >= amount){

            setBalance(this.balance - amount);
        } else {
            System.out.println("The balance is insuffisant");
        }
    }

    public int getBalance(){

        return this.balance;
    }

    public void setBalance(int balance){

        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void transfer(int amount, BankAccount destinationAccount){

        this.withdraw(amount);
        destinationAccount.deposit(amount);
    }
}
