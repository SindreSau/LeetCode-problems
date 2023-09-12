package problems.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution to problem 1446. Consecutive Characters
 * */
public class ConsecutiveCharacters {

    public static void main(String[] args) {
        String s = "leetcode";

        System.out.println(maxPower(s));
    }

    public static int maxPower(String s) {
        int largestSubstring = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            int currentSubstring = 1;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    currentSubstring++;
                } else {
                    break;
                }
            }
            if (currentSubstring > largestSubstring) {
                largestSubstring = currentSubstring;
            }
        }

        return largestSubstring;
    }
}
