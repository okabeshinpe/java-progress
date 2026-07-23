import java.util.Scanner;

public class sum_calculator {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // 07/23/26
        // sum calculator

        // variables
        int userNumber;
        int currentSum = 0;

        // program name
        System.out.println("== SUM CALCULATOR ==");

        //ask for a user input for the sum
        System.out.print("Enter a number: ");
        userNumber = scanner.nextInt();

        // for loops starts, the current sum must be updated

        for (int i = 1; i <= userNumber ;i++){

            currentSum = currentSum + i;

        }
        System.out.println(currentSum);
    }
}
