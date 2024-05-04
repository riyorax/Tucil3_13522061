import java.util.*;

public class Solver {
    private Dictionary dictionary;;
    private NodePrioQueue queue;
    private int nodeTraversed;

    public Solver() {
        this.dictionary = new Dictionary();
        this.queue = new NodePrioQueue();
        this.nodeTraversed = 0;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public int getNodeTraversed() {
        return nodeTraversed;
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

    public int gN(Node node, String childWord){
        return node.getValue() + 1;
    }

    public int hN(String currentWord, String endWord){
        return getLetterDifference(currentWord, endWord);
    }

    public int fN(Node node, String currentWord, String endWord){
        return gN(node, currentWord) + hN(currentWord, endWord);
    }

    public List<String> solveUCS(String startWord, String endWord) {
        this.nodeTraversed = 0;
        List<String> initPath = new ArrayList<>();
        Set<String>isVisited = new HashSet<>();
        Node startNode = new Node(startWord, 0, initPath);
        queue.addNode(startNode);
        isVisited.add(startWord);

        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            this.nodeTraversed++;

            if (currentNode.getCurrentWord().equals(endWord)) {
                return currentNode.getPaths();
            }

            List<String> children = dictionary.getSimilarWords(currentNode.getCurrentWord());
            for (String child : children) {
                if (!isVisited.contains(child)) {
                    Node newNode = new Node(child, gN(currentNode, child), currentNode.getPaths());
                    queue.addNode(newNode);
                    isVisited.add(child);
                }
            }
        }
        return initPath;
    }

    public List<String> solveGBFS(String startWord, String endWord) {
        this.nodeTraversed = 0;
        List<String> initPath = new ArrayList<>();
        Set<String>isVisited = new HashSet<>();
        Node startNode = new Node(startWord, hN(startWord, endWord), initPath);
        queue.addNode(startNode);
        isVisited.add(startWord);

        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            this.nodeTraversed++;

            if (currentNode.getCurrentWord().equals(endWord)) {
                return currentNode.getPaths();
            }

            List<String> children = dictionary.getSimilarWords(currentNode.getCurrentWord());
            for (String child : children) {
                if (!isVisited.contains(child)) {
                    Node newNode = new Node(child, hN(child, endWord), currentNode.getPaths());
                    queue.addNode(newNode);
                    isVisited.add(child);
                }
            }
        }
        return initPath;
    }

    public List<String> solveAStar(String startWord, String endWord) {
        this.nodeTraversed = 0;
        List<String> initPath = new ArrayList<>();
        Node startNode = new Node(startWord, hN(startWord, endWord), initPath);
        queue.addNode(startNode);
        Set<String>isVisited = new HashSet<>();
        isVisited.add(startWord);

        while(!queue.isEmpty()){
            Node currentNode = queue.remove();
            this.nodeTraversed++;

            if (currentNode.getCurrentWord().equals(endWord)) {
                return currentNode.getPaths();
            }

            List<String> children = dictionary.getSimilarWords(currentNode.getCurrentWord());
            for (String child : children) {
                if (!isVisited.contains(child)) {
                    Node newNode = new Node(child, fN(currentNode, child, endWord), currentNode.getPaths());
                    queue.addNode(newNode);
                    isVisited.add(child);
                }
            }
        }
        return initPath;
    }

}