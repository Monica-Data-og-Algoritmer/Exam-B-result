
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskOne {
    List<Double> latitudes;

    { //Filereader
        try {
            latitudes = fileReader.loadLatitudes("files/worldcities.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<Double> bubbleSorted = new ArrayList<>(latitudes);

    //Optimized bubblesort algorithm
    int optBubbleSort(List<Double> list) {
        if (list == null || list.size() <= 1) return 0; //Checks that the list is not empty before starting
        int swapCount = 0;
        int n = list.size();
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swapCount++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return swapCount;
    }

    //Non optimized bubblesort algorithm
    int notOptBubbleSort(List<Double> list) {
        if (list == null || list.size() <= 1) return 0; //Checks that the list is not empty before starting
        int swapCount = 0;
        int l = list.size();
        for (int i = 0; i < l - 1; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                if (list.get(j) > list.get(j + 1)) {
                    Collections.swap(list, j, j + 1);
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
}


