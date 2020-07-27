/*
 * @lc app=leetcode id=254 lang=java
 *
 * [254] Factor Combinations
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200229)//////////////////////////
  /////////////////////////// first round(20200229)//////////////////////////
  //// ----------------------start(Approach1)-------------------------
  // 20200229
  // By myself. acceptable

  public List<List<Integer>> getFactors1(int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (n <= 1) {
      return res;
    }

    helper1(res, new ArrayList<>(), n, 2);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int n, int start) {
    if (n == 1) {
      if (lst.size() > 0) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = start; i <= n; i++) {
      if (n % i != 0) {
        continue;
      }
      if (n / i != 1 || n / i == 1 && lst.size() > 0) {
        lst.add(i);
        helper1(res, lst, n / i, i);
        lst.remove(lst.size() - 1);
      }
    }
  }

  //// ---------------------- end (Approach1)-------------------------
  //// ----------------------start(Approach2)-------------------------
  // better

  // public List<List<Integer>> getFactors(int n) {
  public List<List<Integer>> getFactors2(int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (n <= 1) {
      return res;
    }

    helper2(res, new ArrayList<>(), n, 2);
    return res;
  }

  private void helper2(List<List<Integer>> res, List<Integer> lst, int n, int start) {
    if (n == 1) {
      if (lst.size() > 1) {
        res.add(new ArrayList<>(lst));
      }
      return;
    }

    for (int i = start; i <= n; i++) {
      if (n % i != 0) {
        continue;
      }
      lst.add(i);
      helper2(res, lst, n / i, i);
      lst.remove(lst.size() - 1);
    }
  }
  //// ---------------------- end (Approach2)-------------------------
  /////////////////////////// second round(20200726)//////////////////////////
  /////////////////////////// second round(20200726)//////////////////////////
  //// ----------------------start(Approach3)-------------------------
  // 20200726, by myself. TLE.

  //// without if (n % i != 0) continue;
  // Time Limit Exceeded
  // 17/21 cases passed (N/A)
  // Testcase
  // 8192

  //// with if (n % i != 0) continue;
  // Time Limit Exceeded
  // 20/21 cases passed (N/A)
  // Testcase
  // 23848713

  // we need to decrease n in the process

  // public List<List<Integer>> getFactors(int n) {
  public List<List<Integer>> getFactors3(int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (n <= 3)
      return res;
    helper3(n, 2, 1, new ArrayList<>(), res);
    return res;
  }

  private void helper3(int n, int start, int product, List<Integer> track, List<List<Integer>> res) {
    if (product >= n) {
      if (product == n)
        res.add(new ArrayList<>(track));
      return;
    }

    for (int i = start; i < n; i++) {
      if (n % i != 0)
        continue;
      track.add(i);
      helper3(n, i, product * i, track, res);
      track.remove(track.size() - 1);
    }
  }
  //// ---------------------- end (Approach3)-------------------------
  //// ----------------------start(Approach4)-------------------------
  // 20200726, by myself. TLE.

  // without if (track.size() > 1)
  // our Input
  // 12
  // Output (0 ms)
  // [[2,2,3],[2,6],[3,4],[12]]
  // Expected Answer
  // [[2,6],[3,4],[2,2,3]

  // 21/21 cases passed (120 ms)
  // Your runtime beats 48.18 % of java submissions
  // Your memory usage beats 50.45 % of java submissions (37.1 MB)

  public List<List<Integer>> getFactors(int n) {
    // public List<List<Integer>> getFactors4(int n) {
    List<List<Integer>> res = new ArrayList<>();
    if (n <= 3)
      return res;
    helper4(n, 2, new ArrayList<>(), res);
    return res;
  }

  private void helper4(int n, int start, List<Integer> track, List<List<Integer>> res) {
    if (n <= 1) {
      if (n == 1) {
        if (track.size() > 1)
          res.add(new ArrayList<>(track));
      }
      return;
    }

    for (int i = start; i <= n; i++) {
      if (n % i != 0)
        continue;
      track.add(i);
      helper4(n / i, i, track, res);
      track.remove(track.size() - 1);
    }
  }
  //// ---------------------- end (Approach3)-------------------------
}
// @lc code=end
