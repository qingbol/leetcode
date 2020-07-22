/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200221)/////////////////////////////
  /////////////////////// first round(20200221)/////////////////////////////
  //// :--------------------start(approach 1)------------------------------
  // 20200221, dp
  // Your runtime beats 24.62 % of java submissions
  // public String longestPalindrome(String s) {
  public String longestPalindrome1(String s) {
    if (s.length() < 2) {
      return s;
    }
    int n = s.length();
    String res = "";
    boolean[][] dp = new boolean[n][n];
    // for (int i = 0; i < n; i++) {
    // dp[i][i] = true;
    // res = s.substring(i, i + 1);
    // }
    for (int i = n - 1; i >= 0; i--) {
      for (int j = i; j < n; j++) {
        if (i + 1 >= j - 1) {
          dp[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          dp[i][j] = dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j);
        }
        if (dp[i][j] && (j - i + 1) > res.length()) {
          res = s.substring(i, j + 1);
        }
        // System.out.format("dp:%s\n", Arrays.deepToString(dp));
      }
    }
    return res;
  }

  //// :-------------------- end (approach 1)------------------------------
  //// :--------------------start(approach 2)------------------------------
  // 20200221
  // Approach 4: Expand Around Center
  // Your runtime beats 89.98 % of java submissions
  private String res = "";

  public String longestPalindrome2(String s) {
    if (s.length() < 2) {
      return s;
    }
    for (int i = 0; i < s.length(); i++) {
      helper(s, i, i);
      helper(s, i, i + 1);
    }
    return res;
  }

  private void helper(String ss, int l, int r) {
    while (l >= 0 && r < ss.length() && ss.charAt(l) == ss.charAt(r)) {
      l--;
      r++;
    }
    if ((r - l - 1) > res.length()) {
      res = ss.substring(l + 1, r);
    }
  }

  //// :--------------------start(approach 2)------------------------------
  //// :-------------------- end (approach 3)------------------------------
  // 20200328. dp, by myself
  // Your runtime beats 23.13 % of java submissions
  // Your runtime beats 25.34 % of java submissions
  public String longestPalindrome3(String s) {
    if (s.length() <= 1) {
      return s;
    }

    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int max = 1;
    int l = 0;
    int r = 0;

    for (int j = 0; j < n; j++) {
      for (int i = 0; i <= j; i++) {
        
          ////i + 1 >= j -1 is a special case.
        if (s.charAt(i) == s.charAt(j) && (i + 1 >= j - 1 || dp[i + 1][j - 1])) {
          dp[i][j] = true;
          if (j - i + 1 > max) {
            max = j - i + 1;
            l = i;
            r = j;
          }
          // } else {
          // dp[i][j] = false;
        }
        // }
      }
    }
    // System.out.format("dp: %s\n", Arrays.deepToString(dp).replaceAll("\\],",
    // "\n"));
    return s.substring(l, r + 1);
  }

  //// -------------------- end (approach 3)------------------------------
  /////////////////////// second round(20200719)/////////////////////////////
  /////////////////////// second round(20200719)/////////////////////////////
  //// :--------------------start(approach 4)------------------------------
  // 20200719, by myslef. two pointers
  // 103/103 cases passed (26 ms)
  // Your runtime beats 68.58 % of java submissions
  // Your memory usage beats 50.43 % of java submissions (39.6 MB)
  // public String longestPalindrome(String s) {
  public String longestPalindrome4(String s) {
    int n = s.length();
    int max = 0;
    String res = "";

    for (int i = 0; i < n; i++) {
      for (int l = 0; l <= Math.min(i, n - i - 1); l++) {
        if (s.charAt(i + l) == s.charAt(i - l)) {
          if (2 * l + 1 > max) {
            max = 2 * l + 1;
            res = s.substring(i - l, i + l + 1);
            // System.out.format("max: %d, res: %s\n", max, res);
          }
        } else {
          break;
        }
      }
    }

    // System.out.format("even number\n");
    for (int i = 0; i < n - 1; i++) {
      for (int l = 0; l <= Math.min(i, n - i - 2); l++) {
        if (s.charAt(i - l) == s.charAt(i + 1 + l)) {
          if (2 * l + 2 > max) {
            max = 2 * l + 2;
            res = s.substring(i - l, i + l + 2);
            // System.out.format("max: %d, res: %s\n", max, res);
          }
        } else {
          break;
        }
      }
    }
    return res;
  }
  //// -------------------- end (approach 4)------------------------------
  //// :--------------------start(approach 5)------------------------------
  // 20200719,  two pointers. refer to labladong<如何寻找最长回文子串>. 
  public String longestPalindrome(String s) {
  // public String longestPalindrome5(String s) {
    String res = "";
    // String test = "ab";
    // System.out.println("test:" + test.substring(2, 2));
    for (int i = 0; i < s.length(); i++) {
      //odd number
      String oddRes = palindrome5(s, i, i);
      //even number
      String evenRes = palindrome5(s, i , i + 1);

      res = res.length() >= oddRes.length() ? res : oddRes;
      res = res.length() >= evenRes.length() ? res : evenRes;
    }
    return res;
  }

  private String palindrome5(String s, int l, int r) {
    while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
      l--;
      r++;
    }
    
    return s.substring(l + 1, r);
  }
  //// -------------------- end (approach 5)------------------------------
}
// @lc code=end
