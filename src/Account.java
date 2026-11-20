public class Account {
    // Properties
    private int _accountNumber;
    private String _accountName;
    private double _accountBalance;

    // Static variable
    private static int COUNT = 0;

    // Constructor
    public Account(String accountName, double accountBalance) {
        _accountName = accountName;
        _accountBalance = accountBalance;
        _accountNumber = ++COUNT;
    }

    // Methods
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount");
            return;
        }
        _accountBalance += amount;
        System.out.println("Successful Operation");
    }

    public void withDraw(double amount) {
        if (amount <= 0 || amount > _accountBalance) {
            System.out.println("Invalid Operation");
            return;
        }
        _accountBalance -= amount;
        System.out.println("Successful Operation");
    }

    public double calculateInterest() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Account Number  : " + _accountNumber);
        System.out.println("Account Name    : " + _accountName);
        System.out.println("Account Balance : " + _accountBalance);
    }

    // Getters
    public double getBalance() {
        return _accountBalance;
    }

    public int getAccountNumber() {
        return _accountNumber;
    }

    public String getAccountName() {
        return _accountName;
    }

    // Only childs( specificly CheckingAccount) can use this method
    protected void subtractFromBalance(double amount) {
        _accountBalance -= amount;
    }
}