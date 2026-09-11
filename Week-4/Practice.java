import java.util.*;

public class Practice {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== WEEK 4 ASSIGNMENT =====");
            System.out.println("1. Two Sum");
            System.out.println("2. Best Time to Buy and Sell Stock");
            System.out.println("3. Contains Duplicate");
            System.out.println("4. Merge Two Sorted Arrays");
            System.out.println("5. Rotate Array");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
 
            switch (choice) {

                case 1:
                    twoSumQuestion();
                    break;

                case 2:
                    maxProfitQuestion();
                    break;

                case 3:
                    containsDuplicateQuestion();
                    break;

                case 4:
                    mergeSortedArraysQuestion();
                    break;

                case 5:
                    rotateArrayQuestion();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    // ==========================================
    // L1. TWO SUM
    // ==========================================

    static void twoSumQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }

    static int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] + nums[j] == target) {

                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }


    // ==========================================
    // L2. BEST TIME TO BUY AND SELL STOCK
    // ==========================================

    static void maxProfitQuestion() {

        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int result = maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }

    static int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int profit = prices[i] - minPrice;

            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }


    // ==========================================
    // L3. CONTAINS DUPLICATE
    // ==========================================

    static void containsDuplicateQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean result = containsDuplicate(nums);

        System.out.println("Contains Duplicate: " + result);
    }

    static boolean containsDuplicate(int[] nums) {

        for (int i = 0; i < nums.length; i++) {

            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }

        return false;
    }


    // ==========================================
    // L4. MERGE TWO SORTED ARRAYS
    // ==========================================

    static void mergeSortedArraysQuestion() {

        System.out.print("Enter size of first array: ");
        int n1 = sc.nextInt();

        int[] arr1 = new int[n1];

        System.out.println("Enter first sorted array:");
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter size of second array: ");
        int n2 = sc.nextInt();

        int[] arr2 = new int[n2];

        System.out.println("Enter second sorted array:");
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] result = mergeSortedArrays(arr1, arr2);

        System.out.println("Merged Array: " +
                Arrays.toString(result));
    }

    static int[] mergeSortedArrays(int[] arr1, int[] arr2) {

        int[] result = new int[arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < arr1.length && j < arr2.length) {

            if (arr1[i] <= arr2[j]) {

                result[k] = arr1[i];
                i++;

            } else {

                result[k] = arr2[j];
                j++;
            }

            k++;
        }

        // Copy remaining elements of arr1
        while (i < arr1.length) {

            result[k] = arr1[i];
            i++;
            k++;
        }

        // Copy remaining elements of arr2
        while (j < arr2.length) {

            result[k] = arr2[j];
            j++;
            k++;
        }

        return result;
    }


    // ==========================================
    // L5. ROTATE ARRAY
    // ==========================================

    static void rotateArrayQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int[] result = rotateArray(nums, k);

        System.out.println("Rotated Array: " +
                Arrays.toString(result));
    }

    static int[] rotateArray(int[] nums, int k) {

        int n = nums.length;

        k = k % n;

        int[] newArray = new int[n];

        for (int i = 0; i < n; i++) {

            int newPosition = (i + k) % n;

            newArray[newPosition] = nums[i];
        }

        return newArray;
    }
}