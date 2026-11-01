package data_structures.assigment_problems;
import java.util.Arrays;
import java.util.Scanner;

public class Q5_DiceThrowTally {
    static int[] diceSort(int[] rolls) {
        int[] count = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                count[roll]++;
            }
        }
        int[] sorted = new int[rolls.length];
        int index = 0;
        for (int value = 1; value <= 6; value++) {
            for (int j = 0; j < count[value]; j++) {
                sorted[index] = value;
                index++;
            }
        }
        return sorted;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] rolls = new int[n];
        for (int i = 0; i < n; i++) {
            rolls[i] = sc.nextInt();
        }
        int[] counts = new int[7];
        for (int roll : rolls) {
            if (roll >= 1 && roll <= 6) {
                counts[roll]++;
            }
        }
        System.out.print("Counts: ");
        for (int i = 1; i <= 6; i++) {
            System.out.print(i + ":" + counts[i] + (i < 6 ? "  " : ""));
        }
        System.out.println();
        System.out.println("Sorted: " + Arrays.toString(diceSort(rolls)));
    }
}