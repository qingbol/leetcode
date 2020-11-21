/*
 * @lc app=leetcode id=100 lang=java
 *
 * [100] Same Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(2020313)///////////////////////
  /////////////////////////// first round(2020313)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200313
  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (p == null || q == null) {
      // if (p == null && q != null || p != null && q == null) {
      return false;
    }
    if (p.val != q.val) {
      return false;
    }
    if (!isSameTree(p.left, q.left) || !isSameTree(p.right, q.right)) {
      return false;
    }
    return true;
  }
  //// ----------------start(Appraoch1)----------------------------------
  /////////////////////////// second round(20201115)///////////////////////
  /////////////////////////// second round(20201115)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20201115.
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
