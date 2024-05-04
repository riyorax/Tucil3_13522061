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
        System.out.println("Word Ladder autocomplete search using UCS, G-BFS, or A*");
        System.out.println("By: Maximilian Sulistiyo 13522061\n");
    }

    public void writeEnding(){
        System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣤⣀⢠⡤⠤⠖⠒⠒⠒⠲⣆⠀⠀⠀⠀⣾⠋⠉⠉⠛⢷⠀⣴⠖⠒⠤⣄⠀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣤⠤⠶⢺⣾⣏⠁⠀⠀⣧⣼⣇⣀⠀⠀⠀⡀⠀⠘⡆⠀⠀⢰⣏⠀⠀⠀⠀⠘⣿⡟⠀⠀⢠⢃⣼⡏⠉⠙⢳⡆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⣀⡤⠴⠒⠋⠙⣇⣿⠀⠀⠀⣿⣿⠀⠀⠀⢸⣿⣿⣿⠃⠀⢰⣿⡀⠀⠹⡄⠀⢸⣿⠀⠀⠀⠀⠀⢹⡇⠀⠀⢸⡿⣽⠀⠀⠀⡜⠀⣀⡤⠖⠓⠢⢤⣀⠀\n" +
                "⣠⡴⠒⠉⠁⠀⠀⠀⠀⠀⠸⣿⡇⠀⠀⠘⠛⠃⠀⠀⠈⡟⠉⣿⠀⠀⠘⠛⠃⠀⠀⢷⠀⢸⣿⠀⠀⢠⡀⠀⠀⠀⠀⠀⣿⢧⡇⠀⠀⠸⠗⠚⠁⠀⠀⠀⣀⣠⣾⠃\n" +
                "⣿⡇⠀⠀⠀⠀⠀⠀⣶⣶⣿⢿⢹⠀⠀⠀⢀⣀⠀⠀⠀⢳⠀⣿⠀⠀⢀⣀⣤⠀⠀⠘⣇⢸⡏⠀⠀⢸⣧⠀⠀⠀⠀⢸⣿⡿⠀⠀⢀⠀⠀⠀⢀⣤⣶⣿⠿⠛⠁⠀\n" +
                "⢧⣹⣶⣾⣿⡄⠀⠀⠸⡟⠋⠘⡜⡆⠀⠀⢻⣿⡇⠀⠀⢸⡀⣿⠀⠀⢸⣿⡿⡇⠀⠀⢸⣿⡇⠀⠀⢸⡿⡆⠀⠀⠀⣾⣿⠃⠀⠀⣾⡇⠀⠀⠈⡟⠉⠀⠀⠀⠀⠀\n" +
                "⠘⣿⡿⠿⢿⣧⠀⠀⠀⢳⡀⠀⣇⢱⠀⠀⠈⣿⣷⠀⣀⣸⣷⣿⣤⣤⣼⠋⣇⣹⣶⣶⣾⣿⡿⢲⣶⣾⡇⣿⣤⣀⣀⣿⡏⠀⠀⣼⡏⢧⠀⠀⠀⣇⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠸⡞⣇⠀⠀⠀⢧⠀⢸⣈⣷⣶⣶⣿⣿⣿⣿⣿⣿⣿⣽⣿⡏⢀⡼⠟⠛⠻⢿⡿⠿⠿⣿⣁⣿⣿⣿⣿⣿⣿⣿⣶⣴⢿⠁⢸⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢹⣼⣦⣤⣶⣿⠁⣀⣿⠿⠿⣿⣫⣿⠉⠁⠀⠀⠀⡏⠀⣴⠏⠀⠀⠀⠀⠀⠹⣆⠀⢠⣿⠀⠀⠀⢈⠟⢻⡿⠿⣅⣘⡆⣸⣇⠀⠀⢸⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠻⠿⠿⠛⠃⢠⣿⣷⣄⠀⠈⠙⠋⠀⠀⠀⠀⣸⢁⡾⠁⠀⠀⣠⣤⡀⠀⠀⠸⣤⡞⡇⠀⠀⠀⢸⣰⣿⠃⠀⠀⢹⣿⣿⣿⣿⣦⣼⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⢿⣿⣿⣷⣄⠀⠀⠀⠀⠀⠀⣿⣾⠇⠀⠀⣸⣿⣿⢿⠀⠀⠀⣿⢁⡇⠀⠀⢀⣿⣿⡏⠀⠀⠀⡼⠀⢙⣿⠛⠻⣏⡀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣿⣿⣷⠀⠀⠀⠀⢸⡿⡿⠀⠀⠀⡏⢹⠟⡟⠀⠀⠀⡿⢸⠀⠀⠀⢸⣿⡿⠀⠀⠀⢠⠇⡰⢋⡏⠀⠀⠀⢙⡆⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⡿⡿⠀⠀⠀⠀⣸⡇⡇⠀⠀⠀⠻⠾⠞⠁⠀⠀⢀⡇⡏⠀⠀⠀⢸⣿⠃⠀⠀⠀⡼⣰⠃⡞⠀⠀⠀⠀⡾⠁⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡇⡇⠀⠀⠀⠀⣿⣇⣷⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣃⡇⠀⠀⠀⠀⠀⠀⠀⠀⣼⣷⠃⣼⡀⠀⠀⢀⡞⠁⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⢸⠃⠀⠀⠀⢀⡇⢿⣿⣧⣀⠀⠀⠀⠀⠀⣠⣾⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⣸⣿⣿⣿⣽⣿⣷⣤⡞⠁⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣼⣤⣶⣶⣶⡿⠁⠈⢿⣿⣿⣿⣿⣿⣿⣿⠿⠃⢸⣿⣿⣷⣤⣄⣀⣀⣤⣾⣏⣤⡟⠁⠀⠈⠻⡍⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⠿⠿⠿⠟⠛⠁⠀⠀⠀⠉⠛⠛⠛⠛⠉⠁⠀⠀⠀⠙⠿⢿⣿⣿⡿⠿⠋⢀⣿⣿⣧⡀⠀⠀⣠⡇⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢿⣿⣿⣿⣿⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
    }

    public void writeSameLetter(String word, String endWord){
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == endWord.charAt(i)) {
                System.out.print("\u001B[32m" + word.charAt(i) + "\u001B[0m");
            } else {
                System.out.print(word.charAt(i));
            }
        }
        System.out.println();
    }

    public String readWord(String type, Dictionary dictionary, Scanner scanner){
        String word = "";
        boolean valid = false;
        while(!valid){
            System.out.print("Enter "+ type + " word: ");
            word = scanner.nextLine().trim().toLowerCase();
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
        boolean run = true;
        Scanner scanner = new Scanner(System.in);
        while(run){
            writeTitle();
            int choice = 0;
            long start = 0;
            long end = 0;
            try{
                String startWord = "";
                String endWord = "";
                startWord = readWord("start", solver.getDictionary(), scanner);
                endWord = readWord("end", solver.getDictionary(), scanner);
                if(!(startWord.length() == endWord.length())) {
                    System.out.println("Your words do not have the same length, there is no solution");
                    System.out.print("Do you want to try again? (Default Y) (y/n): ");
                    String tryAgain = scanner.nextLine().trim().toLowerCase();
                    if(tryAgain.equals("n")){
                        run = false;
                    }
                    continue;
                }
                boolean valid = false;
                while(!valid){
                    System.out.println("Choose the Algorithm");
                    System.out.println("1. UCS");
                    System.out.println("2. G-BFS");
                    System.out.println("3. A*");
                    try {
                        System.out.print("Choice: ");
                        choice = scanner.nextInt();
                        if (choice >= 1 && choice <= 3) {
                            valid = true;
                        } else {
                            System.out.println("Please enter a valid choice between 1-3 -_-");
                            continue;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Please enter a number -_-");
                    }
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
                    for (String word : result) {
                        writeSameLetter(word, endWord);
                    }
                    System.out.println("Node traversed: " + solver.getNodeTraversed());
                    System.out.println("Runtime: " + (end-start) + "ms");
                }else{
                    System.out.println("No path found");
                }

            }catch (NoSuchElementException e) {
                System.out.println("No input");
            } catch (IllegalStateException e) {
                System.out.println("Error occured, scanner closed.");
            }
            System.out.print("Do you want to exit? (Default n) (y/n): ");
            String exit = scanner.nextLine().trim().toLowerCase();
            if(exit.equals("y")){
                writeEnding();
                scanner.close();
                run = false;
            }
       }
    }
}
