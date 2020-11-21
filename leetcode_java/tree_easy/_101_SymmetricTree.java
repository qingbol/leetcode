/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(2020313)///////////////////////
  /////////////////////////// first round(2020313)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200313
  // can't figure out myselft.
  // a little tricky. than same tree

  // public boolean isSymmetric(TreeNode root) {
  public boolean isSymmetric1(TreeNode root) {
    if (null == root) {
      return true;
    }
    return helper1(root.left, root.right);
  }

  private boolean helper1(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    }
    if (l == null || r == null) {
      return false;
    }
    if (l.val != r.val) {
      return false;
    }

    if (!helper1(l.left, r.right) || !helper1(l.right, r.left)) {
      return false;
    }

    return true;
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20201115)///////////////////////
  /////////////////////////// second round(20201115)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20201115.
  // refer to leetcode standard: Approach 1: Recursive

  // 195/195 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 75.23 % of java submissions (36.9 MB)

  public boolean isSymmetric(TreeNode root) {
    // public boolean isSymmetric2(TreeNode root) {
    return helper2(root, root);
  }

  private boolean helper2(TreeNode l, TreeNode r) {
    if (l == null && r == null)
      return true;
    if (l == null || r == null)
      return false;
    if (l.val != r.val)
      return false;
    return helper2(l.left, r.right) && helper2(l.right, r.left);
  }
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
