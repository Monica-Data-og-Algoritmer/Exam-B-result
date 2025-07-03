import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {
    List<Double> latitudes;
    {//Filereader
        try {
            latitudes = fileReader.loadLatitudes("files/worldcities.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    List<Double> insertionSorted = new ArrayList<>(latitudes);

    //insertion sorting algorithm
    void insertionSort(List<Double> list) {
        if (list == null || list.size() <= 1) return;
        for (int n = 1; n < list.size(); n++) {
            double key = list.get(n);
            int m = n - 1;
            while (m >= 0 && list.get(m) > key) {
                list.set(m + 1, list.get(m));
                m--;
            }
            list.set(m + 1, key);
        }
    }

}
