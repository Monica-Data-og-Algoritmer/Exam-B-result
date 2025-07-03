import java.io.*;
import java.util.*;

//Class for reading and handling the text file
public class fileReader {
    public static List<Double> loadLatitudes(String filePath) throws IOException {
        List<Double> latitudes = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Skips the first line in the file(The header)
            br.readLine();

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 2) {
                    try {
                        // Removes the extra stuff around the values
                        String latitudeString = parts[2].trim().replace("\"", "");
                        double latitude = Double.parseDouble(latitudeString);

                        if (!latitudes.contains(latitude)) {
                            latitudes.add(latitude);
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing latitude value: " + e.getMessage());
                    }
                }
            }
        }
        return latitudes;
    }
}

