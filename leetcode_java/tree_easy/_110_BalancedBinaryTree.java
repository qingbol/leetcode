/*
 * @lc app=leetcode id=110 lang=java
 *
 * [110] Balanced Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ---------------start(Approach1)------------------------
  // 20200312
  // by myself. top down
  // Your runtime beats 57.08 % of java submissions
  public boolean isBalanced1(TreeNode root) {
    if (root == null) {
      return true;
    }
    int leftH = getHeight(root.left);
    int rightH = getHeight(root.right);
    if (Math.abs(leftH - rightH) > 1) {
      return false;
    }
    if (!isBalanced(root.left) || !isBalanced(root.right)) {
      return false;
    }
    // System.out.format("hi: %d", hi);
    return true;
  }

  private int getHeight(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return 1 + Math.max(getHeight(node.left), getHeight(node.right));
  }

  //// --------------- end (Approach1)------------------------
  //// ---------------start(Approach2)------------------------
  // by cson
  // Your runtime beats 100 % of java submissions
  // bottom up
  // optimal
  public boolean isBalanced2(TreeNode root) {
    if (root == null) {
      return true;
    }
    return helper2(root) != -1;
  }

  private int helper2(TreeNode node) {
    if (node == null) {
      return 0;
    }
    int l = helper2(node.left);
    int r = helper2(node.right);
    if (l == -1 || r == -1 || Math.abs(l - r) > 1) {
      return -1;
    }
    return Math.max(l, r) + 1;
  }

  //// --------------- end (Approach2)------------------------
  //// ---------------start(Approach3)------------------------
  // by leetcode standard solution
  // more readable than approach2
  // Your runtime beats 57.08 % of java submissions
  // Utility class to store information from recursive calls
  final class TreeInfo {
    public final int height;
    public final boolean balanced;

    public TreeInfo(int height, boolean balanced) {
      this.height = height;
      this.balanced = balanced;
    }
  }

  // Return whether or not the tree at root is balanced while also storing
  // the tree's height in a reference variable.
  private TreeInfo isBalancedTreeHelper(TreeNode root) {
    // An empty tree is balanced and has height = -1
    if (root == null) {
      return new TreeInfo(-1, true);
    }

    // Check subtrees to see if they are balanced.
    TreeInfo left = isBalancedTreeHelper(root.left);
    if (!left.balanced) {
      return new TreeInfo(-1, false);
    }
    TreeInfo right = isBalancedTreeHelper(root.right);
    if (!right.balanced) {
      return new TreeInfo(-1, false);
    }

    // Use the height obtained from the recursive calls to
    // determine if the current node is also balanced.
    if (Math.abs(left.height - right.height) < 2) {
      return new TreeInfo(Math.max(left.height, right.height) + 1, true);
    }
    return new TreeInfo(-1, false);
  }

  public boolean isBalanced(TreeNode root) {
    return isBalancedTreeHelper(root).balanced;
  }
  //// --------------- end (Approach3)------------------------
}
// @lc code=end
