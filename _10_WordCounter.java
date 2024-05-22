import java.util.*;

public class _10_WordCounter {
    
    public int countUniqueWords(String text) {
        String[] words = text.split("\\s+"); // Split the text into words using whitespace as delimiter
        HashSet<String> uniqueWords = new HashSet<>();
        
        for (String word : words) {
            uniqueWords.add(word.toLowerCase()); // Add lowercase version of word to HashSet
        }
        
        return uniqueWords.size(); // Return the size of HashSet, which represents the count of unique words
    }
    
    public static void main(String[] args) {
        // Create an instance of WordCounter
        WordCounter wordCounter = new WordCounter();
        
        // Prompt the user to enter a text string
        System.out.println("Enter a text string:");
        
        // Read the text string from the user
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        
        // Count the number of unique words using the WordCounter class
        int uniqueWordCount = wordCounter.countUniqueWords(text);
        
        // Display the number of unique words
        System.out.println("Number of unique words: " + uniqueWordCount);
    }
}
