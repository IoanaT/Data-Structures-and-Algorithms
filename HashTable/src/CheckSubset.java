import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.*;

public class CheckSubset {
    /**
     * Check wether array2 is a subset of array1
     */
    public static boolean isSubset(int[] arr1, int[] arr2) {
        // write your code here
        List<Integer> list = IntStream.of(arr1).boxed().collect(Collectors.toList());
        HashSet<Integer> hSet = new HashSet<>(list);
        Optional<Integer> result = IntStream.of(arr2).boxed().filter(elem -> !hSet.contains(elem)).findAny();
        return !result.isPresent();
    }

    public static void main(String args[]) {

        int[] arr1 = {9, 4, 7, 1, -2, 6, 5};
        int[] arr2 = {7, 1, -2};
        int[] arr3 = {10, 12};

        System.out.println(isSubset(arr1, arr2));
        System.out.println(isSubset(arr1, arr3));
    }
}
