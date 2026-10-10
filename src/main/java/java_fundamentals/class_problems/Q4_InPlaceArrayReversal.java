package java_fundamentals.class_problems;
import java.util.Scanner;
import java.util.Arrays;
public class Q4_InPlaceArrayReversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        int left = 0, right = n - 1;
        while (left < right) {
            int temp = a[left]; a[left] = a[right]; a[right] = temp;
            left++; right--;
        }
        System.out.println(Arrays.toString(a));
    }
}