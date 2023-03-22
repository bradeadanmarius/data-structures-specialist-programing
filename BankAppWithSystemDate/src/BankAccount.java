import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class BankAccount {
    // Field to store the account number
    private String accountNumber;
    // Field to store the account holder's name
    private String accountHolderName;
    // Field to store the account holder's address
    private String accountHolderAddress;
    // Field to store the account creation date
    private Date creationDate;
    // Field to store the current balance of the account
    private double currentBalance;
    // Field to store a list of transactions for the account
    private List<Transaction> transactions;

    // Constructor to create a new BankAccount object
    public BankAccount(String accountNumber, String accountHolderName, String accountHolderAddress, double currentBalance) {
        // Initialize the account number field
        this.accountNumber = accountNumber;
        // Initialize the account holder name field
        this.accountHolderName = accountHolderName;
        // Initialize the account holder address field
        this.accountHolderAddress = accountHolderAddress;
        // Initialize the creation date field with the current system date
        this.creationDate = new Date();
        // Initialize the current balance field
        this.currentBalance = currentBalance;
        // Initialize the transactions field with a new empty ArrayList
        this.transactions = new ArrayList<>();
    }

    // Getter method for the account number field
    public String getAccountNumber() {
        return accountNumber;
    }

    // Setter method for the account number field
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // Getter method for the account holder name field
    public String getAccountHolderName() {
        return accountHolderName;
    }

    // Setter method for the account holder name field
    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    // Getter method for the account holder address field
    public String getAccountHolderAddress() {
        return accountHolderAddress;
    }

    // Setter method for the account holder address field
    public void setAccountHolderAddress(String accountHolderAddress) {
        this.accountHolderAddress = accountHolderAddress;
    }

    // Getter method for the creation date field
    public Date getCreationDate() {
        return creationDate;
    }

    // Setter method for the creation date field
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // Getter method for the current balance field
    public double getCurrentBalance() {
        return currentBalance;
    }

    // Setter method for the current balance field
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    // Getter method for the transactions field
    public List<Transaction> getTransactions() {
        return transactions;
    }

    // Setter method for the transactions field
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    // Method to add a new Transaction object to the transactions list
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
}


   
