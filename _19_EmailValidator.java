import java.util.Scanner;

// Custom Exception
class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        super(message);
    }
}

public class _19_EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your email address: ");
        String email = scanner.nextLine();

        try {
            checkEmail(email);
            System.out.println("The email address is valid.");
        } catch (InvalidEmailException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }

    // Method to check if the email is valid
    public static void checkEmail(String email) throws InvalidEmailException {
        if (email == null || email.isEmpty()) {
            throw new InvalidEmailException("Email address cannot be null or empty.");
        }

        int atPosition = email.indexOf('@');
        int dotPosition = email.lastIndexOf('.');

        if (atPosition == -1 || dotPosition == -1) {
            throw new InvalidEmailException("Invalid email address: Email must contain '@' and '.'.");
        }

        if (atPosition > dotPosition) {
            throw new InvalidEmailException("Invalid email address: '@' must come before '.'.");
        }

        if (atPosition == 0 || dotPosition == email.length() - 1) {
            throw new InvalidEmailException("Invalid email address: '@' cannot be at the start and '.' cannot be at the end.");
        }
    }
}
