import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solver UCS = new Solver();
        long startTime = System.currentTimeMillis();
        List<String> solution = UCS.solveUCS("slam", "bang");
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);
        System.out.println("Solution: " + solution);
        System.out.println("Elapsed time: " + duration + " nanoseconds");
    }
}