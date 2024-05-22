import java.util.Scanner;

public class _11_ArmstrongNo{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // a. Check if a given number is Armstrong or not
        System.out.println("Enter a number to check if it's Armstrong:");
        int number = scanner.nextInt();
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
        
        // b. Check if two strings are anagrams
        System.out.println("Enter the first string:");
        String str1 = scanner.next();
        System.out.println("Enter the second string:");
        String str2 = scanner.next();
        if (areAnagrams(str1, str2)) {
            System.out.println(str1 + " and " + str2 + " are anagram strings.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagram strings.");
        }
        
        // c. Compare two dates of birth and display the result
        System.out.println("Enter the first date of birth (yyyy-MM-dd):");
        String dob1 = scanner.next();
        System.out.println("Enter the second date of birth (yyyy-MM-dd):");
        String dob2 = scanner.next();
        compareDatesOfBirth(dob1, dob2);
        
        // d. Check if a given number is prime
        System.out.println("Enter a number to check if it's prime:");
        int num = scanner.nextInt();
        if (isPrime(num)) {
            System.out.println(num + " is a prime number.");
        } else {
            System.out.println(num + " is not a prime number.");
        }
    }
    
    // a. Method to check if a number is Armstrong
    public static boolean isArmstrong(int number) {
        int originalNumber, remainder, result = 0, n = 0;
        originalNumber = number;
        while (originalNumber != 0) {
            originalNumber /= 10;
            ++n;
        }
        originalNumber = number;
        while (originalNumber != 0) {
            remainder = originalNumber % 10;
            result += Math.pow(remainder, n);
            originalNumber /= 10;
        }
        return result == number;
    }
    
    // b. Method to check if two strings are anagrams
    public static boolean areAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i)]++;
            count[str2.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
    // c. Method to compare two dates of birth
    public static void compareDatesOfBirth(String dob1, String dob2) {
        int comparison = dob1.compareTo(dob2);
        if (comparison < 0) {
            System.out.println("The first person is younger.");
        } else if (comparison > 0) {
            System.out.println("The first person is elder.");
        } else {
            System.out.println("Both persons are of the same age.");
        }
    }
    
    // d. Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
