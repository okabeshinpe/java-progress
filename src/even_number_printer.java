import java.util.Scanner;
public class even_number_printer {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        // 07/23/26
        // Even number printer

        // variables
        int userNumber;

        // lil message
        System.out.println("== EVEN NUMBER PRINTER ==");

        // ask user for a number, then lets print even
        System.out.print("Enter a number: ");
        userNumber = scanner.nextInt();

        for (int i = 2; i <= userNumber ;i+=2){

            System.out.println(i);

        }
    }
}
