import java.util.Scanner;
public class WhoAmI {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);


        String playerAnswer;

        System.out.println("Do i know you from somewhere?");

        System.out.print("Yes/No: ");
        playerAnswer = scanner.nextLine().toLowerCase();

        switch (playerAnswer){

            case "yes" -> System.out.println("+ Social Skills");
            case "no" -> System.out.println("- Team Chemistry");

        }
    }



}
