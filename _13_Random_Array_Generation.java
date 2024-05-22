import java.util.*;

public class _13_Random_Array_Generation {
    public static void main(String[] args) {
        // Generate a random array
        int array[] = generateRandomArray(10, 1, 20);
        System.out.println("Original Array: ");
        printArray(array);

        // Rotate the array to the right by 3 positions
        int[] rotatedArray = rotateRight(array, 3);
        System.out.println("Rotated Array: ");
        printArray(rotatedArray);

        // Remove duplicates from the array
        int[] arrayWithoutDuplicates = removeDuplicates(array);
        System.out.println("Without Duplicated Array: ");
        printArray(arrayWithoutDuplicates);

        // Rearrange the array to have even numbers before odd numbers
        int[] rearrangedArray = rearrangeEvenOdd(array);
        System.out.println("Rearranged Array: ");
        printArray(rearrangedArray);
    }

    // Generate a random array of integers
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(maxValue - minValue + 1) + minValue;
        }
        return array;
    }

    // Rotate the elements of the array to the right by a specified number of
    // positions
    public static int[] rotateRight(int[] array, int positions) {
        int n = array.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[(i + positions) % n] = array[i];
        }
        return result;
    }

    // Remove duplicate elements from the array while preserving the original order
    public static int[] removeDuplicates(int[] array) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int num : array) {
            set.add(num);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    // Rearrange the elements of the array such that all even numbers appear before
    // all odd numbers
    public static int[] rearrangeEvenOdd(int[] array) {
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddList = new ArrayList<>();
        for (int num : array) {
            if (num % 2 == 0) {
                evenList.add(num);
            } else {
                oddList.add(num);
            }
        }
        evenList.addAll(oddList);
        int[] result = new int[array.length];
        for (int i = 0; i < evenList.size(); i++) {
            result[i] = evenList.get(i);
        }
        return result;
    }

    public static void printArray(int arr[]) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                System.out.print(arr[i]);
            } else {
                System.out.print(arr[i] + ", ");
            }
        }
        System.out.print("]\n");
        System.out.println();
    }
}
