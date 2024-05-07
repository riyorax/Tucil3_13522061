import java.util.*;

public class Node implements Comparable<Node>{
    private String currentWord;
    private int value;
    private List<String> paths;

    public Node(String currentWord, int value,List<String> paths){
        this.currentWord = currentWord;
        this.value = value;
        this.paths= new ArrayList<>(paths);
        this.paths.add(currentWord);
    }

    public int compareTo(Node other) {
        return Integer.compare(this.value, other.value);
    }

    public String getCurrentWord() {
        return this.currentWord;
    }

    public int getValue() {
        return this.value;
    }

    public List<String> getPaths() {
        return this.paths;
    }

}
