import java.util.Scanner;
public class mini_calc {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //  MINI CALC

        System.out.println("==== MINI CALCULATOR ====");

        // let's print the menu of what the user can do with the calc
        System.out.println("1. Square");
        System.out.println("2.  Cube");
        System.out.println("3. Rectangle Area");

        System.out.print("Choose an option: ");
        int userChoice = scanner.nextInt();

        switch (userChoice){

            case 1 -> {
                System.out.print("Enter a number you'd like to square: ");
                int squareNum = scanner.nextInt();

                int squareResult = square(squareNum);
                System.out.println("== RESULT ==");
                System.out.printf("Square of %d: %d",squareNum, squareResult );
            }
            case 2 -> {
                System.out.print("Enter a number you'd like to cube: ");
                int cubeNum = scanner.nextInt();

                int cubeResult = cube(cubeNum);
                System.out.println("== RESULT ==");
                System.out.printf("The cube of %d: %d", cubeNum, cubeResult);
            }
            case 3 ->{
                System.out.println("== RECTANGLE AREA CALC ==");

                System.out.print("Enter the length: ");
                double length = scanner.nextDouble();

                System.out.print("Enter the width: ");
                double width = scanner.nextDouble();

                double areaResult = rectangleArea(length, width);

                System.out.printf("The area of the rectangle: %.2f", areaResult);


            }
            default -> System.out.println("Invalid Option!");

        }
    }
    static int square(int number){
        return number * number;
    }
    static int cube(int number){
        return number * number * number;
    }
    static double rectangleArea(double length, double width){
        return length * width;
    }
}



