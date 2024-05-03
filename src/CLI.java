import java.util.*;

public class CLI {
    public void writeTitle(){
        System.out.println("       .--.                   .---.\n" +
                            "   .---|__|           .-.     |~~~|\n" +
                            ".--|===|--|_          |_|     |~~~|--.\n" +
                            "|  |===|  |'\\     .---!~|  .--|   |--|\n" +
                            "|%%|   |  |.'\\    |===| |--|%%|   |  |\n" +
                            "|%%|   |  |\\.'\\   |   | |__|  |   |  |\n" +
                            "|  |   |  | \\  \\  |===| |==|  |   |  |\n" +
                            "|  |   |__|  \\.'\\ |   |_|__|  |~~~|__|\n" +
                            "|  |===|--|   \\.'\\|===|~|--|%%|~~~|--|\n" +
                            "^--^---'--^    `-'`---^-^--^--^---'--'");
        System.out.println( "__        __            _   _              _     _           \n" +
                            "\\ \\      / /__  _ __ __| | | |    __ _  __| | __| | ___ _ __ \n" +
                            " \\ \\ /\\ / / _ \\| '__/ _` | | |   / _` |/ _` |/ _` |/ _ \\ '__|\n" +
                            "  \\ V  V / (_) | | | (_| | | |__| (_| | (_| | (_| |  __/ |   \n" +
                            "   \\_/\\_/ \\___/|_|  \\__,_| |_____\\__,_|\\__,_|\\__,_|\\___|_|   ");
        System.out.println("Word Ladder program using UCS, G-BFS, or A*");
        System.out.println("By: Maximilian Sulistiyo 13522061");
    }

    public String readWord(String type, Dictionary dictionary, Scanner scanner){
        String word = "";
        boolean valid = false;
        while(!valid){
            System.out.print("Enter "+ type + " word: ");
            word = scanner.nextLine().trim();
            if(dictionary.isInDictionary(word)){
                valid = true;
            }else{
                System.out.println("Your word is not in the dictionary, please try again !");
            }
        }
        return word;
    }

    public void run(){
        Solver solver = new Solver();
        writeTitle();
        boolean run = true;
        while(run){
            Scanner scanner = new Scanner(System.in);
            String startWord = "";
            String endWord = "";
            int choice = 0;
            long start = 0;
            long end = 0;
            try{
                startWord = readWord("start", solver.getDictionary(), scanner);
                endWord = readWord("end", solver.getDictionary(), scanner);
                if(!(startWord.length() == endWord.length())) {
                    System.out.println("Your words do not have the same length, there is no solution");
                    continue;
                }
                boolean valid = false;
                while(!valid){
                    System.out.println("Choose the Algorithm");
                    System.out.println("1. UCS");
                    System.out.println("2. G-BFS");
                    System.out.println("3. A*");
                    System.out.print("choice: ");
                    try {
                        choice = scanner.nextInt();
                        if (choice >= 1 && choice <= 3) {
                            valid = true;
                        } else {
                            System.out.println("Please enter a valid choice (1, 2, or 3).");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number (1, 2, or 3).");
                        scanner.nextLine();
                    }
                    List<String> result = new ArrayList<>();
                    start = System.currentTimeMillis();
                    result = switch (choice) {
                        case 1 -> solver.solveUCS(startWord, endWord);
                        case 2 -> solver.solveGBFS(startWord, endWord);
                        case 3 -> solver.solveAStar(startWord, endWord);
                        default -> new ArrayList<>();
                    };
                    end = System.currentTimeMillis();

                    if(!result.isEmpty()){
                        System.out.println("Path found:");
                        result.forEach(System.out::println);
                        System.out.println("Runtime: " + (end-start) + "ms");
                    }else{
                        System.out.println("No path found");
                    }
                }

            }catch (NoSuchElementException e) {
                System.out.println("No input");
            } catch (IllegalStateException e) {
                System.out.println("Error occured, scanner closed.");
            } finally {
                scanner.close();
            }
            run = false;
        }
    }
}
