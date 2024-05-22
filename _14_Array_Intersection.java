import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _14_Array_Intersection {
    public static void main(String[] args) {
        int nums1[] = { 1, 3, 2, 1 };
        int nums2[] = { 3, 2 };
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }

    public static int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set1 = new HashSet<>();
        for (int n1 : nums1) {
            set1.add(n1);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int n2 : nums2) {

            if (set1.contains(n2)) {
                set2.add(n2);
            }
        }

        int[] result = new int[set2.size()];
        int i = 0;
        for (int x : set2) {
            result[i] = x;
            i++;
        }

        return result;
    }
}
