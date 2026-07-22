import java.util.Scanner;
public class factorial_calculator {

    public static void  main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // VARIABLE
        int userNumber;
        int factorial = 1;

        // INTRODUCTION
        System.out.println("== FACTORIAL CALCULATOR == ");

        // ASK FOR USER INPUTs
        System.out.print("Enter a number: ");
        userNumber = scanner.nextInt();

        for (int i = userNumber; i >= 1 ; i--){
            factorial = factorial * i;
        }
        System.out.printf("%d! = %d",userNumber, factorial);
    }
}
