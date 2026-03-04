import java.util.ArrayList;

public class BankService {

    private ArrayList<BankAccount> accounts = new ArrayList<>();
    private int accountCounter = 1001;

    public void createAccount(String name, double balance, int type) {

        BankAccount account;

        if (type == 1) {
            account = new SavingsAccount(accountCounter++, name, balance);
        } else {
            account = new CurrentAccount(accountCounter++, name, balance);
        }

        accounts.add(account);
        System.out.println("Account created successfully!");
        System.out.println("Your Account Number is: " + account.getAccountNumber());
    }

    private BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    public void depositMoney(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdrawMoney(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transferMoney(int fromAcc, int toAcc, double amount) {

        BankAccount sender = findAccount(fromAcc);
        BankAccount receiver = findAccount(toAcc);

        if (sender != null && receiver != null) {

            double initialBalance = sender.getBalance();
            sender.withdraw(amount);

            if (sender.getBalance() != initialBalance) {
                receiver.deposit(amount);
                System.out.println("Transfer successful!");
            }

        } else {
            System.out.println("Invalid account number(s).");
        }
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }

        for (BankAccount acc : accounts) {
            acc.displayDetails();
        }
    }
}