/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
  public int guessNumber(int n) {
    int lo = 1;
    int hi = n;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (guess(mid) == 0) {
        return mid;
      } else if (guess(mid) == 1) {
        lo = mid + 1;
      } else {
        hi = mid - 1;
      }
    }
    return -1;
  }
}
// @lc code=end
