package POO_Collection_Optional.Exercise2.bank;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test {

    static void main(String[] args) {

        Customer customer1 = new Customer("Leonel Messi", 4);
        Customer customer2 = new Customer("John Doe", 9);
        Customer customer3 = new Customer("Janny Doe", 7);

        Set<Customer> customers = new HashSet<Customer>();
        customers.add(customer1);
        customers.add(customer2);

        BankAccount bankAccount1 = new BankAccount(1 , customer1,2000);
        BankAccount bankAccount2 = new BankAccount(2 , customer1,54000);
        BankAccount bankAccount3 = new BankAccount(5 , customer2,900);

        Set<BankAccount> bankAccounts = new LinkedHashSet<BankAccount>();
        bankAccounts.add(bankAccount1);
        bankAccounts.add(bankAccount2);
        bankAccounts.add(bankAccount3);


        Bank ubaBank = new Bank(bankAccounts, customers);
        ubaBank.listAllBankAccounts();
        System.out.println("\t\t------------------------------------");
        ubaBank.listAllCustomers();

        bankAccount2.transfer(4500, bankAccount1);
        bankAccount3.deposit(2800);
        bankAccount1.withdraw(6000);

        System.out.println("\nAfter Transactions\n".toUpperCase());

        ubaBank.listAllBankAccounts();
        System.out.println("\t\t------------------------------------");
        ubaBank.listAllCustomers();

        System.out.println("\nUser creation and deletion\n".toUpperCase());

        ubaBank.addNewCustomer(customer3);
        ubaBank.removeCustomer(customer2);

        ubaBank.listAllBankAccounts();
        System.out.println("\t\t------------------------------------");
        ubaBank.listAllCustomers();
    }
}
