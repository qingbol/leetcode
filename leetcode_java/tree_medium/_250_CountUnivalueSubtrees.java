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
  // 191/197 cases passed (N/A)
  int res = 0;

  public int countUnivalSubtrees1(TreeNode root) {
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
  //// ------------start(Approach2)-------------------------------
  // by leetcode best solution
  public int countUnivalSubtrees(TreeNode root) {
    helper2(root);
    return res;
  }

  private boolean helper2(TreeNode cur) {
    if (cur == null) {
      return true;
    }
    boolean l = helper2(cur.left);
    boolean r = helper2(cur.right);
    if (l && r) {
      if (cur.left != null && cur.left.val != cur.val) {
        return false;
      }
      if (cur.right != null && cur.right.val != cur.val) {
        return false;
      }
      res++;
      return true;
    }
    return false;
  }

  //// ------------ end (Approach2)-------------------------------
  //// ------------start(Approach3)-------------------------------
  //// ------------ end (Approach3)-------------------------------
}
// @lc code=end
