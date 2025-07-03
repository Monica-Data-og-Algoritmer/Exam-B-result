import java.util.List;
import java.util.Arrays;
import java.io.IOException;

public class TaskThree {

    // Counts number of merges performed during sorting
    static int mergeCount = 0;

    // Recursively splits and sorts the array
    public static void mergeSort(double[] input) {
        int n = input.length;

        if (n > 1) {
            int mid = n / 2;

            // Create left and right subarrays
            double[] left = new double[mid];
            double[] right = new double[n - mid];

            System.arraycopy(input, 0, left, 0, mid);
            System.arraycopy(input, mid, right, 0, n - mid);

            // Recursively sort both subarrays
            mergeSort(left);
            mergeSort(right);

            // Merge the sorted subarrays into the original array
            merge(input, left, right);

            mergeCount++;
        }
    }
    // Merges two sorted subarrays into the input array
    private static void merge(double[] input, double[] left, double[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }

        // Copy remaining elements from the left subarray, if any
        while (i < left.length) {
            input[k++] = left[i++];
        }
        // Copy remaining elements from the right subarray, if any
        while (j < right.length) {
            input[k++] = right[j++];
        }
    }
}
