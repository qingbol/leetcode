import java.util.HashMap;

/*
 * @lc app=leetcode id=438 lang=java
 *
 * [438] Find All Anagrams in a String
 */

// @lc code=start
class Solution {

  ////////////////// first round(20200728)///////////////////////////////////
  ////////////////// first round(20200728)///////////////////////////////////
  //// -----------------start(Appraoch1)----------------------
  // 20200728. by myself.
  // refer to labuladong <滑动窗口解题套路框架>

  // 36/36 cases passed (39 ms)
  // Your runtime beats 30.16 % of java submissions
  // Your memory usage beats 5.02 % of java submissions (46.5 MB)

  // public List<Integer> findAnagrams(String s, String p) {
  public List<Integer> findAnagrams1(String s, String p) {
    HashMap<Character, Integer> need = new HashMap<>();
    HashMap<Character, Integer> window = new HashMap<>();
    for (char ch : p.toCharArray())
      need.put(ch, need.getOrDefault(ch, 0) + 1);

    int left = 0, right = 0;
    int matched = 0;
    List<Integer> res = new ArrayList<>();

    while (right < s.length()) {
      char rChar = s.charAt(right);
      right++;
      if (need.containsKey(rChar)) {
        window.put(rChar, window.getOrDefault(rChar, 0) + 1);
        if (need.get(rChar).equals(window.get(rChar)))
          matched++;
      }

      // System.out.format("window:[%d, %d)\n", left, right);

      while (matched == need.size()) {
        if (right - left == p.length()) {
          // if ((right - left).equals(p.length())) {
          res.add(left);
        }
        char lChar = s.charAt(left);
        left++;
        if (need.containsKey(lChar)) {
          if (need.get(lChar).equals(window.get(lChar))) {
            matched--;
          }
          window.put(lChar, window.get(lChar) - 1);
        }
      }
    }

    return res;
  }
  //// ----------------- end (Appraoch1)----------------------
}
// @lc code=end
