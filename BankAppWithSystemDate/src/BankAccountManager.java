import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BankAccountManager {
    // List to store all the bank accounts
    private static List<BankAccount> accounts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // While loop to present a menu of options to the user
        while (true) {
            System.out.println("1. Create a new account");
            System.out.println("2. Display a list of existing accounts");
            System.out.println("3. Delete a closed account");
            System.out.println("4. Update the system with new transaction details");
            System.out.println("5. Display the last six transactions for an account");
            System.out.println("6. Quit");
            System.out.print("Enter a choice: ");
            int choice = scanner.nextInt();
            if (choice == 1) {
                createNewAccount(scanner);
            } else if (choice == 2) {
                displayAccounts();
            } else if (choice == 3) {
                deleteAccount(scanner);
            } else if (choice == 4) {
                updateAccount(scanner);
            } else if (choice == 5) {
                displayTransactions(scanner);
            } else if (choice == 6) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }

    // Method to create a new bank account
    private static void createNewAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        System.out.print("Enter account holder name: ");
        String accountHolderName = scanner.next();
        scanner.nextLine(); // Consume newline left-over
        System.out.print("Enter account holder address: ");
        String accountHolderAddress = scanner.nextLine();
        System.out.print("Enter current balance: ");
        double currentBalance = scanner.nextDouble();
        BankAccount account = new BankAccount(accountNumber, accountHolderName, accountHolderAddress, currentBalance);
        accounts.add(account);
        System.out.println("Account created successfully.");
    }

    // Method to display a list of existing bank accounts
    private static void displayAccounts() {
        // Check if there are any accounts to display
        if (accounts.isEmpty()) {
            System.out.println("No accounts to display.");
            return;
        }
        // Iterate through each bank account and display its properties
        for (BankAccount account : accounts) {
            System.out.println("Account number: " + account.getAccountNumber());
            System.out.println("Account holder name: " + account.getAccountHolderName());
            System.out.println("Account holder address: " + account.getAccountHolderAddress());
            System.out.println("Creation date: " + account.getCreationDate());
            System.out.println("Current balance: " + account.getCurrentBalance());
        }
    }

    // Method to delete a bank account
    private static void deleteAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount accountToDelete = null;
        // Search for the account with the specified account number
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accountToDelete = account;
                break;
            }
        }
        // If the account is not found, display an error message
        if (accountToDelete == null) {
            System.out.println("Account not found.");
            return;
        }
        // Remove the account from the list of accounts
        accounts.remove(accountToDelete);
        System.out.println("Account deleted successfully.");
    }

    // Method to update a bank account with new transaction details
    private static void updateAccount(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount account = null;
        // Search for the account with the specified account number
        for (BankAccount a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) {
                account = a;
                break;
            }
        }
        // If the account is not found, display an error message
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        System.out.print("Enter transaction type (Debit/Credit): ");
        String transactionType = scanner.next();
        System.out.print("Enter transaction amount: ");
        double transactionAmount = scanner.nextDouble();
        // Create a new Transaction object with the specified properties
        Transaction transaction = new Transaction(transactionType, transactionAmount);
        account.addTransaction(transaction);
        if (transactionType.equalsIgnoreCase("debit")) {
            account.setCurrentBalance(account.getCurrentBalance() - transactionAmount);
        } else if (transactionType.equalsIgnoreCase("credit")) {
            account.setCurrentBalance(account.getCurrentBalance() + transactionAmount);
        } else {
            System.out.println("Invalid transaction type. Transaction not processed.");
            return;
        }
        System.out.println("Transaction processed successfully.");
    }

    // Method to display the last six transactions for a bank account
    private static void displayTransactions(Scanner scanner) {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        BankAccount account = null;
        // Search for the account with the specified account number
        for (BankAccount a : accounts) {
            if (a.getAccountNumber().equals(accountNumber)) {
                account = a;
                break;
            }
        }
        // If the account is not found, display an error message
        if (account == null) {
            System.out.println("Account not found.");
            return;
        }
        // Get the list of transactions for the account
        List<Transaction> transactions = account.getTransactions();
        // Check if there are any transactions to display
        if (transactions.isEmpty()) {
            System.out.println("No transactions to display.");
            return;
        }
        // Sort the transactions by transaction amount
        transactions.sort((t1, t2) -> {
            if (t1.getTransactionAmount() > t2.getTransactionAmount()) {
                return 1;
            } else if (t1.getTransactionAmount() < t2.getTransactionAmount()) {
                return -1;
            } else {
                return 0;
            }
        });
        int count = 0;
        // Display the last six transactions in ascending order of transaction amount
        for (int i = transactions.size() - 1; i >= 0; i--) {
            Transaction t = transactions.get(i);
            System.out.println("Transaction date: " + t.getTransactionDate());
            System.out.println("Transaction type: " + t.getTransactionType());
            System.out.println("Transaction amount: " + t.getTransactionAmount());
            count++;
            if (count == 6) {
                break;
            }
        }
    }
}
