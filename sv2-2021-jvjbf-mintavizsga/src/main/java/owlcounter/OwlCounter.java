package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class OwlCounter {
    private List<String> numberOfOwls;

    public void readFromFile(Path path) {
        try {
            numberOfOwls = Files.readAllLines(path);
        } catch (IOException e) {
            throw new IllegalStateException("Can not read file.");
        }
    }

    public int getNumberOfOwls(String county) {
        for (String s : numberOfOwls) {
            String[] parts = s.split("=");
            if (s.startsWith(county) && parts[0].equals(county)) {
                return Integer.parseInt(parts[1]);
            }
        }
        throw new IllegalArgumentException("No such county in Hungary!");
    }

    public int getNumberOfAllOwls() {
        int sum = 0;
        for (String s : numberOfOwls) {
            sum += Integer.parseInt(s.split("=")[1]);
        }
        return sum;
    }
}
