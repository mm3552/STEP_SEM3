package java_fundamentals.assigment_problems;
public class Q2_ClassAttendanceTracker {
    static void attendanceSummary(int[] days) {
        int present = 0, current = 0, longest = 0;
        for (int day : days) {
            if (day == 1) {
                present++;
                current++;
                if (current > longest) longest = current;
            } else {
                current = 0;
            }
        }
        System.out.println("Present: " + present + ", Longest streak: " + longest);
    }
    public static void main(String[] args) {
        attendanceSummary(new int[]{1, 1, 0, 1, 1, 1, 0, 1});
        attendanceSummary(new int[]{0, 0, 0});
    }
}