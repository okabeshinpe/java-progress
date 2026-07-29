import java.util.Scanner;

public class methods_practice1 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        // math tool box


        // WELCOME TEXT

        System.out.println("== MATH TOOL BOX ==");
        System.out.print("Enter a number to square: ");
        // storing a value in num, and having that value get squared with the method
        double squareNum = scanner.nextDouble();
        double squareResult = square(squareNum);

        /*
        storing again whatever the user wants to cube, in a variable, then putting that in
        a variable of result for us to use the method on.
         */
        System.out.print("Enter a number you want to cube: ");
        double cubeNum = scanner.nextDouble();
        double cubeResult = cube(cubeNum);

        /*
        somehow we're doing more math so..
        let's make a variable of length and width, then ask the user for a value
         */
        // LIL WELCOME NOTE
        System.out.print("== CALCULATING THE AREA OF A RECTANGLE ==\n");

        System.out.print("Enter the length: ");
        double length = scanner.nextDouble();

        System.out.print("Enter the width: ");
        double width = scanner.nextDouble();
        double area = rectangleArea(length, width);


        // PRINTING the number when we square & cube it using the methods
        System.out.printf("Square of %.0f: %.1f\n", squareNum, squareResult);
        System.out.printf("Cube of %.0f: %.1f\n", cubeNum, cubeResult);
        System.out.printf("Area of a rectangle: %.2f", area);

    }
    static double square(double squaredNum){
        return squaredNum * squaredNum;
    }
    static double cube(double cubedNum){
        return cubedNum * cubedNum * cubedNum;
    }
    static double rectangleArea(double length, double width){
        return length * width;
    }
}
