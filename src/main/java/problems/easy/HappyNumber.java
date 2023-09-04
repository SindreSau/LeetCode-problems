package problems.easy;

import java.util.LinkedList;

/**
 * Solution to problem 202. Happy Number
 * */
public class HappyNumber {

    public static void main(String[] args) {

        HappyNumber hn = new HappyNumber();
        int n = 19;

        long timeBefore = System.currentTimeMillis();
        System.out.println(hn.isHappy(n));
        long timeElapsed = System.currentTimeMillis() - timeBefore;
        System.out.println(timeElapsed + "ms\n");

        long timeBefore2 = System.currentTimeMillis();
        System.out.println(hn.isHappy2(n));
        long timeElapsed2 = System.currentTimeMillis() - timeBefore2;
        System.out.println(timeElapsed2 + "ms");

    }

    // Submitted working, but slow solution!
    public boolean isHappy(int n) {
        do {
            // Using list to get separated integers in correct order
            LinkedList<Integer> list = new LinkedList<>();
            // Separate into a list of digits
            while (n > 0) {
                list.push(n % 10);
                n = n / 10;
            }

            for (Integer integer : list) n += (int) Math.pow(integer, 2);
            /*System.out.println(n);*/

            if (n < 4) {
                return n == 1;
            }
        } while (n > 4);

        return false;
    }

    // Solution with pointers and Floyd's cycle algorithm (infinite loop detector)
    public boolean isHappy2(int n) {

        int slow = n;
        int fast = n;
        //while loop is not used here because initially slow and
        //fast pointer will be equal only, so the loop won't run.
        do {
        //slow moving one step ahead and fast moving two steps ahead

            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        //if a cycle exists, then the number is not a happy number
        //and slow will have a value other than 1

        return slow == 1;
    }

    //Finding the square of the digits of a number

    public int square(int num) {

        int ans = 0;

        while(num > 0) {
            int remainder = num % 10;
            ans += remainder * remainder;
            num /= 10;
        }

        return ans;
    }
}
