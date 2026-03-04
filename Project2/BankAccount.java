public abstract class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // Getters
    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Setter for balance (protected for child classes)
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Abstract withdraw method
    public abstract void withdraw(double amount);

    // Display details
    public void displayDetails() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Name: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
        System.out.println("---------------------------");
    }
}