public class SavingsAccount extends BankAccount {

    private static final double MIN_BALANCE = 1000;

    public SavingsAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (getBalance() - amount >= MIN_BALANCE) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Cannot withdraw. Minimum balance ₹1000 required.");
        }
    }
}