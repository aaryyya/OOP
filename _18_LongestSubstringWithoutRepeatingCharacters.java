import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _18_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the string: ");
        String input = scanner.nextLine();

        int length = longestSubstringLength(input);
        System.out.println("Length of the longest substring without repeating characters: " + length);

        scanner.close();
    }

    public static int longestSubstringLength(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();

        for (int start = 0, end = 0; end < n; end++) {
            char ch = s.charAt(end);
            if (charIndexMap.containsKey(ch)) {
                start = Math.max(charIndexMap.get(ch) + 1, start);
            }
            maxLength = Math.max(maxLength, end - start + 1);
            charIndexMap.put(ch, end);
        }

        return maxLength;
    }
}
