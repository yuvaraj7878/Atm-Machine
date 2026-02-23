import java.util.*;

class BankAccount {
    private int accountNumber;
    private int pin;
    private double balance;

    public BankAccount(int accountNumber, int pin, double balance) {
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    public void withdraw(double amount) {
        if(amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}

class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {

        System.out.print("Enter Account Number: ");
        int acc = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        if(acc == account.getAccountNumber() && account.validatePin(pin)) {

            int choice;
            do {
                System.out.println("\n===== ATM MENU =====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");
                choice = sc.nextInt();

                switch(choice) {

                    case 1:
                        System.out.println("Balance: ₹" + account.getBalance());
                        break;

                    case 2:
                        System.out.print("Enter deposit amount: ");
                        double dep = sc.nextDouble();
                        account.deposit(dep);
                        break;

                    case 3:
                        System.out.print("Enter withdraw amount: ");
                        double wd = sc.nextDouble();
                        account.withdraw(wd);
                        break;

                    case 4:
                        System.out.println("Thank you for using ATM.");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            } while(choice != 4);

        } else {
            System.out.println("Invalid account or PIN.");
        }
    }
}

public class AtmMachine {

    public static void main(String[] args) {

        BankAccount user = new BankAccount(12345, 1111, 5000);
        ATM atm = new ATM(user);
        atm.start();
    }
}