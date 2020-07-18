/*
 * @lc app=leetcode id=875 lang=java
 *
 * [875] Koko Eating Bananas
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)------------------
  // 20200718, by myself.
  // 15/115 cases passed (19 ms)
  // Your runtime beats 40.56 % of java submissions
  public int minEatingSpeed1(int[] piles, int H) {
    // public int minEatingSpeed(int[] piles, int H) {
    if (piles == null || piles.length == 0)
      return -1;
    int max = piles[0];
    for (int i = 1; i < piles.length; i++) {
      max = Math.max(max, piles[i]);
    }

    // int res = binSearch(piles, 1, max, H);
    int lo = 1, hi = max;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      int hour = calTime(piles, mid);
      if (hour > H) {
        lo = mid + 1;
      } else if (hour < H) {
        hi = mid - 1;
      } else if (hour == H) {
        // should contract the right bound, rather than return
        hi = mid - 1;
        // return mid;
      }
    }
    return lo;
  }

  private int calTime(int[] piles, int k) {
    int ans = 0;
    for (int i = 0; i < piles.length; i++) {
      ans += piles[i] / k;
      int remainder = piles[i] % k;
      if (remainder > 0)
        ans += 1;
    }
    return ans;
  }

  //// --------------- end (Approach1)------------------
  //// ---------------start(Approach2)------------------
  // 20200718, better solution, refer to labuladong
  // 115/115 cases passed (14 ms)
  // Your runtime beats 72.03 % of java submissions
  public int minEatingSpeed(int[] piles, int H) {
    // public int minEatingSpeed2(int[] piles, int H) {
    int lo = 1, hi = getMax(piles) + 1;
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      // System.out.format("lo:%d, hi: %d, mid: %d\n", lo, hi, mid);
      if (canFinish(piles, mid, H)) {
        hi = mid;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  private int getMax(int[] piles) {
    int ans = 0;
    for (int pile : piles) {
      ans = Math.max(ans, pile);
    }
    return ans;
  }

  private boolean canFinish(int[] piles, int speed, int H) {
    for (int pile : piles) {
      // System.out.print(pile + " " + speed + " " + pile / speed + " " +
      // Math.ceil(pile / speed));
      // H -= Math.ceil(pile / speed);
      H -= ((pile / speed) + ((pile % speed) > 0 ? 1 : 0));
      // System.out.println("H:" + H);
    }
    // note: H = 0 is ture, beacuse the requirement is eating all the banans before
    // the guards come back.
    return H >= 0;
  }
  //// --------------- end (Approach2)------------------
}
// @lc code=end
