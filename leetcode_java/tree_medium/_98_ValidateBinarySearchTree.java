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
  ////////////////// first round(20200312)///////////////////////////////////
  ////////////////// first round(20200312)///////////////////////////////////
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

  // public boolean isValidBST(TreeNode root) {
  public boolean isValidBST2(TreeNode root) {
    return helper(root, null, null);
  }

  //// ---------------- end (Approach2)----------------------------
  ////////////////// second round(20200728)///////////////////////////////////
  ////////////////// second round(20200728)///////////////////////////////////
  //// ----------------start(Approach3)----------------------------
  // 20200312
  //refer to labuladong <二叉搜索树操作集锦>
  // Your runtime beats 100 % of java submissions
  public boolean isValidBST(TreeNode root) {
    // public boolean isValidBST3(TreeNode root) {
    return helper3(root, null, null);
  }

  private boolean helper3(TreeNode node, TreeNode lower, TreeNode upper) {
    if (node == null)
      return true;
    if (lower != null && node.val <= lower.val)
      return false;
    if (upper != null && node.val >= upper.val)
      return false;

    return helper3(node.left, lower, node) && helper3(node.right, node, upper);
  }
  //// ---------------- end (Approach2)----------------------------
}
// @lc code=end
