    import java.util.Scanner;

public class Q5_BankTransactionValidator {

    static String normalizeReference(String raw) {

        String code = raw.trim();

        if (code.length() < 3) {
            return code;
        }

        String bank = code.substring(0, 3).toUpperCase();
        String remaining = code.substring(3);

        return bank + remaining;
    }

    static String validateAndFormat(String code) {

        if (code.length() != 14) {
            return "Invalid: wrong length";
        }

        // Check first 3 characters are letters
        for (int i = 0; i < 3; i++) {

            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: first 3 characters must be letters";
            }
        }

        // Check remaining characters are digits
        for (int i = 3; i < 14; i++) {

            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: remaining characters must be digits";
            }
        }

        StringBuilder result = new StringBuilder();

        result.append("[")
              .append(code.substring(0, 3))
              .append("] DATE: ")
              .append(code.substring(3, 9))
              .append(" | SEQ: ")
              .append(code.substring(9, 14));

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter transaction reference: ");
        String raw = sc.nextLine();

        String normalized = normalizeReference(raw);

        System.out.println(validateAndFormat(normalized));

        sc.close();
    }
}