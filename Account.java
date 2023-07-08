package ATM;

import java.util.ArrayList;
import java.util.List;

public class Account 
{
    private String userId;
    private String userPin;
    private double balance;
    private List<Transaction> transactionHistory;

    public Account(String userId, String userPin) 
    {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() 
    {
        return userId;
    }

    public boolean verifyPin(String pin) 
    {
        return userPin.equals(pin);
    }

    public double getBalance() 
    {
        return balance;
    }

    public void deposit(double amount) 
    {
        balance += amount;
        Transaction depositTransaction = new Transaction("Deposit", amount);
        transactionHistory.add(depositTransaction);
        System.out.println("Deposit successful. Amount: " + amount);
    }

    public void withdraw(double amount) 
    {
        if (balance >= amount) 
        {
            balance -= amount;
            Transaction withdrawalTransaction = new Transaction("Withdrawal", amount);
            transactionHistory.add(withdrawalTransaction);
            System.out.println("Withdrawal successful. Amount: " + amount);
        } 
        else 
        {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    public void transfer(double amount, Account recipientAccount) 
    {
        if (balance >= amount) 
        {
            balance -= amount;
            recipientAccount.deposit(amount);
            Transaction transferTransaction = new Transaction("Transfer", amount);
            transactionHistory.add(transferTransaction);
            System.out.println("Transfer successful. Amount: " + amount);
        } 
        else 
        {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    public void displayTransactionHistory() 
    {
        System.out.println("\nTransaction History:");
        for (Transaction transaction : transactionHistory) 
        {
            System.out.println("Type: " + transaction.getType() + ", Amount: " + transaction.getAmount());
        }
    }
}
