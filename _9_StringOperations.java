import java.util.Scanner;

public class _9_StringOperations {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the first string:");
        String str1 = scanner.nextLine();
        
        System.out.println("Enter the second string:");
        String str2 = scanner.nextLine();
        
        // A. Concatenate two strings
        String concatenatedString = concatenateStrings(str1, str2);
        System.out.println("Concatenated string: " + concatenatedString);
        
        // B. Find the length of a string
        int lengthOfString1 = findStringLength(str1);
        int lengthOfString2 = findStringLength(str2);
        System.out.println("Length of first string: " + lengthOfString1);
        System.out.println("Length of second string: " + lengthOfString2);
        
        // C. Convert a string to uppercase
        String upperCaseString1 = convertToUpperCase(str1);
        String upperCaseString2 = convertToUpperCase(str2);
        System.out.println("Uppercase of first string: " + upperCaseString1);
        System.out.println("Uppercase of second string: " + upperCaseString2);
        
        // D. Convert a string to lowercase
        String lowerCaseString1 = convertToLowerCase(str1);
        String lowerCaseString2 = convertToLowerCase(str2);
        System.out.println("Lowercase of first string: " + lowerCaseString1);
        System.out.println("Lowercase of second string: " + lowerCaseString2);
        
        // E. Check if a string contains a specific substring
        System.out.println("Enter the substring to check in the first string:");
        String substring = scanner.nextLine();
        boolean containsSubstring1 = checkSubstring(str1, substring);
        System.out.println("First string contains substring: " + containsSubstring1);
        
        // F. Replace a substring with another substring in a string
        System.out.println("Enter the substring to replace:");
        String replaceSubstring = scanner.nextLine();
        System.out.println("Enter the replacement substring:");
        String replacement = scanner.nextLine();
        String replacedString1 = replaceSubstring(str1, replaceSubstring, replacement);
        System.out.println("First string after replacement: " + replacedString1);
    }
    
    // A. Concatenate two strings
    public static String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }
    
    // B. Find the length of a string
    public static int findStringLength(String str) {
        return str.length();
    }
    
    // C. Convert a string to uppercase
    public static String convertToUpperCase(String str) {
        return str.toUpperCase();
    }
    
    // D. Convert a string to lowercase
    public static String convertToLowerCase(String str) {
        return str.toLowerCase();
    }
    
    // E. Check if a string contains a specific substring
    public static boolean checkSubstring(String str, String substring) {
        return str.contains(substring);
    }
    
    // F. Replace a substring with another substring in a string
    public static String replaceSubstring(String str, String replaceSubstring, String replacement) {
        return str.replace(replaceSubstring, replacement);
    }
}
