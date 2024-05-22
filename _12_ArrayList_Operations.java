import java.util.*;

public class _12_ArrayList_Operations {  
    public static void main(String[] args) {
        // Part A: Remove duplicates from an ArrayList
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(10, 20, 10, 15, 40, 15, 40));
        System.out.println("Original List: " + numbers);
        ArrayList<Integer> uniqueNumbers = removeDuplicates(numbers);
        System.out.println("List after removing duplicates: " + uniqueNumbers);

        // Part B: Perform operations on ArrayList
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30));
        System.out.println("Original ArrayList: " + list);

        // I. Check if an element exists in ArrayList
        int elementToCheck = 15;
        boolean exists = list.contains(elementToCheck);
        System.out.println("Does " + elementToCheck + " exist in the ArrayList? " + exists);

        // II. Add element at a particular index of ArrayList
        list.add(2, 12);
        System.out.println("ArrayList after adding 12 at index 2: " + list);

        // III. Remove element at a particular index of ArrayList
        list.remove(3);
        System.out.println("ArrayList after removing element at index 3: " + list);

        // IV. Sort the ArrayList
        Collections.sort(list);
        System.out.println("Sorted ArrayList: " + list);

        // V. Reverse the elements in an ArrayList
        Collections.reverse(list);
        System.out.println("Reversed ArrayList: " + list);

        // VI. Compare two ArrayLists
        ArrayList<Integer> anotherList = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30));
        boolean areEqual = list.equals(anotherList);
        System.out.println("Are the two ArrayLists equal? " + areEqual);

        // VII. Find the first and last occurrence of repeated elements
        ArrayList<Integer> listWithDuplicates = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 2, 5, 6, 3, 7));
        System.out.println("ArrayList with duplicates: " + listWithDuplicates);
        findFirstAndLastOccurrences(listWithDuplicates);
    }

    // Method to remove duplicates from an ArrayList
    public static ArrayList<Integer> removeDuplicates(List<Integer> list) {
        HashSet<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }

    // Method to find the first and last occurrence of repeated elements
    public static void findFirstAndLastOccurrences(List<Integer> list) {
        Map<Integer, Integer> firstOccurrences = new HashMap<>();
        Map<Integer, Integer> lastOccurrences = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            int element = list.get(i);
            lastOccurrences.put(element, i);
            firstOccurrences.putIfAbsent(element, i);
        }

        System.out.println("First Occurrences: " + firstOccurrences);
        System.out.println("Last Occurrences: " + lastOccurrences);
    }
}

