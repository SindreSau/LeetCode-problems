package problems.easy;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Solution to problem 338. Counting Bits
 * */
public class CountingBits {

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();
        int n = 5;

        int[] arr = cb.countBits(n);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.bitCount(i);
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