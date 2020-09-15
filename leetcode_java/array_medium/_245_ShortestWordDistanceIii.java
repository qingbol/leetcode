/*
 * @lc app=leetcode id=245 lang=java
 *
 * [245] Shortest Word Distance III
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200111)///////////////////////////////////
  ////////////////// first round(20200111)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200111

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

  //// --------------------------- end (Approach1)-----------------------
  //// ---------------------------start(Approach2)-----------------------
  // optimal
  // public int shortestWordDistance(String[] words, String word1, String word2) {
  public int shortestWordDistance2(String[] words, String word1, String word2) {
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

  //// --------------------------- end (Approach2)-----------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach3)-----------------------
  // 20200908

  // 39/39 cases passed (1 ms)
  // Your runtime beats 99.57 % of java submissions
  // Your memory usage beats 91.67 % of java submissions (39.5 MB)

  public int shortestWordDistance(String[] words, String word1, String word2) {
    // public int shortestWordDistance3(String[] words, String word1, String word2) {
    int n = words.length;
    int res = Integer.MAX_VALUE;
    if (word1.equals(word2)) {
      int prePos = -1;
      // int idx = -1;
      for (int i = 0; i < n; i++) {
        if (words[i].equals(word1)) {
          if (prePos == -1) {
            prePos = i;
          } else {
            res = Math.min(res, i - prePos);
            prePos = i;
          }
        }
      }
    } else {
      int idx1 = -1, idx2 = -1;
      for (int i = 0; i < n; i++) {
        if (words[i].equals(word1) || words[i].equals(word2)) {
          if (words[i].equals(word1)) {
            idx1 = i;
          } else {
            idx2 = i;
          }
          if (idx1 != -1 & idx2 != -1) {
            res = Math.min(res, Math.abs(idx1 - idx2));
          }
        }
      }
    }

    return res;
  }

  //// --------------------------- end (Approach3)-----------------------
}

// @lc code=end
