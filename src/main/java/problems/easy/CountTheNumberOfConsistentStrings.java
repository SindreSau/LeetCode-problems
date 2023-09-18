package problems.easy;

import java.util.Arrays;

/**
 * Solution to problem 1684. Count the Number of Consistent Strings
 */
public class CountTheNumberOfConsistentStrings {

    public static void main(String[] args) {
        /*String allowed = "abc";
        String[] words = {"a", "b", "c", "ab", "ac", "bc", "abc"};*/

        String allowed = "ad";
        String[] words = {"ad","bd","aaab","baa","badab"};

        System.out.println(countConsistentStrings(allowed, words));

    }

    // First submit. Super slow, but passing
    /*public static int countConsistentStrings(String allowed, String[] words) {
        int allowedAmount = 0;

        for (String word : words) {
            int contained = 0;
            for (char c : allowed.toCharArray()) {
                for (char l : word.toCharArray()) {
                    if (l == c)
                        contained++;
                }
            }
            if (contained == word.length())
                allowedAmount++;
        }

        return allowedAmount;
    }*/


    // Fast solution, taken from solutions
    public static int countConsistentStrings(String allowed, String[] words) {
            int count = words.length;
            int[] store = new int[26];

            for (char c : allowed.toCharArray()){
                store[c-'a']++;
            }

            for (String word : words) {

                for (char c : word.toCharArray()) {
                    if (store[c-'a'] <= 0){
                        count--;
                        break;
                    }
                }
            }
            return count;
    }
}
