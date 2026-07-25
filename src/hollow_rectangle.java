import java.util.Scanner;
public class hollow_rectangle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 07/23/26
        /*
        new concept unlocked: break and continue & nested loops

        break -> breaks out of a loop or basically stops
        continue -> skips the current iteration of a loop, skips
        nested loops -> loops inside another loop used often with matrices or DSA
        :doomed:
         */

        // variables
        int rows;
        int cols;
        char symbol;

        // ask for user's input
        System.out.print("Enter how many rows: ");
        rows = scanner.nextInt();
        System.out.print("Enter how many columns: ");
        cols = scanner.nextInt();
        System.out.print("Enter what symbol you'd like: ");
        symbol = scanner.next().charAt(0);

        // for loops

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                if (i == 0 || i == rows - 1 || j == 0 || j == cols - 1){
                    System.out.print(symbol);
                }
                else{
                    System.out.print(" ");
                }
            }System.out.println();
        }
    }


}
