/*
 * @lc app=leetcode id=226 lang=java
 *
 * [226] Invert Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// -----------------start(Approach1)-----------------------
  // 20200312
  // come up with it by myself. But it's wrong
  // because the argument is passed by value. The subroutine will copy a new
  // reference.
  public TreeNode invertTree1(TreeNode root) {
    if (root == null) {
      return root;
    }
    helper(root.left, root.right);
    return root;
  }

  private void helper(TreeNode l, TreeNode r) {
    if (l == null && r == null) {
      return;
    }
    // if (l == null || r == null) {
    TreeNode tmp = l;
    l = r;
    r = tmp;
    // }
    helper(l.left, r.right);
    helper(l.right, r.left);
  }

  //// ----------------- end (Approach1)-----------------------
  //// -----------------start(Approach2)-----------------------
  // improvement of Approach1. by doing it in the same method. i.e. don't pass
  // argument to another method
  // recursion in perorder
  public TreeNode invertTree2(TreeNode root) {
    if (root == null) {
      return root;
    }

    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    invertTree(root.left);
    invertTree(root.right);
    return root;
  }

  //// ----------------- end (Approach2)-----------------------
  //// -----------------start(Approach3)-----------------------
  // recursion in postorder
  public TreeNode invertTree(TreeNode root) {
    if (root == null) {
      return root;
    }

    invertTree(root.left);
    invertTree(root.right);

    TreeNode tmp = root.left;
    root.left = root.right;
    root.right = tmp;

    return root;
  }
  //// ----------------- end (Approach3)-----------------------
}
// @lc code=end
