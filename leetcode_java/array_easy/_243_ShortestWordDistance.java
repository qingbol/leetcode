/*
 * @lc app=leetcode id=243 lang=java
 *
 * [243] Shortest Word Distance
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200111

  // public int shortestDistance(String[] words, String word1, String word2) {
  public int shortestDistance1(String[] words, String word1, String word2) {
    int minDistance = words.length;
    int idx1 = -1;
    int idx2 = -1;

    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        idx1 = i;
      } else if (word2.equals(words[i])) {
        idx2 = i;
      }
      if (idx1 != -1 && idx2 != -1) {
        minDistance = Math.min(minDistance, Math.abs(idx1 - idx2));
      }
    }
    return minDistance;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20200908, by myself

  // 26/26 cases passed (1 ms)
  // Your runtime beats 99.87 % of java submissions
  // Your memory usage beats 62.05 % of java submissions (39.8 MB)

  public int shortestDistance(String[] words, String word1, String word2) {
    // public int shortestDistance2(String[] words, String word1, String word2) {
    int idx1 = -1, idx2 = -1;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      if (words[i].equals(word1)) {
        idx1 = i;
        if (idx2 != -1)
          res = Math.min(res, Math.abs(idx1 - idx2));
      } else if (words[i].equals(word2)) {
        idx2 = i;
        if (idx1 != -1)
          res = Math.min(res, Math.abs(idx1 - idx2));
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
