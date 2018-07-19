package EnumExcercise;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class App {

    public static void main(String[] args) {
        Scanner inputReader = new Scanner(System.in);
        String input = "";
        MathOperator operator = null;
        String operand = "";
        String inputTwo = "";
        int solution = 0;
        int input1 = 0;
        int input2 = 0;

        System.out.println("Please enter an operand as PLUS, MINUS, DIVIDE, or "
                + "MULTIPLY");
        operand = inputReader.nextLine();
        operator = MathOperator.parse(operand);

        System.out.println("Please enter your first number");
        input = inputReader.nextLine();
        input1 = Integer.parseInt(input);

        System.out.println("Please enter your second number");
        inputTwo = inputReader.nextLine();
        input2 = Integer.parseInt(inputTwo);
        
        solution = calculate(operator, input1, input2);
    }
}
