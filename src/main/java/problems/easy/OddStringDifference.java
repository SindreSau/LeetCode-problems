package problems.easy;

import java.sql.Array;
import java.util.*;

/**
 * Solution to problem 2451. Odd String Difference
 * */
public class OddStringDifference {

    public static void main(String[] args) {
        String[] words = {"adc", "wzy", "abc"};
        String[] words2 = {"aaa","bob","ccc","ddd"};

        System.out.println(oddString(words));
        System.out.println(oddString(words2));
    }

    // Help from solutions
    /*public static String oddString(String[] words) {
        // List to store one differenceArray(e.g. [3, -1]) and one or more "words". We can then return the word that is
        // stored with the key that has a list of length 1!
        Map<List<Integer>, List<String>> map = new HashMap<>();

        // Running through each word
        for (int i = 0; i < words.length; i++) {
            char[] letters = words[i].toCharArray();
            List<Integer> list = new ArrayList<>();

            // Running through each letter
            for (int j = 0; j < letters.length - 1; j++) {
                list.add(letters[j + 1] - letters[j]);
            }

            if(map.containsKey(list)) {
                map.get(list).add(words[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(words[i]);
                map.put(list, l);
            }
        }

        for (List<Integer> key : map.keySet()) {
            if (map.get(key).size() == 1)
                return map.get(key).get(0);
        }

        return"";
    }*/
    //First try
    public static String oddString(String[] words) {
        // Map to store the difference-list with a list of the strings that has that particular difference
        HashMap<List<Integer>, List<String>> map = new HashMap<>();


        for (int i = 0; i < words.length; i++) {
            char[] letters = words[i].toCharArray();
            List<Integer> diff = new ArrayList<>();
            for (int j = 0; j < letters.length - 1; j++) {
                diff.add(letters[ j + 1] - letters[j]);
            }

            if (map.containsKey(diff)) {
                map.get(diff).add(words[i]);
            } else {
                List<String> l = new ArrayList<>();
                l.add(words[i]);
                map.put(diff, l);
            }
        }

        // Looping through map with map.keySet returning the key as a list of integers
        for (List<Integer> key : map.keySet()) {
            // Returning the 0'th element(meaning the single string) of the string-list stored in the key that has a list of length 1
            if (map.get(key).size() == 1)
                return map.get(key).get(0);
        }

        return "";
    }
}
/*
TASK:
You are given an array of equal-length strings words. Assume that the length of each string is n.

Each string words[i] can be converted into a difference integer array difference[i] of length n - 1 where difference[i][j] = words[i][j+1] - words[i][j] where 0 <= j <= n - 2. Note that the difference between two letters is the difference between their positions in the alphabet i.e. the position of 'a' is 0, 'b' is 1, and 'z' is 25.

For example, for the string "acb", the difference integer array is [2 - 0, 1 - 2] = [2, -1].
All the strings in words have the same difference integer array, except one. You should find that string.

Return the string in words that has different difference integer array.



Example 1:

Input: words = ["adc","wzy","abc"]
Output: "abc"
Explanation:
- The difference integer array of "adc" is [3 - 0, 2 - 3] = [3, -1].
- The difference integer array of "wzy" is [25 - 22, 24 - 25]= [3, -1].
- The difference integer array of "abc" is [1 - 0, 2 - 1] = [1, 1].
The odd array out is [1, 1], so we return the corresponding string, "abc".
Example 2:

Input: words = ["aaa","bob","ccc","ddd"]
Output: "bob"
Explanation: All the integer arrays are [0, 0] except for "bob", which corresponds to [13, -13].


Constraints:

3 <= words.length <= 100
n == words[i].length
2 <= n <= 20
words[i] consists of lowercase English letters.
*/