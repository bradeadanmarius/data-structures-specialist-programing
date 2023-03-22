import java.util.Date;

public class Transaction {

    // Property for transaction date
    private Date transactionDate;

    // Property for transaction type
    private String transactionType;

    // Property for transaction amount
    private double transactionAmount;

    // Constructor to initialize properties when creating a new Transaction object
    public Transaction(String transactionType, double transactionAmount) {
        this.transactionDate = new Date(); // Set the transaction date to the current system date
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
    }

    // Getter method for transaction date
    public Date getTransactionDate() {
        return transactionDate;
    }

    // Setter method for transaction date
    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    // Getter method for transaction type
    public String getTransactionType() {
        return transactionType;
    }

    // Setter method for transaction type
    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    // Getter method for transaction amount
    public double getTransactionAmount() {
        return transactionAmount;
    }

    // Setter method for transaction amount
    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }
}


