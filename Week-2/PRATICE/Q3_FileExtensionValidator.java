import java.util.Scanner;

public class Q3_FileExtensionValidator {

    static void validateFile(String fileName) {

        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            System.out.println("Rejected");
            return;
        }

        String extension = fileName.substring(dotIndex + 1);

        if (extension.equalsIgnoreCase("pdf")
                || extension.equalsIgnoreCase("docx")
                || extension.equalsIgnoreCase("zip")) {

            System.out.println("Accepted");

        } else {
            System.out.println("Rejected");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String fileName = sc.nextLine();

        validateFile(fileName);

        sc.close();
    }
}