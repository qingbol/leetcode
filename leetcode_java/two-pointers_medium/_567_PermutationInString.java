import java.util.HashMap;

/*
 * @lc app=leetcode id=567 lang=java
 *
 * [567] Permutation in String
 */

// @lc code=start
class Solution {
    ////////////////// first round(20200727)///////////////////////////////////
    ////////////////// first round(20200727)///////////////////////////////////
    //// -----------------start(Appraoch1)----------------------
    // 20200727, by myself.
    //refer to labuladong <滑动窗口解题套路框架>
    // 103/103 cases passed (40 ms)
    // Your runtime beats 23.88 % of java submissions
    // Your memory usage beats 5.12 % of java submissions (41.4 MB)

    public boolean checkInclusion(String s1, String s2) {
        // public boolean checkInclusion1(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int left = 0, right = 0;
        int matched = 0;

        while (right < s2.length()) {
            char rChar = s2.charAt(right);
            right++;
            if (need.containsKey(rChar)) {
                window.put(rChar, window.getOrDefault(rChar, 0) + 1);
                if (window.get(rChar).equals(need.get(rChar)))
                    matched++;
            }

            // debug
            while (matched == need.size()) {
                if (right - left == s1.length()) {
                    return true;
                }
                char lChar = s2.charAt(left);
                left++;
                if (need.containsKey(lChar)) {
                    if (need.get(lChar).equals(window.get(lChar))) {
                        matched--;
                    }
                    window.put(lChar, window.get(lChar) - 1);
                }
            }
        }

        return false;
    }
    //// ----------------- end (Appraoch1)----------------------
}
// @lc code=end
