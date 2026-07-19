import java.util.Random;
import java.util.Scanner;
public class NumberGuessingGame {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);
                Random random = new Random();

                // variables we need
                int attempts = 1;
                int randomNumber = 0;
                int playerGuess; // tracks the player's guess
                int difficultyLevel; // diff
                String playerReady;

                // quick little message

                System.out.println("==  NUMBER GUESSING GAME ==");
                System.out.println("RULES");
                System.out.println("1.Guess the number, you win!");
                System.out.println("2.Run out of attempts, you lose!");
                System.out.println("Plain and simple.");

                System.out.print("Are you ready? (y/n): ");
                playerReady = scanner.nextLine().toLowerCase();

                switch (playerReady) {

                        case "y" -> {
                                System.out.println("== DIFFICULTY == ");
                                System.out.println("1. Easy");
                                System.out.println("2. Normal");
                                System.out.println("3. Hard");
                                System.out.print("Enter a difficulty: ");
                                difficultyLevel = scanner.nextInt();

                                switch (difficultyLevel) {
                                        case 1 -> {
                                                System.out.println("Your game difficulty is: Easy");
                                                System.out.println("Guess a number from 1 - 10");
                                                System.out.println("You have 3 Attempts to guess it!");
                                                System.out.println("== Game Start! ==");
                                                randomNumber = random.nextInt(1, 11);
                                                attempts = 3;
                                        }
                                        case 2 -> {
                                                System.out.println("Your game difficulty is: Normal");
                                                System.out.println("Guess a number from 1 - 15");
                                                System.out.println("You have 4 Attempts to guess it!");
                                                System.out.println("== Game Start! ==");
                                                randomNumber = random.nextInt(1, 16);
                                                attempts = 4;
                                        }
                                        case 3 -> {
                                                System.out.println("Your game difficulty is: Hard");
                                                System.out.println("Guess a number from 1 - 20");
                                                System.out.println("You have 5 Attempts to guess it!");
                                                System.out.println("== Game Start! ==");
                                                randomNumber = random.nextInt(1, 21);
                                                attempts = 5;
                                        }

                                        default ->{
                                                System.out.printf("%d is not in the difficulty selection!", difficultyLevel);
                                                return;
                                        }
                                }do{
                                        System.out.print("Guess the number: ");
                                        playerGuess = scanner.nextInt();
                                        attempts--;

                                        if (playerGuess == randomNumber){
                                                System.out.println("== YOU WIN! ==");
                                                System.out.printf("Attempts Left: %d\n", attempts);
                                        }
                                        else if (attempts == 0){
                                                System.out.println("== YOU LOST! == ");
                                                System.out.printf("Attempts Left: %d\n", attempts);
                                        }
                                        else if (playerGuess < randomNumber){
                                                System.out.println("GUESS HIGHER!");
                                                System.out.printf("Attempts Left: %d\n", attempts);
                                        }
                                        else{
                                                System.out.println("GUESS LOWER");
                                                System.out.printf("Attempts Left: %d\n", attempts);
                                        }


                                }while (playerGuess != randomNumber && attempts > 0);
                        }
                        case "n" -> {
                                System.out.println("Goodbye!");
                                break;
                        }
                        default -> System.out.printf("%s is not an answer!", playerReady);
                }
        }
}
