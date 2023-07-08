package ATM;

import java.util.Scanner;

public class Atm_Process 
{
	public static void main(String[] args) 
	{
        Scanner sc = new Scanner(System.in);

        // Create an account
        Account account = new Account("user123", "1234");

        // Prompt user for user id and pin
        System.out.println("Welcome to the ATM System!");
        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = sc.nextLine();

        // Verify user id and pin
        if (userId.equals(account.getUserId()) && account.verifyPin(userPin)) 
        {
            System.out.println("User ID and PIN verified. ATM functionalities unlocked.");
            boolean quit = false;

            while (!quit) 
            {
                System.out.println("\nATM Menu:");
                System.out.println("1. View Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume the remaining newline character

                switch (choice) 
                {
                    case 1:
                        account.displayTransactionHistory();
                        break;
                    case 2:
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = sc.nextDouble();
                        sc.nextLine(); // Consume the remaining newline character
                        account.withdraw(withdrawalAmount);
                        break;
                    case 3:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = sc.nextDouble();
                        sc.nextLine(); // Consume the remaining newline character
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter transfer amount: ");
                        double transferAmount = sc.nextDouble();
                        sc.nextLine(); // Consume the remaining newline character
                        System.out.print("Enter recipient User ID: ");
                        String recipientUserId = sc.nextLine();
                        // In a real scenario, you would typically validate the recipient user ID and account
                        Account recipientAccount = new Account(recipientUserId, ""); // Empty PIN for demo purposes
                        account.transfer(transferAmount, recipientAccount);
                        break;
                    case 5:
                        quit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } 
        else 
        {
            System.out.println("Invalid User ID or PIN. ATM functionalities locked.");
        }

        sc.close();
    }
}
