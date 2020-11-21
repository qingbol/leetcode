/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200312)///////////////////////////////////
  ////////////////// first round(20200312)///////////////////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200312
  public int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20201116)///////////////////////
  /////////////////////////// second round(20201116)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20201116.
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
