public class CurrentAccount extends BankAccount {

    private static final double OVERDRAFT_LIMIT = 5000;

    public CurrentAccount(int accountNumber, String name, double balance) {
        super(accountNumber, name, balance);
    }

    @Override
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return;
        }

        if (getBalance() - amount >= -OVERDRAFT_LIMIT) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Overdraft limit exceeded! Max ₹5000 allowed.");
        }
    }
}