package problems.easy;

/**
 * Solution to problem 293. Nim Game
 * */
public class NimGame {

    public static void main(String[] args) {
        NimGame ng = new NimGame();
        System.out.println(ng.canWinNim(17));
    }

    /*Short explanation:
    - We know that 4 is a guaranteed lose
    - The goal is to force the opponent into a lose-state
    - We therefore also know that if the player have 5, 6 or 7 they can force the opponent into a lose-state
    - Knowing this, we can also guarantee that having 8 stones will leave 5, 6, or 7 stones for the opponent meaning
        that they will win no matter what
    - This means that we can always win as long as we start out with a number that is not a multiple of four
    */
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }
}
