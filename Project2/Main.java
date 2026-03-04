import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService service = new BankService();

        int choice;

        while (true) {

            System.out.println("===== Welcome to Web Plus Bank =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View All Accounts");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    System.out.println("Select Account Type:");
                    System.out.println("1. Savings");
                    System.out.println("2. Current");
                    int type = sc.nextInt();

                    service.createAccount(name, balance, type);
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double depAmount = sc.nextDouble();

                    service.depositMoney(depAcc, depAmount);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double withAmount = sc.nextDouble();

                    service.withdrawMoney(withAcc, withAmount);
                    break;

                case 4:
                    System.out.print("Enter From Account Number: ");
                    int fromAcc = sc.nextInt();

                    System.out.print("Enter To Account Number: ");
                    int toAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double transferAmount = sc.nextDouble();

                    service.transferMoney(fromAcc, toAcc, transferAmount);
                    break;

                case 5:
                    service.displayAllAccounts();
                    break;

                case 6:
                    System.out.println("Thank you for banking with us!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}