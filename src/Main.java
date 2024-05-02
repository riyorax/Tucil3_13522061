import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Map<String, List<String>> patternMap = dictionary.createPatternMap();

        File file = new File("output.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            patternMap.forEach((key, value) -> {
                try {
                    writer.write(key + " -> " + value);
                    writer.newLine();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}