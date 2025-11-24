package POO_Collection_Optional.Exercise6.bankOptionalOwner;

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
        ubaBank.addNewCustomer(customer3);

        ubaBank.listAllBankAccounts();
        System.out.println("\t\t------------------------------------");
        ubaBank.listAllCustomers();
        System.out.println("\t\t------------------------------------");

//        customer1.addAccount(bankAccount1);
//        customer1.addAccount(bankAccount2);
//        ubaBank.removeCustomer(customer1);
//
//        ubaBank.listAllBankAccounts();
//        System.out.println("\t\t------------------------------------");
//        ubaBank.listAllCustomers();
//        System.out.println("\t\t------------------------------------");

        System.out.println("\t\tUser Search".toUpperCase());
        System.out.println(ubaBank.findCustomerByAccountNumber(2));

    }
}
