
// Task 3: ATM Interface
import java.util.Scanner;

class BankAccount {
    private int balance;

    public BankAccount(int initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            this.balance = 0;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public int checkBalance() {
        return balance;
    }
}

public class ATM {
    private BankAccount account;
    private Scanner sc = new Scanner(System.in);

    public ATM(BankAccount account) {
        this.account = account;
    }

    public void start() {
        while (true) {
            System.out.println("\n--- ATM INTERFACE ---");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.print("Enter withdraw amount: ");
                    int withdrawAmt = sc.nextInt();
                    if (account.withdraw(withdrawAmt)) {
                        System.out.println("Successfully withdrawn: " + withdrawAmt);
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;

                case 2:
                    System.out.print("Enter deposit amount: ");
                    int depositAmt = sc.nextInt();
                    if (account.deposit(depositAmt)) {
                        System.out.println("Successfully deposited: " + depositAmt);
                    } else {
                        System.out.println("Invalid amount.");
                    }
                    break;

                case 3:
                    System.out.println("Your balance: " + account.checkBalance());
                    break;

                case 4:
                    System.out.println("Thank you for using the ATM!");
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(100000);
        ATM atm = new ATM(userAccount);
        atm.start();
    }
}
