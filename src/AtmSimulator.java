import java.util.Scanner;
public class AtmSimulator {

    public static void  main(String[] args){
        Scanner scanner = new Scanner(System.in);
        /* ATM simulator
        = we need an option =
        1. check balance
        2. deposit
        3. withdraw
        4. exit
         */
        // variables
        int choice;
        double balance = 10000;
        do{
            showMenu();
            printBorder();
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            if (choice == 1){
                System.out.println("Your Current Balance: $" + balance);
            }
            else if (choice == 2){
                printBorder();
                System.out.print("Enter Deposit Amount: ");
                double depositAmount = scanner.nextDouble();

                if (depositAmount <= 0){
                    System.out.println("Invalid Amount!");
                }
                else{
                    balance = deposit(balance, depositAmount);
                    System.out.println("Your New Balance: $" + balance);
                }
            }
            else if (choice == 3){
                printBorder();
                System.out.print("Enter Withdraw Amount: ");
                double withdrawAmount = scanner.nextDouble();
                if (withdrawAmount > balance){
                    System.out.println("Insufficient Funds!");
                }
                else if (withdrawAmount <= 0){
                    System.out.println("Invalid Input!");
                }
                else{
                    printBorder();
                    System.out.println("You Withdrew: $" + withdrawAmount);
                    balance = withdraw(balance, withdrawAmount);
                    System.out.println("Your New Balance: $" + balance);
                }
            }
            else if (choice > 4 || choice <= 0){
                System.out.println("== Invalid Option! ==");
            }
        }while (choice != 4);
        System.out.println("Goodbye!");
    }
    static double deposit(double balance, double amount){
        return balance + amount;
    }
    static double withdraw(double balance, double amount){
        return balance - amount;
    }
    static void printBorder(){
        System.out.println("===========================");
    }
    static void showMenu(){
        printBorder();
        System.out.println("====== ATM SIMULATOR ======");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }
}
