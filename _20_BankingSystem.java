import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount) throws InsufficientFundsException;
    void transfer(BankingAccount toAccount, double amount) throws InsufficientFundsException;
    double getBalance();
    List<String> getTransactions();
}
class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}


class SavingsAccount implements BankingAccount {
    private double balance;
    private List<String> transactions;

    public SavingsAccount() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
            transactions.add("Withdrew: $" + amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public void transfer(BankingAccount toAccount, double amount) throws InsufficientFundsException {
        this.withdraw(amount);
        toAccount.deposit(amount);
        transactions.add("Transferred: $" + amount + " to " + toAccount.getClass().getSimpleName());
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<String> getTransactions() {
        return transactions;
    }
}

class CheckingAccount implements BankingAccount {
    private double balance;
    private List<String> transactions;

    public CheckingAccount() {
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: $" + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance >= amount) {
            balance -= amount;
            transactions.add("Withdrew: $" + amount);
        } else {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
    }

    @Override
    public void transfer(BankingAccount toAccount, double amount) throws InsufficientFundsException {
        this.withdraw(amount);
        toAccount.deposit(amount);
        transactions.add("Transferred: $" + amount + " to " + toAccount.getClass().getSimpleName());
    }

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public List<String> getTransactions() {
        return transactions;
    }
}


public class _20_BankingSystem {
    private static Map<Integer, BankingAccount> accounts = new HashMap<>();
    private static int nextAccountId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Checking Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. View Transactions");
            System.out.println("7. View Balance");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createAccount("Savings");
                    break;
                case 2:
                    createAccount("Checking");
                    break;
                case 3:
                    performDeposit();
                    break;
                case 4:
                    performWithdraw();
                    break;
                case 5:
                    performTransfer();
                    break;
                case 6:
                    viewTransactions();
                    break;
                case 7:
                    viewBalance();
                    break;
                case 8:
                    System.out.println("Exiting Banking System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount(String type) {
        BankingAccount account;
        if (type.equals("Savings")) {
            account = new SavingsAccount();
        } else {
            account = new CheckingAccount();
        }
        accounts.put(nextAccountId, account);
        System.out.println(type + " Account created with Account ID: " + nextAccountId);
        nextAccountId++;
    }

    private static void performDeposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account ID: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter deposit amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        BankingAccount account = accounts.get(accountId);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposited $" + amount + " to Account ID " + accountId);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performWithdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account ID: ");
        int accountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter withdrawal amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        BankingAccount account = accounts.get(accountId);
        if (account != null) {
            try {
                account.withdraw(amount);
                System.out.println("Withdrew $" + amount + " from Account ID " + accountId);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performTransfer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Source Account ID: ");
        int fromAccountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter Destination Account ID: ");
        int toAccountId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter transfer amount: ");
        double amount = Double.parseDouble(scanner.nextLine());

        BankingAccount fromAccount = accounts.get(fromAccountId);
        BankingAccount toAccount = accounts.get(toAccountId);
        if (fromAccount != null && toAccount != null) {
            try {
                fromAccount.transfer(toAccount, amount);
                System.out.println("Transferred $" + amount + " from Account ID " + fromAccountId + " to Account ID " + toAccountId);
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    private static void viewTransactions() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account ID: ");
        int accountId = Integer.parseInt(scanner.nextLine());

        BankingAccount account = accounts.get(accountId);
        if (account != null) {
            System.out.println("Transactions for Account ID " + accountId + ":");
            for (String transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Account ID: ");
        int accountId = Integer.parseInt(scanner.nextLine());

        BankingAccount account = accounts.get(accountId);
        if (account != null) {
            System.out.println("Balance for Account ID " + accountId + ": $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
        
    }
}
