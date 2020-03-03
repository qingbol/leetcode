/*
 * @lc app=leetcode id=243 lang=java
 *
 * [243] Shortest Word Distance
 */

// @lc code=start
class Solution {
  public int shortestDistance(String[] words, String word1, String word2) {
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
}
// @lc code=end
