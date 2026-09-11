import java.util.*;

public class Assignment {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== WEEK 2 ASSIGNMENT =====");
            System.out.println("1. ATM PIN Length Validator");
            System.out.println("2. Word Reversal Encoder");
            System.out.println("3. Product Inventory CSV Parser");
            System.out.println("4. Library ISBN Normalizer & Validator");
            System.out.println("5. Stop-Word-Filtered Word Frequency Report");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    checkPinLength();
                    break;

                case 2:
                    reverseWords();
                    break;

                case 3:
                    parseInventory();
                    break;

                case 4:
                    validateISBN();
                    break;

                case 5:
                    wordFrequency();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Q1. ATM PIN Length Validator
    static void checkPinLength() {

        System.out.print("Enter PIN: ");
        String pin = sc.nextLine();

        if (pin.length() != 4) {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        } else {
            System.out.println("PIN length OK.");
        }
    }

    // Q2. Word Reversal Encoder
    static void reverseWords() {

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {

            StringBuilder reverse = new StringBuilder(words[i]);
            reverse.reverse();

            result.append(reverse);

            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        System.out.println("Reversed Sentence: " + result);
    }

    // Q3. Product Inventory CSV Parser
    static void parseInventory() {

        System.out.print("Enter inventory record: ");
        String csvLine = sc.nextLine();

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            System.out.println("Product: " + fields[0]
                    + " | SKU: " + fields[1]
                    + " | Qty: " + fields[2]);
        }
    }

    // Q4. Library ISBN Normalizer & Validator
    static void validateISBN() {

        System.out.print("Enter library code: ");
        String raw = sc.nextLine();

        String code = normalizeCode(raw);

        System.out.println(validateAndFormat(code));
    }

    static String normalizeCode(String raw) {

        raw = raw.trim();

        if (raw.length() >= 3) {
            String publisher = raw.substring(0, 3).toUpperCase();
            String remaining = raw.substring(3);

            return publisher + remaining;
        }

        return raw;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Check remaining 10 characters are digits
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String publisher = code.substring(0, 3);
        String year = code.substring(3, 7);
        String catalog = code.substring(7);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(publisher)
              .append("] YEAR: ")
              .append(year)
              .append(" | CATALOG: ")
              .append(catalog);

        return result.toString();
    }

    // Q5. Stop-Word-Filtered Word Frequency Report
    static void wordFrequency() {

        System.out.print("Enter feedback paragraph: ");
        String feedback = sc.nextLine();

        feedback = feedback.toLowerCase();

        feedback = feedback.replace(".", "")
                           .replace(",", "");

        String[] words = feedback.split("\\s+");

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stop : stopWords) {
                if (word.equals(stop)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        entries.sort((a, b) ->
                b.getValue().compareTo(a.getValue()));

        System.out.println("\nWord Frequency:");

        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}