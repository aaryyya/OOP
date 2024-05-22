import java.util.Scanner;

class AdditionThread extends Thread {
    private double num1, num2;

    public AdditionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 + num2;
        System.out.println("Addition Result: " + result);
    }
}

class SubtractionThread extends Thread {
    private double num1, num2;

    public SubtractionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 - num2;
        System.out.println("Subtraction Result: " + result);
    }
}

class MultiplicationThread extends Thread {
    private double num1, num2;

    public MultiplicationThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        double result = num1 * num2;
        System.out.println("Multiplication Result: " + result);
    }
}

class DivisionThread extends Thread {
    private double num1, num2;

    public DivisionThread(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    @Override
    public void run() {
        if (num2 != 0) {
            double result = num1 / num2;
            System.out.println("Division Result: " + result);
        } else {
            System.out.println("Division Error: Cannot divide by zero.");
        }
    }
}

public class _17_MultithreadedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input validation
        double num1 = 0, num2 = 0;
        while (true) {
            try {
                System.out.print("Enter first number: ");
                num1 = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter second number: ");
                num2 = Double.parseDouble(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter valid numbers.");
            }
        }
// while(true){
        System.out.println("Choose an operation:");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        // String operation = scanner.nextLine().toLowerCase();
        int input = scanner.nextInt();
        // Create and start threads based on user choice
        switch (input) {
            case 1:
                new AdditionThread(num1, num2).start();
                break;
            case 2:
                new SubtractionThread(num1, num2).start();
                break;
            case 3:
                new MultiplicationThread(num1, num2).start();
                break;
            case 4:
                new DivisionThread(num1, num2).start();
                break;
            case 5:
            System.out.println("Exit");
            System.exit(0);
            default:
                System.out.println("Invalid operation. Please choose from addition, subtraction, multiplication, or division.");
        }
    
        // scanner.close();
    }
    }

