/*
 * @lc app=leetcode id=101 lang=java
 *
 * [101] Symmetric Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// -----------------start(Approach1)--------------
  // 20200313
  // can't figure out myselft.
  // a little tricky. than same tree
  public boolean isSymmetric(TreeNode root) {
    if (null == root) {
      return true;
    }
    return helper(root.left, root.right);
  }

  private boolean helper(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return true;
    }
    if (l == null || r == null) {
      return false;
    }
    if (l.val != r.val) {
      return false;
    }

    if (!helper(l.left, r.right) || !helper(l.right, r.left)) {
      return false;
    }

    return true;
  }
}
// @lc code=end
