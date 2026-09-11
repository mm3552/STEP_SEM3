import java.util.*;

public class Assignment {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== WEEK 4 ASSIGNMENT =====");
            System.out.println("1. Product of Array Except Self");
            System.out.println("2. Maximum Subarray");
            System.out.println("3. 3Sum");
            System.out.println("4. Subarray Sum Equals K");
            System.out.println("5. Find Minimum in Rotated Sorted Array");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    productExceptSelfQuestion();
                    break;

                case 2:
                    maxSubArrayQuestion();
                    break;

                case 3:
                    threeSumQuestion();
                    break;

                case 4:
                    subarraySumQuestion();
                    break;

                case 5:
                    findMinQuestion();
                    break;

                case 0:
                    System.out.println("Program ended.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Q1. Product of Array Except Self
    static void productExceptSelfQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] answer = productExceptSelf(nums);

        System.out.println("Output: " + Arrays.toString(answer));
    }

    static int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: product of elements on the left
        int leftProduct = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = leftProduct;

            leftProduct = leftProduct * nums[i];
        }

        // Backward pass: product of elements on the right
        int rightProduct = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] = answer[i] * rightProduct;

            rightProduct = rightProduct * nums[i];
        }

        return answer;
    }


    // Q2. Maximum Subarray
    static void maxSubArrayQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = maxSubArray(nums);

        System.out.println("Maximum Subarray Sum: " + result);
    }

    static int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {

            // Decide whether to extend or restart
            currentSum = Math.max(nums[i], currentSum + nums[i]);

            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }


    // Q3. 3Sum
    static void threeSumQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] result = threeSum(nums);

        System.out.println("Unique Triplets:");

        for (int[] triplet : result) {
            System.out.println(Arrays.toString(triplet));
        }

        if (result.length == 0) {
            System.out.println("No triplets found.");
        }
    }

    static int[][] threeSum(int[] nums) {

        Arrays.sort(nums);

        ArrayList<int[]> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            // Skip duplicate first values
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(new int[]{
                            nums[i],
                            nums[left],
                            nums[right]
                    });

                    // Skip duplicate values
                    while (left < right &&
                            nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right &&
                            nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;

                } else if (sum < 0) {

                    left++;

                } else {

                    right--;
                }
            }
        }

        int[][] answer = new int[result.size()][];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }


    // Q4. Subarray Sum Equals K
    static void subarraySumQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        int result = subarraySum(nums, k);

        System.out.println("Number of subarrays: " + result);
    }

    static int subarraySum(int[] nums, int k) {

        HashMap<Integer, Integer> prefixFrequency =
                new HashMap<>();

        // Empty prefix
        prefixFrequency.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {

            currentSum = currentSum + num;

            int requiredSum = currentSum - k;

            if (prefixFrequency.containsKey(requiredSum)) {
                count = count + prefixFrequency.get(requiredSum);
            }

            prefixFrequency.put(
                    currentSum,
                    prefixFrequency.getOrDefault(currentSum, 0) + 1
            );
        }

        return count;
    }


    // Q5. Find Minimum in Rotated Sorted Array
    static void findMinQuestion() {

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int result = findMin(nums);

        System.out.println("Minimum element: " + result);
    }

    static int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {

                // Minimum is in the right half
                left = mid + 1;

            } else {

                // Minimum is in the left half
                right = mid;
            }
        }

        return nums[left];
    }
}