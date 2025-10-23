package banque;

public class Test {

    public static void main(String[] args) {
        
        BankAccount account1 = new BankAccount(0, "Adon", 5000);
        BankAccount account2 = new BankAccount(45, "Tolle", 4700);
        
        account1.setBalance(2000);
        account2.setBalance(2000);
        account1.transfer(500, account2);
        System.out.println("new account2 balance: " + account2.getBalance());
    }
}
