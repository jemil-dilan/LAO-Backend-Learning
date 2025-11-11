package POO_Collection_Optional.Exercise6.bankOptionalOwner;

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

    public int getAccountNumber() {
        return accountNumber;
    }

    public Customer getOwner() {
        return owner;
    }

    public void setBalance(int balance){

        this.balance = balance;
    }

    public void transfer(int amount, BankAccount destinationAccount){

        this.withdraw(amount);
        destinationAccount.deposit(amount);
    }
}
