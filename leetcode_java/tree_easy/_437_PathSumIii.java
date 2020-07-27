/*
 * @lc app=leetcode id=437 lang=java
 *
 * [437] Path Sum III
 */

// @lc code=start
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
class Solution {
  //// ------------start(Approach1)--------------------------
  //20200718.
    //refer to <labladong 递归详解>
    //https://labuladong.gitbook.io/algo/suan-fa-si-wei-xi-lie/di-gui-xiang-jie
    // 126/126 cases passed (20 ms)
    // Your runtime beats 52.32 % of java submissions
  public int pathSum(TreeNode root, int sum) {
    if (root == null)
      return 0;
    int rootPathSum = count(root, sum);
    int leftPathSum = pathSum(root.left, sum);
    int rightPathSum = pathSum(root.right, sum);
    return rootPathSum + leftPathSum + rightPathSum;
  }

  private int count(TreeNode node, int val) {
    if (node == null)
      return 0;
    int findOne = node.val == val ? 1 : 0;
    int leftCount = count(node.left, val - node.val);
    int rightCount = count(node.right, val - node.val);
    return findOne + leftCount + rightCount;
  }

  //// ------------ end (Approach1)--------------------------
  //// ------------start(Approach2)--------------------------
  public int pathSum2(TreeNode root, int sum) {
    return 0;
  }
  //// ------------ end (Approach2)--------------------------
}
// @lc code=end
