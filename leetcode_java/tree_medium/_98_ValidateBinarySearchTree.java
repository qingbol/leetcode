/*
 * @lc app=leetcode id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ----------------start(Approach1)----------------------------
  // 20200312
  // by myself.
  // Your runtime beats 100 % of java submissions
  public boolean isValidBST1(TreeNode root) {
    if (root == null) {
      return true;
    }
    if (root.left != null) {
      if (getMax(root.left).val >= root.val) {
        return false;
      }
    }
    if (root.right != null) {
      if (getMin(root.right).val <= root.val) {
        return false;
      }
    }
    if (!isValidBST(root.left) || !isValidBST(root.right)) {
      return false;
    }
    return true;
  }

  private TreeNode getMax(TreeNode node) {
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }

  private TreeNode getMin(TreeNode node) {
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  //// ---------------- end (Approach1)----------------------------
  //// ----------------start(Approach2)----------------------------
  // leetcode standard solution
  // recursion + bst definition
  public boolean helper(TreeNode node, Integer lower, Integer upper) {
    if (node == null)
      return true;

    int val = node.val;
    if (lower != null && val <= lower)
      return false;
    if (upper != null && val >= upper)
      return false;

    if (!helper(node.right, val, upper))
      return false;
    if (!helper(node.left, lower, val))
      return false;
    return true;
  }

  public boolean isValidBST(TreeNode root) {
    return helper(root, null, null);
  }
  //// ---------------- end (Approach2)----------------------------
}
// @lc code=end
