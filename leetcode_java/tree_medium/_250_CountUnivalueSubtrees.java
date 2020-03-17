/*
 * @lc app=leetcode id=250 lang=java
 *
 * [250] Count Univalue Subtrees
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ------------start(Approach1)-------------------------------
  // 20200316
  // by myself.
  // wrong. because it don't test if the children is a unival tree.
  int res = 0;

  public int countUnivalSubtrees(TreeNode root) {
    if (root == null) {
      return 0;
    }
    countUnivalSubtrees(root.left);
    countUnivalSubtrees(root.right);
    if ((root.left == null || root.left.val == root.val) && (root.right == null || root.right.val == root.val)) {
      res++;
    }
    return res;
  }
  //// ------------ end (Approach1)-------------------------------
}
// @lc code=end
