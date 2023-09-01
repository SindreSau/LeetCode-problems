package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution to problem 338. Counting Bits
 * */
public class CountingBits {

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        int n = 5_000;

        long timeBefore = System.currentTimeMillis();
        int[] arr = cb.countBits(n);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        long time = System.currentTimeMillis() - timeBefore;
        System.out.println("\nTime in millis: " + time + "ms");

        // Solution found on leetcode
        long timeBefore2 = System.currentTimeMillis();
        int[] arr2 = cb.countBits2(n);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + ", ");
        }
        long time2 = System.currentTimeMillis() - timeBefore2;
        System.out.println("\nTime in millis: " + time2 + "ms");
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < ans.length; i++) {
            /*bitCount returns the number of one-bits in the two's complement binary
            representation of the specified int value*/
            ans[i] = Integer.bitCount(i);
        }

        return ans;
    }

    //? Other solutions
    // Solution found on leetcode, by avg_code
    public int[]countBits2(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;

        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i / 2] + i % 2;
        }

        return ans;
    }
}

/*
* TASK
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.



Example 1:

Input: n = 2
Output: [0,1,1]
Explanation:
0 --> 0
1 --> 1
2 --> 10
Example 2:

Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101


Constraints:

0 <= n <= 105
*/