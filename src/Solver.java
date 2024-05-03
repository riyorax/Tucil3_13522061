import java.util.*;

public class Solver {
    protected Dictionary dictionary;
    protected Set<String> isVisited;
    protected NodePrioQueue queue;

    public Solver() {
        this.dictionary = new Dictionary();
        this.isVisited = new HashSet<>();
        this.queue = new NodePrioQueue();
    }

    public List<String> solveUCS(String startWord, String endWord) {
        List<String> initPath = new ArrayList<>();
        Node startNode = new Node(startWord, 0, initPath);
        queue.addNode(startNode);
        isVisited.add(startWord);

        while(!queue.isEmpty()){
            Node currentNode = queue.remove();

            if (currentNode.getCurrentWord().equals(endWord)) {
                return currentNode.getPaths();
            }

            List<String> children = dictionary.getSimilarWords(currentNode.getCurrentWord());
            for (String child : children) {
                if (!isVisited.contains(child)) {
                    int newVal = currentNode.getValue() + 1;
                    Node newNode = new Node(child, newVal, currentNode.getPaths());
                    queue.addNode(newNode);
                    isVisited.add(child);
                }
            }
        }
        return initPath;
    }



}