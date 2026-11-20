import java.util.ArrayList;

public class Bank {
    // Properties
    private String _bankName;
    private ArrayList<Account> _accounts = new ArrayList<Account>();

    // Constructor
    public Bank(String bankName) {
        _bankName = bankName;
    }

    // ---------- Account management ----------
    public void addAccount(Account account) {
        if (account == null) {
            System.out.println("Cannot add an empty account");
            return;
        }
        _accounts.add(account);
        System.out.println("Account #" + account.getAccountNumber() + " (" + account.getAccountName() + ") added successfully");
    }

    public Account findById(int id) {
        for (Account acc : _accounts) {
            if (acc.getAccountNumber() == id) {
                return acc;
            }
        }
        return null;
    }

    // ---------- Display methods ----------
    public void displayAllAccounts() {
        if (_accounts.isEmpty()) {
            System.out.println("No accounts found");
            return;
        }
        for (Account acc : _accounts) {
            acc.displayInfo();
            printLine();
        }
    }

    public void displaySavingAccounts() {
        boolean found = false;
        for (Account acc : _accounts) {
            if (acc instanceof SavingAccount) {
                acc.displayInfo();
                printLine();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No saving accounts found");
        }
    }

    public void displayCheckingAccounts() {
        boolean found = false;
        for (Account acc : _accounts) {
            if (acc instanceof CheckingAccount) {
                acc.displayInfo();
                printLine();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No checking accounts found");
        }
    }

    public void displayAccountById(int id) {
        Account acc = findById(id);
        if (acc == null) {
            System.out.println("Account #" + id + " not found");
            return;
        }
        acc.displayInfo();
        printLine();
    }

    // ---------- Transactions by id ----------
    public void depositById(int id, double amount) {
        Account acc = findById(id);
        if (acc == null) {
            System.out.println("Account #" + id + " not found");
            return;
        }
        acc.deposit(amount);
    }

    public void withdrawById(int id, double amount) {
        Account acc = findById(id);
        if (acc == null) {
            System.out.println("Account #" + id + " not found");
            return;
        }
        acc.withDraw(amount);
    }

    public void transfer(int fromId, int toId, double amount) {
        Account from = findById(fromId);
        Account to = findById(toId);

        if (from == null || to == null) {
            System.out.println("Transfer failed: one of the accounts was not found");
            return;
        }
        if (fromId == toId) {
            System.out.println("Transfer failed: cannot transfer to the same account");
            return;
        }
        if (amount <= 0) {
            System.out.println("Transfer failed: invalid amount");
            return;
        }

        double before = from.getBalance();
        from.withDraw(amount);

        // If the balance did not change, the withdraw was rejected
        if (from.getBalance() == before) {
            System.out.println("Transfer failed");
            return;
        }

        to.deposit(amount);
        System.out.println("Transfer completed: " + amount + " from #" + fromId + " to #" + toId);
    }

    public double getInterestById(int id) {
        Account acc = findById(id);
        if (acc == null) {
            System.out.println("Account #" + id + " not found");
            return 0.0;
        }
        return acc.calculateInterest();
    }

    // ---------- Statistics ----------
    public double getTotalBalance() {
        double total = 0;
        for (Account acc : _accounts) {
            total += acc.getBalance();
        }
        return total;
    }

    public double getTotalInterest() {
        double total = 0;
        for (Account acc : _accounts) {
            total += acc.calculateInterest();
        }
        return total;
    }

    public void displayBankSummary() {
        int savingCount = 0;
        int checkingCount = 0;
        for (Account acc : _accounts) {
            if (acc instanceof SavingAccount) savingCount++;
            else if (acc instanceof CheckingAccount) checkingCount++;
        }
        System.out.println("Bank Name          : " + _bankName);
        System.out.println("Total Accounts     : " + _accounts.size());
        System.out.println("Saving Accounts    : " + savingCount);
        System.out.println("Checking Accounts  : " + checkingCount);
        System.out.println("Total Balance      : " + getTotalBalance());
        System.out.println("Total Interest     : " + getTotalInterest());
    }

    public String getBankName() {
        return _bankName;
    }

    private void printLine() {
        System.out.println("------------------------------");
    }
}