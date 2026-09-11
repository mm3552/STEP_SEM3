import java.util.Random;
import java.util.Scanner;

public class Practice {

    static Scanner sc = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== WEEK 1 PRACTICE ==========");
            System.out.println("1. Rock-Paper-Scissors Game");
            System.out.println("2. Palindrome Checker - 3 Approaches");
            System.out.println("3. BMI Calculator for a Team");
            System.out.println("4. First Non-Repeating Character");
            System.out.println("5. Reverse Customer Name");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    playRockPaperScissors();
                    break;

                case 2:
                    palindromeChecker();
                    break;

                case 3:
                    bmiCalculator();
                    break;

                case 4:
                    System.out.println("\n--- Question 4: First Non-Repeating Character ---");

                    System.out.print("Enter a word or sentence: ");
                    String text = sc.nextLine();

                    char result = findFirstNonRepeatingChar(text);

                    if (result == '\0') {
                        System.out.println("No Non-Repeating Character Found");
                    } else {
                        System.out.println(
                                "First Non-Repeating Character: '" + result + "'"
                        );
                    }

                    break;

                case 5:
                    System.out.println("\n--- Question 5: Reverse Customer Name ---");

                    System.out.print("Enter customer name: ");
                    String customerName = sc.nextLine();

                    String reversedName = reverseCustomerName(customerName);

                    System.out.println("Original Name: " + customerName);
                    System.out.println("Reversed Name: " + reversedName);

                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ============================================================
    // QUESTION 1
    // Rock-Paper-Scissors Game
    // ============================================================

    static void playRockPaperScissors() {

        System.out.println("\n--- Question 1: Rock-Paper-Scissors ---");

        int rounds = 5;

        String[] playerMoves = new String[rounds];
        String[] computerMoves = new String[rounds];
        String[] results = new String[rounds];

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < rounds; i++) {

            System.out.println("\nRound " + (i + 1));
            System.out.print("Enter Rock, Paper, or Scissors: ");

            String playerMove = sc.nextLine();

            playerMove = formatMove(playerMove);

            if (!isValidMove(playerMove)) {

                System.out.println("Invalid move. Please try again.");
                i--;
                continue;
            }

            String[] moves = {"Rock", "Paper", "Scissors"};

            String computerMove = moves[random.nextInt(3)];

            String result = playRound(playerMove, computerMove);

            playerMoves[i] = playerMove;
            computerMoves[i] = computerMove;
            results[i] = result;

            System.out.println("Player: " + playerMove);
            System.out.println("Computer: " + computerMove);
            System.out.println("Result: " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = ((double) wins / rounds) * 100;

        System.out.println("\n========== FINAL SUMMARY ==========");

        System.out.printf(
                "%-8s %-15s %-15s %-18s%n",
                "Round",
                "Player Move",
                "Computer Move",
                "Result"
        );

        for (int i = 0; i < rounds; i++) {

            System.out.printf(
                    "%-8d %-15s %-15s %-18s%n",
                    i + 1,
                    playerMoves[i],
                    computerMoves[i],
                    results[i]
            );
        }

        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", winPercentage);
    }

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if (
                (playerMove.equals("Rock") && computerMove.equals("Scissors"))
                        || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                        || (playerMove.equals("Scissors") && computerMove.equals("Paper"))
        ) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    static String formatMove(String move) {

        move = move.trim().toLowerCase();

        if (move.equals("rock")) {
            return "Rock";
        }

        if (move.equals("paper")) {
            return "Paper";
        }

        if (move.equals("scissors")) {
            return "Scissors";
        }

        return move;
    }

    static boolean isValidMove(String move) {

        return move.equals("Rock")
                || move.equals("Paper")
                || move.equals("Scissors");
    }

    // ============================================================
    // QUESTION 2
    // Palindrome Checker - 3 Approaches
    // ============================================================

    static void palindromeChecker() {

        System.out.println("\n--- Question 2: Palindrome Checker ---");

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        boolean iterative = isPalindromeIterative(text);
        boolean recursive = isPalindromeRecursive(text);
        boolean arrayReversal = isPalindromeArrayReversal(text);

        System.out.println(
                "Iterative: "
                        + (iterative ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Recursive: "
                        + (recursive ? "Palindrome" : "Not Palindrome")
        );

        System.out.println(
                "Array Reversal: "
                        + (arrayReversal ? "Palindrome" : "Not Palindrome")
        );

        if (iterative == recursive && recursive == arrayReversal) {
            System.out.println("All three approaches agree.");
        }
    }

    // Approach 1: Iterative

    static boolean isPalindromeIterative(String text) {

        int left = 0;
        int right = text.length() - 1;

        while (left < right) {

            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    // Approach 2: Recursive

    static boolean isPalindromeRecursive(String text) {

        return palindromeRecursiveHelper(text, 0, text.length() - 1);
    }

    static boolean palindromeRecursiveHelper(
            String text,
            int left,
            int right
    ) {

        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return palindromeRecursiveHelper(
                text,
                left + 1,
                right - 1
        );
    }

    // Approach 3: Array Reversal

    static boolean isPalindromeArrayReversal(String text) {

        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];

        for (int i = 0; i < original.length; i++) {

            reversed[i] = original[original.length - 1 - i];
        }

        for (int i = 0; i < original.length; i++) {

            if (original[i] != reversed[i]) {
                return false;
            }
        }

        return true;
    }

    // ============================================================
    // QUESTION 3
    // BMI Calculator for a Team
    // ============================================================

    static void bmiCalculator() {

        System.out.println("\n--- Question 3: BMI Calculator ---");

        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        double[] heights = new double[n];
        double[] weights = new double[n];

        for (int i = 0; i < n; i++) {

            System.out.print(
                    "Enter height for Person "
                            + (i + 1)
                            + " (m): "
            );

            heights[i] = sc.nextDouble();

            System.out.print(
                    "Enter weight for Person "
                            + (i + 1)
                            + " (kg): "
            );

            weights[i] = sc.nextDouble();
        }

        printWellnessReport(heights, weights);
    }

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(
            double[] heights,
            double[] weights
    ) {

        System.out.println("\n========== WELLNESS REPORT ==========");

        System.out.printf(
                "%-10s %-15s %-15s %-10s %-15s%n",
                "Person",
                "Height (m)",
                "Weight (kg)",
                "BMI",
                "Status"
        );

        for (int i = 0; i < heights.length; i++) {

            double bmi =
                    weights[i] / (heights[i] * heights[i]);

            String status = getBmiStatus(bmi);

            System.out.printf(
                    "%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status
            );
        }
    }

    // ============================================================
    // QUESTION 4
    // First Non-Repeating Character
    // ============================================================

    static char findFirstNonRepeatingChar(String text) {

        int[] frequency = new int[Character.MAX_VALUE + 1];

        // Count frequency
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);
            frequency[ch]++;
        }

        // Find first character with frequency 1
        for (int i = 0; i < text.length(); i++) {

            char ch = text.charAt(i);

            if (frequency[ch] == 1) {
                return ch;
            }
        }

        return '\0';
    }

    // ============================================================
    // QUESTION 5
    // Reverse Customer Name
    // ============================================================

    static String reverseCustomerName(String customerName) {

        char[] characters = customerName.toCharArray();

        String reversed = "";

        for (int i = characters.length - 1; i >= 0; i--) {

            reversed += characters[i];
        }

        return reversed;
    }
}