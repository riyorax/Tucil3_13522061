public class Node implements Comparable<Node>{
    private String currentWord;
    private int value;
    private String[] paths;

    public Node(String currentWord, int value, String[] paths) {
        this.currentWord = currentWord;
        this.value = value;
        this.paths = paths;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.value, other.value);
    }

    public String getCurrentWord() {
        return currentWord;
    }

    public int getValue() {
        return value;
    }

    public String[] getPaths() {
        return paths;
    }
}
