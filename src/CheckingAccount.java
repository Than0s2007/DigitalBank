public class CheckingAccount extends Account {
    // Properties
    private double _overdraftLimit;

    // Constructor
    public CheckingAccount(String accountName, double accountBalance, double overdraftLimit) {
        super(accountName, accountBalance);
        _overdraftLimit = overdraftLimit;
    }

    // Methods
    @Override
    public void withDraw(double amount) {
        if (amount > 0 && amount <= (getBalance() + _overdraftLimit)) {
            subtractFromBalance(amount);
            System.out.println("Successful Operation");
        } else {
            System.out.println("Invalid Operation");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Account Type    : Checking");
        super.displayInfo();
        System.out.println("Overdraft Limit : " + _overdraftLimit);
    }
}