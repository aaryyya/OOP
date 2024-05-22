import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class _8_BArrayOps {

    public void SumAllEle(Integer[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
            sum = sum + array[i];
        }
        System.out.println("\nSum of All elements is " + sum);
    }

    public void Max(Integer[] array) {
        int max = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
            }
        }
        System.out.println("Max Element " + max);
    }

    public void Min(Integer[] array) {
        int min = array[0];
        for (int j = 0; j < array.length; j++) {
            if (array[j] < min) {
                min = array[j];
            }
        }
        System.out.println("Min Element " + min);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        Integer[] array = new Integer[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        array_Question obj = new array_Question();
        obj.SumAllEle(array);
        obj.Max(array);
        obj.Min(array);

        Arrays.sort(array);
        System.out.println("Array in ascending order: " + Arrays.toString(array));

        Arrays.sort(array, Comparator.reverseOrder());
        System.out.println("Array in descending order: " + Arrays.toString(array));
    }
}
