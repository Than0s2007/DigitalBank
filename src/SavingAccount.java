public class SavingAccount extends Account {
    // Properties
    private double _interestRate;
    private double _minimumBalance;

    // Constructor
    public SavingAccount(String accountName, double accountBalance,double interestRate, double minimumBalance) {
        super(accountName, accountBalance);
        _interestRate = interestRate;
        _minimumBalance = minimumBalance;
    }

    // Methods
    @Override
    public double calculateInterest() {
        if (getBalance() >= _minimumBalance) {
            return getBalance() * _interestRate;
        }
        return 0.0;
    }

    @Override
    public void withDraw(double amount) {
        if (amount > 0 && (getBalance() - amount) >= _minimumBalance) {
            super.withDraw(amount);
            return;
        }
        System.out.println("Invalid Operation");
    }

    @Override
    public void displayInfo() {
        System.out.println("Account Type    : Saving");
        super.displayInfo();
        System.out.println("Interest Rate   : " + _interestRate);
        System.out.println("Minimum Balance : " + _minimumBalance);
    }
}