package _MonotonicArray;

public class main {

    /*
     * Method 1: Monotonic array
     * TC : O(N)
     * SC : O(1)
     * Imagine ascending a mountain or descending a mountain.
     * The moment you find a depression while ascending, means it's not monotonic
     * increasing
     * The moment you find a local peak while descending, means it's not
     * monotonically decreasing
     * The only thing to keep in mind is to start from an index where there are 2
     * different elements
     * which can make us decide whether it's increasing or decreasing
     */

    public static boolean isMonotonic(int[] arr) {
        int n = arr.length;
        boolean isIncreasing;
        boolean isDecreasing;

        if (n == 1) {
            return true;
        }

        int i = 1;
        while (i < n && arr[i] == arr[i - 1]) {
            i++;
        }
        if (i < n) {
            isIncreasing = arr[i] > arr[i - 1];
            isDecreasing = arr[i - 1] > arr[i];
        } else {
            return true;
        }

        for (; i < n; i++) {
            if (isIncreasing && arr[i] < arr[i - 1]) {
                return false;
            }

            if (isDecreasing && arr[i] > arr[i - 1]) {
                return false;
            }
        }

        return true;
    }
}
