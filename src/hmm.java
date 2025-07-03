import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class hmm {
    TaskOne taskOne = new TaskOne();
    TaskTwo taskTwo = new TaskTwo();
    TaskThree taskThree = new TaskThree();
    TaskFour taskFour = new TaskFour();



    //Reusable method for both the bubblesort results
    void printBubbleSortResult(Function<List<Double>, Integer> sortMethod, String sortType) {
        List<Double> copyList = new ArrayList<>(taskOne.bubbleSorted);
        long startTime = System.nanoTime();
        int bubbleSwaps = sortMethod.apply(copyList);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);

        System.out.println("Number of swaps (" + sortType + "): " + bubbleSwaps);
        System.out.println("Latitudes after " + sortType + " Bubble Sort:");
        for (Double latitude : copyList) {
            System.out.println(latitude);
        }
        System.out.println(sortType + " Bubble Sort took " + duration + " nanoseconds");
    }

    // Methodes to call for the sorting
    void printNonOptimizedBubbleSort() {
        printBubbleSortResult(taskOne::notOptBubbleSort, "Non-Optimized");
    }

    void printOptimizedBubbleSort() {
        printBubbleSortResult(taskOne::optBubbleSort, "Optimized");
    }
}