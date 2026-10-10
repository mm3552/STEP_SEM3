package java_fundamentals.assigment_problems;
public class Q1_ExamScoreBandCounter {
    static int firstAtLeast(int[] a, int target) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] >= target) r = m;
            else l = m + 1;
        }
        return l;
    }
    static int countInBand(int[] scores, int low, int high) {
        return firstAtLeast(scores, high + 1) - firstAtLeast(scores, low);
    }
    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(scores, 42, 58));
        System.out.println(countInBand(scores, 90, 100));
    }
}