package string.assigment_problems;

import java.util.Scanner;

public class Q2_WordReversalEncoder {

    static String reverseEachWord(String sentence) {

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {

            StringBuilder reversed = new StringBuilder();

            for (int i = word.length() - 1; i >= 0; i--) {
                reversed.append(word.charAt(i));
            }

            result.append(reversed).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();

        String result = reverseEachWord(sentence);

        System.out.println("Reversed words: " + result);

        sc.close();
    }
}
