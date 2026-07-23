import java.util.Scanner;
public class multiplication_table {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

        // 07/22/26
        // a little bit rusty, got too focused on math

        // VARIABLE
        int userNumber;

        // SHORT WELCOME MESSAGE
        System.out.println("== MULTIPLICATION TABLE == ");

        //ASK FOR USER INPUT
        System.out.print("Enter a number: ");
        userNumber = scanner.nextInt();

        // FOR LOOP WON'T END TILL IT HITS 10
        for (int i = 1; i <= 10 ; i++){
            System.out.printf("%d x %d = %d\n",userNumber, i, userNumber * i);

        }
    }
}