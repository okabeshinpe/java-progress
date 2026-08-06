import java.util.Scanner;
public class BankingProgram {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // CURRENT BALANCE
        double balance = 10000;
        double amount;
        int choice;

        do {
            menu();
            choice();
            choice = scanner.nextInt();

            switch (choice){

                case 1 -> {
                    lineDesign();
                    currentBalance(balance);
                    lineDesign();
                }
                case 2 -> {
                    lineDesign();
                    System.out.print("Enter Deposit Amount: ");
                    amount = scanner.nextDouble();

                    if (amount <= 0){
                        invalid(amount);
                    }
                    else{
                        lineDesign();
                        balance = depositMoney(amount,balance);
                        currentBalance(balance);
                    }
                }
                case 3 -> {
                    lineDesign();
                    System.out.print("Enter withdraw amount: ");
                    amount = scanner.nextDouble();

                    if (amount > balance || amount <= 0) {
                        invalid(amount, balance);
                    }
                    else{
                        lineDesign();
                        balance = withdrawMoney(balance,amount);
                        currentBalance(balance);
                    }
                }
                default -> {
                    invalid();
                }
            }


        } while (choice != 4);
        lineDesign();
        System.out.println("GOODBYE!");
        lineDesign();
    }
    static void menu(){
        lineDesign();
        System.out.println("Banking Program");
        lineDesign();
        System.out.println("1. Show Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
        lineDesign();
    }
    static void choice(){
        System.out.print("Enter your choice: ");
    }
    static void lineDesign(){
        System.out.println("====================");
    }
    static double depositMoney(double amount, double balance){
        return amount + balance;
    }
    static double withdrawMoney(double balance, double amount){
        return balance - amount;
    }
    static void invalid(){
        lineDesign();
        System.out.println("Invalid Operation!");
    }
    static void invalid(double amount){
        lineDesign();
        System.out.println("Invalid Operation!");
        System.out.println("$"+ amount + " Cannot be deposited!");
    }
    static void invalid(double amount, double balance){
        lineDesign();
        System.out.println("Invalid Operation!");
        System.out.println("Insufficient funds!");
        System.out.printf("You only have $%.2f\n",balance);
    }
    static void currentBalance(double balance){
        lineDesign();
        System.out.printf("Balance: $%.2f\n", balance);
    }
}
