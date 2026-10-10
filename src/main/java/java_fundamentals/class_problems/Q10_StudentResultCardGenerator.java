package java_fundamentals.class_problems;
import java.util.Scanner;
class ResultStudent {
    private String name;
    private int[] marks;
    ResultStudent(String name, int[] marks) { this.name = name; this.marks = marks; }
    double average() { return (marks[0] + marks[1] + marks[2]) / 3.0; }
    char grade() {
        double avg = average();
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }
    void printCard() { System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), average(), grade()); }
}
public class Q10_StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int[] marks = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
            new ResultStudent(name, marks).printCard();
        }
    }
}