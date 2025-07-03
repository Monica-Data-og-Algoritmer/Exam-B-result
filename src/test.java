import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class test {
    TaskOne taskOne = new TaskOne();
    TaskTwo taskTwo = new TaskTwo();
    TaskThree taskThree = new TaskThree();
    TaskFour taskFour = new TaskFour();



    void printBubbleSortResult(Function<List<Double>, Integer> sortMethod, String sortType) {
        List<Double> copyList = new ArrayList<>(taskOne.bubbleSorted); // Beholder originaldata
        long startTime = System.nanoTime();
        int bubbleSwaps = sortMethod.apply(copyList); // Bruker metoden som sendes inn som parameter
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Number of swaps (" + sortType + "): " + bubbleSwaps);
        System.out.println("Latitudes after " + sortType + " Bubble Sort:");
        for (Double latitude : copyList) {
            System.out.println(latitude);
        }
        System.out.println(sortType + " Bubble Sort took " + duration + " nanoseconds");
    }

    // Metoder for å kalle sorteringene
    void printNonOptimizedBubbleSort() {
        printBubbleSortResult(taskOne::notOptBubbleSort, "Non-Optimized");
    }

    void printOptimizedBubbleSort() {
        printBubbleSortResult(taskOne::optBubbleSort, "Optimized");
    }


    // Method printing the sorted list and calculate the time used
    void printInsert() {
        System.out.println("************************************************************");

        long startTime = System.nanoTime();
        taskTwo.insertionSort(taskTwo.insertionSorted);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Latitudes after insertion sort:");
        for (Double latitude : taskTwo.insertionSorted) {
            System.out.println(latitude);
        }

        System.out.println("the Insertion sort took " + duration + " nanoseconds");
    }

    // Converts the loaded data, runs merge sort and prints the result
    public void mergeSortAndPrint() {

        List<Double> latitudes;

        {
            // Instance initializer that loads latitudes from the dataset
            try {
                latitudes = fileReader.loadLatitudes("files/worldcities.csv");
            } catch (IOException e) {
                throw new RuntimeException("Error loading file: " + e.getMessage(), e);
            }
        }

        // Convert List<Double> to a primitive double[] array using for-loop
        double[] latitudesArray = new double[latitudes.size()];
        for (int i = 0; i < latitudes.size(); i++) {
            latitudesArray[i] = latitudes.get(i);
        }
        // Reset the merge operation counter
        TaskThree.mergeCount = 0;

        // Record the start time in nanoseconds
        long startTime = System.nanoTime();

        // Perform the merge sort on the latitude array
        TaskThree.mergeSort(latitudesArray);

        // Record the end time in nanoseconds and calculate duration
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        // Prints the sorted latitudes, number of merges and merge-time.
        System.out.println("Sorted latitudes: " + Arrays.toString(latitudesArray));
        System.out.println("Number of merge-operations: " + taskThree.mergeCount);
        System.out.println("Total merge time: " + duration + "ns");
    }

    // Converts the loaded data, prompts for a pivot strategy, sorts with QuickSort and prints the result
    public void quickSortAndPrint() {
        List<Double> latitudes;

        // Leser inn latitudes fra filen
        try {
            latitudes = fileReader.loadLatitudes("files/worldcities.csv");
        } catch (IOException e) {
            throw new RuntimeException("Error loading file: " + e.getMessage(), e);
        }

        // Konverterer List<Double> til primitivt double[]-array
        double[] latitudesArray = new double[latitudes.size()];
        for (int i = 0; i < latitudes.size(); i++) {
            latitudesArray[i] = latitudes.get(i);
        }

        // Brukeren velger pivot-strategi
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose pivot strategy:");
        System.out.println("1 - FIRST element as pivot");
        System.out.println("2 - LAST element as pivot");
        System.out.println("3 - RANDOM element as pivot");
        int choice = scanner.nextInt();

        TaskFour.PivotStrategy strategy;
        if (choice == 1) {
            strategy = TaskFour.PivotStrategy.FIRST;
        } else if (choice == 2) {
            strategy = TaskFour.PivotStrategy.LAST;
        } else if (choice == 3) {
            strategy = TaskFour.PivotStrategy.RANDOM;
        } else {
            System.out.println("Invalid choice. Using FIRST as default.");
            strategy = TaskFour.PivotStrategy.FIRST;
        }

        // Resetter sammenligningsteller før sortering
        taskFour.resetComparisonCount();

        // Kjør QuickSort med valgt pivot-strategi
        taskFour.quickSortRecursive(latitudesArray, 0, latitudesArray.length - 1, strategy);

        // Printer resultatene
        System.out.println("Sorted latitudes: " + Arrays.toString(latitudesArray));
        System.out.println("Pivot Strategy: " + strategy);
        System.out.println("Number of Comparisons: " + taskFour.comparisonCount);
    }
}

