import java.util.Scanner;
public class For_Loops {

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        // for loop = execute some code a CERTAIN amount of times
        // best for repeating code a SPECIFIC amounts of times

        // we need a counter // init
        // a condition when we want to stop // Condition
        // and updating the counter // Update

        // countdown sim

        System.out.print("How many seconds to countdown from?: ");
        int start = scanner.nextInt();

        for (int i = start;i > 0;i--){
            System.out.println(i);
            Thread.sleep(1000);
        }
        System.out.println("Link Start!");

    }
}
