import java.util.Scanner;

public class Assignment {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== WEEK 1 ASSIGNMENT ==========");
            System.out.println("1. Seat Duplication Checker");
            System.out.println("2. Typing Accuracy Checker");
            System.out.println("3. Traffic Signal Streak Analyzer");
            System.out.println("4. Warehouse Inventory Balancer");
            System.out.println("5. Movie Review Word Length Profiler");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    seatDuplication();
                    break;

                case 2:
                    typingAccuracy();
                    break;

                case 3:
                    trafficSignal();
                    break;

                case 4:
                    warehouseInventory();
                    break;

                case 5:
                    movieReview();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // ==================================================
    // QUESTION 1: SEAT DUPLICATION CHECKER
    // ==================================================

    static void seatDuplication() {

        System.out.println("\n--- Seat Duplication Checker ---");

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] seats = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seats[i] = sc.nextInt();
        }

        boolean duplicate = false;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (seats[i] == seats[j]) {

                    System.out.println(
                            "Duplicate Seat Number Found: " + seats[i]
                    );

                    duplicate = true;
                }
            }
        }

        if (!duplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    // ==================================================
    // QUESTION 2: TYPING ACCURACY CHECKER
    // ==================================================

    static void typingAccuracy() {

        System.out.println("\n--- Typing Accuracy Checker ---");

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        int matched = 0;
        int firstMismatch = -1;

        for (int i = 0; i < original.length(); i++) {

            if (original.charAt(i) == typed.charAt(i)) {

                matched++;

            } else {

                if (firstMismatch == -1) {
                    firstMismatch = i;
                }
            }
        }

        double accuracy =
                ((double) matched / original.length()) * 100;

        System.out.printf(
                "Matched: %d/%d%n",
                matched,
                original.length()
        );

        System.out.printf(
                "Accuracy: %.2f%%%n",
                accuracy
        );

        if (firstMismatch == -1) {

            System.out.println("No Mismatches");

        } else {

            System.out.println(
                    "First Mismatch at position "
                            + (firstMismatch + 1)
                            + " ('"
                            + original.charAt(firstMismatch)
                            + "' vs '"
                            + typed.charAt(firstMismatch)
                            + "')"
            );
        }
    }

    // ==================================================
    // QUESTION 3: TRAFFIC SIGNAL STREAK
    // ==================================================

    static void trafficSignal() {

        System.out.println("\n--- Traffic Signal Streak Analyzer ---");

        System.out.print("Enter signal log (R/Y/G): ");
        String signal = sc.nextLine();

        int currentStreak = 1;
        int longestStreak = 1;

        char longestColor = signal.charAt(0);

        for (int i = 1; i < signal.length(); i++) {

            if (signal.charAt(i) == signal.charAt(i - 1)) {

                currentStreak++;

            } else {

                currentStreak = 1;
            }

            if (currentStreak > longestStreak) {

                longestStreak = currentStreak;
                longestColor = signal.charAt(i);
            }
        }

        System.out.println(
                "Longest Streak: '"
                        + longestColor
                        + "' repeated "
                        + longestStreak
                        + " times"
        );
    }

    // ==================================================
    // QUESTION 4: WAREHOUSE INVENTORY BALANCER
    // ==================================================

    static void warehouseInventory() {

        System.out.println("\n--- Warehouse Inventory Balancer ---");

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int[] sectionA = new int[n];
        int[] sectionB = new int[n];

        System.out.println("Enter Section A quantities:");

        for (int i = 0; i < n; i++) {
            sectionA[i] = sc.nextInt();
        }

        System.out.println("Enter Section B quantities:");

        for (int i = 0; i < n; i++) {
            sectionB[i] = sc.nextInt();
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < n; i++) {

            totalA = totalA + sectionA[i];
            totalB = totalB + sectionB[i];
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);

        if (totalA == totalB) {
            System.out.println("Status: Balanced");
        } else {
            System.out.println("Status: Not Balanced");
        }

        int highest = sectionA[0];
        String highestSection = "Section A";
        int highestIndex = 0;

        for (int i = 0; i < n; i++) {

            if (sectionA[i] > highest) {

                highest = sectionA[i];
                highestSection = "Section A";
                highestIndex = i;
            }
        }

        for (int i = 0; i < n; i++) {

            if (sectionB[i] > highest) {

                highest = sectionB[i];
                highestSection = "Section B";
                highestIndex = i;
            }
        }

        System.out.println(
                "Highest Quantity: "
                        + highest
                        + " ("
                        + highestSection
                        + ", Item "
                        + (highestIndex + 1)
                        + ")"
        );
    }

    // ==================================================
    // QUESTION 5: MOVIE REVIEW WORD LENGTH PROFILER
    // ==================================================

    static void movieReview() {

        System.out.println("\n--- Movie Review Word Length Profiler ---");

        System.out.print("Enter movie review: ");
        String review = sc.nextLine();

        String[] words = review.split("\\s+");

        int shortWords = 0;
        int mediumWords = 0;
        int longWords = 0;

        for (int i = 0; i < words.length; i++) {

            int length = words[i].length();

            if (length >= 1 && length <= 4) {

                shortWords++;

            } else if (length >= 5 && length <= 8) {

                mediumWords++;

            } else {

                longWords++;
            }
        }

        System.out.println("Short: " + shortWords);
        System.out.println("Medium: " + mediumWords);
        System.out.println("Long: " + longWords);
    }
}