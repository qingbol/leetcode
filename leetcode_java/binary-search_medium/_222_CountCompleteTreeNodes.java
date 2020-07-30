/*
 * @lc app=leetcode id=222 lang=java
 *
 * [222] Count Complete Tree Nodes
 */

// @lc code=start
// /**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode() {}
// * TreeNode(int val) { this.val = val; }
// * TreeNode(int val, TreeNode left, TreeNode right) {
// * this.val = val;
// * this.left = left;
// * this.right = right;
// * }
// * }
// */
class Solution {
  ////////////////// first round(20200729)///////////////////////////////////
  ////////////////// first round(20200729)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  //20200729. 
  //refer to labuladong <如何计算完全二叉树的节点数>

//   18/18 cases passed (0 ms)
// Your runtime beats 100 % of java submissions
// Your memory usage beats 9.16 % of java submissions (42.5 MB)

  public int countNodes(TreeNode root) {
    // public int countNodes1(TreeNode root) {
    TreeNode l = root, r = root;
    int lh = 0, rh = 0;
    while (l != null) {
      l = l.left;
      lh++;
    }
    while (r != null) {
      r = r.right;
      rh++;
    }

    if (lh == rh)
      return (int) Math.pow(2, lh) - 1;
    return 1 + countNodes(root.left) + countNodes(root.right);
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end

