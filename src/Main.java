import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Digital Bank");

        int choice;
        do {
            System.out.println("\n===== Digital Bank =====");
            System.out.println("1. Add Saving Account");
            System.out.println("2. Add Checking Account");
            System.out.println("3. Display All Accounts");
            System.out.println("4. Display Saving Accounts");
            System.out.println("5. Display Checking Accounts");
            System.out.println("6. Search Account By ID");
            System.out.println("7. Deposit");
            System.out.println("8. Withdraw");
            System.out.println("9. Transfer");
            System.out.println("10. Calculate Interest");
            System.out.println("11. Statistics");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Name: ");
                    String sName = scanner.next();
                    System.out.print("Balance: ");
                    double sBalance = scanner.nextDouble();
                    System.out.print("Interest rate (e.g. 0.05): ");
                    double rate = scanner.nextDouble();
                    System.out.print("Minimum balance: ");
                    double min = scanner.nextDouble();
                    bank.addAccount(new SavingAccount(sName, sBalance, rate, min));
                    break;

                case 2:
                    System.out.print("Name: ");
                    String cName = scanner.next();
                    System.out.print("Balance: ");
                    double cBalance = scanner.nextDouble();
                    System.out.print("Overdraft limit: ");
                    double overdraft = scanner.nextDouble();
                    bank.addAccount(new CheckingAccount(cName, cBalance, overdraft));
                    break;

                case 3:
                    bank.displayAllAccounts();
                    break;

                case 4:
                    bank.displaySavingAccounts();
                    break;

                case 5:
                    bank.displayCheckingAccounts();
                    break;

                case 6:
                    System.out.print("Account ID: ");
                    bank.displayAccountById(scanner.nextInt());
                    break;

                case 7:
                    System.out.print("Account ID: ");
                    int dId = scanner.nextInt();
                    System.out.print("Amount: ");
                    bank.depositById(dId, scanner.nextDouble());
                    break;

                case 8:
                    System.out.print("Account ID: ");
                    int wId = scanner.nextInt();
                    System.out.print("Amount: ");
                    bank.withdrawById(wId, scanner.nextDouble());
                    break;

                case 9:
                    System.out.print("From ID: ");
                    int from = scanner.nextInt();
                    System.out.print("To ID: ");
                    int to = scanner.nextInt();
                    System.out.print("Amount: ");
                    bank.transfer(from, to, scanner.nextDouble());
                    break;

                case 10:
                    System.out.print("Account ID: ");
                    int iId = scanner.nextInt();
                    System.out.println("Interest = " + bank.getInterestById(iId));
                    break;

                case 11:
                    bank.displayBankSummary();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        scanner.close();
    }
}