/*
 * @lc app=leetcode id=112 lang=java
 *
 * [112] Path Sum
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(2020314)///////////////////////
  /////////////////////////// first round(2020314)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200413
  /*****************************************************
   * Approach1: By myself wrong: node == null is not a right way to determine a
   * leaf.
   *****************************************************/
  public boolean hasPathSum1(TreeNode root, int sum) {
    if (root == null) {
      return false;
    }
    return helper1(root, sum);
  }

  private boolean helper1(TreeNode node, int sum) {
    if (node == null) {
      if (sum == 0) {
        return true;
      } else {
        return false;
      }
    }
    if (helper1(node.left, sum - node.val) || helper1(node.right, sum - node.val)) {
      return true;
    }
    return false;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  /*****************************************************
   * Approach2: use (node.left == null && node.righ == null) to determin a leaf
   *****************************************************/
  public boolean hasPathSum(TreeNode root, int sum) {
    return helper2(root, sum);
  }

  private boolean helper2(TreeNode node, int sum) {
    if (node == null) {
      return false;
    }
    if (node.left == null && node.right == null) {
      if (sum == node.val) {
        return true;
      } else {
        return false;
      }
    }
    if (helper2(node.left, sum - node.val) || helper2(node.right, sum - node.val)) {
      return true;
    }
    return false;
  }
  //// ---------------- end (Appraoch2)----------------------------------
  /////////////////////////// second round(20201115)///////////////////////
  /////////////////////////// second round(20201115)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  // 20201115.
  //// ---------------- end (Appraoch3)----------------------------------
}
// @lc code=end
