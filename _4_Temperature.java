import java.util.*;

class InvalidTemperatureException extends Exception {
    public InvalidTemperatureException(String message) {
        super(message);
    }
}

public class _4_Temperature {

    public double CtoF(double temperature) {
        double CtoF = temperature * (9 / 5) + 32;
        return CtoF;
    }

    public double FtoC(double temperature) {
        double FtoC = (temperature - 32) * (5 / 9);
        return FtoC;
    }

    public static void main(String[] args) {
        // double i=4579;

        try {
            _4_Temperature obj = new _4_Temperature();
            Scanner scan = new Scanner(System.in);
            while (true) {
                System.out.println("Enter Input from the Menu");
                System.out.println("1. Celcius to Fahrenite");
                System.out.println("2. Fahrenite to Celcius");
                System.out.println("3. Exit");
                int input = scan.nextInt();
                double temp;
                switch (input) {
                    case 1:
                        System.out.println("Enter Input for Celcius to Fahrenite Conversion");
                        temp = scan.nextDouble();
                        if (temp < -273.15 || temp > 1000) {
                            throw new InvalidTemperatureException("InvalidTemperatureException");
                        }
                        double CtoF = obj.CtoF(temp);
                        System.out.println(CtoF);
                    case 2:
                        System.out.println("Enter Input for Fahrenite to Celcius Conversion");
                        temp = scan.nextDouble();
                        if (temp < -273.15 || temp > 1000) {
                            throw new InvalidTemperatureException("InvalidTemperatureException");
                        }
                        double FtoC = obj.FtoC(temp);
                        System.out.println(FtoC);
                    case 3:
                        System.out.println("Exiting...");
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}

/*
 * 4. Implement a program for a temperature converter. The program should
 * convert temperatures between Celsius and Fahrenheit. However, there are
 * certain constraints:
 * I. The temperature value should be within a valid range (-273.15°C to
 * 1000°C).
 * Ii. The conversion should only be performed if the input temperature is
 * within the valid range.
 * Your task is to implement a Java program that handles these constraints using
 * custom exceptions. Define a custom exception class
 * InvalidTemperatureException to handle the case when the input temperature is
 * outside the valid range.
 */