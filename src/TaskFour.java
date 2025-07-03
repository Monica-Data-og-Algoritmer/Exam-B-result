import java.io.IOException;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class TaskFour {

    public static int comparisonCount = 0;

    // Enum for picot strategies
    public enum PivotStrategy {
        FIRST,
        LAST,
        RANDOM
    }

    // Recursively sorts the array using QuickSort with the specific pivot strategies
    public static void quickSortRecursive(double[] arr, int low, int high, PivotStrategy strategy) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high, strategy);
            quickSortRecursive(arr, low, pivotIndex - 1, strategy);
            quickSortRecursive(arr, pivotIndex + 1, high, strategy);
        }
    }

    // Partitions the array around a pivot and returns the pivot's final index
    private static int partition(double[] arr, int low, int high, PivotStrategy strategy) {
        int pivotIndex = choosePivotIndex(low, high, strategy);

        swap(arr, low, pivotIndex);
        double pivot = arr[low];
        int i = low + 1;

        for (int j = low; j <= high; j++) {
            comparisonCount++;
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    // Choose the pivot index based on the given strategy
    private static int choosePivotIndex(int low, int high, PivotStrategy strategy) {
        switch (strategy) {
            case FIRST:
                return low;
            case LAST:
                return high;
            case RANDOM:
                return low + (int) (Math.random() * (high - low+ 1));
            default:
                return low;
        }
    }

    // Swaps two elements in the array
    private static void swap(double[] arr, int a, int b) {
        double temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    // Resets the comparison counter to zero
    static void resetComparisonCount() {
        comparisonCount = 0;
    }
}

