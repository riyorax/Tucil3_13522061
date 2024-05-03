import java.util.*;
import java.io.*;

public class Dictionary {

    private List<String> words;
    private Map<String, List<String>> patternMap;

    public Dictionary() {
        this.words = createWordList();
        this.patternMap = createPatternMap();
    }

    public List<String> createWordList(){
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

    public List<String> getWords(){
        return this.words;
    }

    public Map<String, List<String>> getPatternMap(){
        return this.patternMap;
    }

    public List<String> getSimilarWords(String originWord){
        List<String> similarWords = new ArrayList<>();
        for (int i = 0; i < originWord.length(); i++) {
            String pattern = originWord.substring(0, i) + "*" + originWord.substring(i + 1);
            List<String> words = this.patternMap.getOrDefault(pattern, new ArrayList<>());
            for (String word : words) {
                if (!word.equals(originWord)) {
                    similarWords.add(word);
                }
            }
        }
        return similarWords;
    }

    public int getLetterDifference(String word1, String word2){
        int difference = 0;
        for(int i = 0; i < word1.length(); i++){
            if(word1.charAt(i) != word2.charAt(i)){
                difference++;
            }
        }
        return difference;
    }
}
