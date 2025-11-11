package POO_Collection_Optional.Exercise6.bankOptionalOwner;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Bank {

    private Set<BankAccount> bankAccounts;
    private Set<Customer> customers;

    public Bank(Set<BankAccount> bankAccounts, Set<Customer> customers) {
        this.bankAccounts = bankAccounts;
        this.customers = customers;
    }

    public void makeDeposit(BankAccount bankAccount, int amount){
        bankAccounts.stream().filter(bankAccount1 ->  Objects.equals(bankAccount1,bankAccount)).forEach(bankAccount1 -> bankAccount1.deposit(amount));
    }

    public void makeWithdraw(BankAccount bankAccount, int amount){
        bankAccounts.stream().filter(bankAccount1 ->  Objects.equals(bankAccount1,bankAccount)).forEach(bankAccount1 -> bankAccount1.withdraw(amount));
    }

    public void makeTransfer(BankAccount bankAccount, BankAccount destinationAccount, int amount){
        bankAccounts.stream().filter(bankAccount1 ->  Objects.equals(bankAccount1,bankAccount)).forEach(bankAccount1 -> bankAccount1.transfer(amount,destinationAccount));
    }

    public Optional<Customer> findCustomerByAccountNumber(int accountNumber){

        return bankAccounts.stream()
                .filter(bankAccount ->  Objects.equals(bankAccount.getAccountNumber(), accountNumber))
                .map(BankAccount::getOwner)
                .filter(customer ->  customers.contains(customer))
                .findFirst();
    }
}
