import java.util.*;
import java.io.*;

public class Dictionary {
    public List<String> getWords(){
        ArrayList<String> words = new ArrayList<String>();
        File dictionaryFile = new File("src/dictionary.txt");
        try{
            Scanner scan = new Scanner(dictionaryFile);
            while (scan.hasNextLine()) {
                String word = scan.nextLine().trim();
                words.add(word);
            }
            scan.close();
        }catch(FileNotFoundException e){
            System.out.println("File tidak ditemukan!!");
        }

        return words;
    }

    public Map<String, List<String>> createPatternMap(){
        Map<String, List<String>> wordPatternMap = new HashMap<>();
        List<String> words = getWords();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                wordPatternMap.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }
        return  wordPatternMap;
    }
}
