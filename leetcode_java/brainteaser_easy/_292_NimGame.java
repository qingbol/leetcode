/*
 * @lc app=leetcode id=292 lang=java
 *
 * [292] Nim Game
 */

// @lc code=start
////-------------------start(Approach1)---------------------------
//20200721. refer to leetcode standard solution & labuladong <一行代码就能解决的算法题>
// 60/60 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 5.05 % of java submissions (38.1 MB)
class Solution {
    public boolean canWinNim(int n) {
        return (n % 4) != 0;
    }
////------------------- end (Approach1)---------------------------
}
// @lc code=end

