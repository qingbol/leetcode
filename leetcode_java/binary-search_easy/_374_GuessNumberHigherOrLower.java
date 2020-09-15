/*
 * @lc app=leetcode id=374 lang=java
 *
 * [374] Guess Number Higher or Lower
 */

// @lc code=start
/*
 * The guess API is defined in the parent class GuessGame.
 * 
 * @param num, your guess
 * 
 * @return -1 if my number is lower, 1 if my number is higher, otherwise return 0 int guess(int
 * num);
 */

public class Solution extends GuessGame {
  ////////////////// first round(20200120)///////////////////////////////////
  ////////////////// first round(20200120)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200120
  // public int guessNumber(int n) {
  public int guessNumber1(int n) {
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
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200915)///////////////////////////////////
  ////////////////// second round(20200915)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200915. by myself

  // 25/25 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 65.21 % of java submissions (36.2 MB)

  public int guessNumber(int n) {
    // public int guessNumber2(int n) {
    int lo = 1, hi = n;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (guess(mid) == 0) {
        return mid;
      } else if (guess(mid) == 1) {
        lo = mid + 1;
        // hi = mid - 1;
      } else {
        // lo = mid + 1;
        hi = mid - 1;
      }
    }
    return -1;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
