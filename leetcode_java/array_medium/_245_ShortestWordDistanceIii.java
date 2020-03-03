/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 */

// @lc code=start
class Solution {
  public int shortestWordDistance1(String[] words, String word1, String word2) {
    int prePos = -1;
    int minDis = words.length;
    int idx1 = -1;
    int idx2 = -1;
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(word2) && word1.equals(words[i]) && prePos != i) {
        if (-1 != prePos) {
          minDis = Math.min(minDis, i - prePos);
        }
        prePos = i;
      } else if (word1.equals(words[i])) {
        idx1 = i;
      } else if (word2.equals(words[i])) {
        idx2 = i;
      }

      if (idx1 != -1 && idx2 != -1) {
        minDis = Math.min(minDis, Math.abs(idx1 - idx2));
      }
    }
    return minDis;
  }

  // optimal
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int minDis = words.length;
    int idx1 = -1;
    int idx2 = -1;
    for (int i = 0; i < words.length; i++) {
      if (word1.equals(words[i])) {
        idx1 = i;
      }
      if (word2.equals(words[i])) {
        if (word1.equals(word2)) {
          idx1 = idx2;
        }
        idx2 = i;
      }
      // System.out.println("idx1: " + idx1);
      // System.out.println("idx2: " + idx2);

      if (-1 != idx1 && -1 != idx2) {
        minDis = Math.min(minDis, Math.abs(idx1 - idx2));
      }
    }

    return minDis;
  }
}
// @lc code=end
