import java.util.Scanner;

public class Practice {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== WEEK 2 PRACTICE =====");
            System.out.println("1. Vowel & Consonant Counter");
            System.out.println("2. CSV Student Record Parser");
            System.out.println("3. File Extension Validator");
            System.out.println("4. Masked Phone Number Formatter");
            System.out.println("5. Bank Transaction Reference Generator & Validator");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    countVowelsAndConsonants();
                    break;

                case 2:
                    parseStudentRecord();
                    break;

                case 3:
                    validateFile();
                    break;

                case 4:
                    maskPhone();
                    break;

                case 5:
                    validateTransaction();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Q1. Vowel & Consonant Counter
    static void countVowelsAndConsonants() {

        System.out.print("Enter text: ");
        String text = sc.nextLine();

        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < text.length(); i++) {

            char ch = Character.toLowerCase(text.charAt(i));

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {

                vowels++;

            } else if (ch >= 'a' && ch <= 'z') {

                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels
                + " | Consonants: " + consonants);
    }

    // Q2. CSV Student Record Parser
    static void parseStudentRecord() {

        System.out.print("Enter student record: ");
        String csvLine = sc.nextLine();

        String[] fields = csvLine.split(",");

        if (fields.length != 3) {

            System.out.println("Invalid Record");

        } else {

            System.out.println("Name: " + fields[0]
                    + " | Roll No: " + fields[1]
                    + " | Dept: " + fields[2]);
        }
    }

    // Q3. File Extension Validator
    static void validateFile() {

        System.out.print("Enter filename: ");
        String filename = sc.nextLine();

        String result = validateFileExtension(filename);

        System.out.println(result);
    }

    static String validateFileExtension(String filename) {

        int dotPosition = filename.lastIndexOf('.');

        if (dotPosition == -1 || dotPosition == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(dotPosition + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            return "Accepted";
        }

        return "Rejected — invalid file type";
    }

    // Q4. Masked Phone Number Formatter
    static void maskPhone() {

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        String result = maskPhoneNumber(phone);

        System.out.println(result);
    }

    static String maskPhoneNumber(String phone) {

        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        for (int i = 0; i < phone.length(); i++) {

            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        String lastFour = phone.substring(6);

        StringBuilder masked = new StringBuilder("XXXXXX");

        masked.append("-").append(lastFour);

        return masked.toString();
    }

    // Q5. Bank Transaction Reference Generator & Validator
    static void validateTransaction() {

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String reference = normalizeReference(raw);

        System.out.println(validateAndFormat(reference));
    }

    static String normalizeReference(String raw) {

        raw = raw.trim();

        if (raw.length() >= 3) {

            String bankCode = raw.substring(0, 3).toUpperCase();
            String remaining = raw.substring(3);

            return bankCode + remaining;
        }

        return raw;
    }

    static String validateAndFormat(String reference) {

        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Check remaining 11 characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: body must contain only digits";
            }
        }

        String bankCode = reference.substring(0, 3);
        String date = reference.substring(3, 9);
        String sequence = reference.substring(9);

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(bankCode)
              .append("] DATE: ")
              .append(date.substring(0, 2))
              .append("/")
              .append(date.substring(2, 4))
              .append("/")
              .append(date.substring(4, 6))
              .append(" | SEQ: ")
              .append(sequence);

        return result.toString();
    }
}