import java.util.*;

public class Solver {
    protected Dictionary dictionary;
    protected Set<Node> isVisited;
    protected NodePrioQueue queue;

    public Solver() {
        this.dictionary = new Dictionary();
        this.isVisited = new HashSet<>();
        this.queue = new NodePrioQueue();
    }


}