/*
 * @lc app=leetcode id=124 lang=java
 *
 * [124] Binary Tree Maximum Path Sum
 */

// @lc code=start
// prettier-ignore
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ---------------start(Approach1)------------------
  // by myself.postorder + recursion
  // wrong.
  int res = Integer.MIN_VALUE;

  public int maxPathSum1(TreeNode root) {
    int sum = 0;
    helper1(root, sum);
    return res;
  }

  private int helper1(TreeNode node, int sum) {
    if (node == null) {
      return 0;
    }
    int l = 0;
    int r = 0;
    if (node.left != null) {
      l = helper1(node.left, sum);
    }
    if (node.right != null) {
      r = helper1(node.right, sum);
    }
    sum += l > 0 ? l : 0;
    sum += r > 0 ? r : 0;
    sum += node.val;
    System.out.format("sum:%d\n", sum);
    res = Math.max(res, sum);
    return sum;
  }

  //// --------------- end (Approach1)------------------
  //// ---------------start(Approach1)------------------
  public int maxPathSum(TreeNode root) {
    helper2(root);
    return res;
  }

  private int helper2(TreeNode cur) {
    if (cur == null) {
      return 0;
    }
    int l = helper2(cur.left);
    int r = helper2(cur.right);
    // cal the sum rooted at cur.
    int nodeSum = cur.val;
    nodeSum += l > 0 ? l : 0;
    nodeSum += r > 0 ? r : 0;
    // System.out.format("nodeSum:%d\n", nodeSum);
    res = Math.max(res, nodeSum);
    // cal the sum rooted at the ancestor of cur
    int branchSum = cur.val;
    branchSum += Math.max(l, r) > 0 ? Math.max(l, r) : 0;
    return branchSum;
  }
  //// ---------------start(Approach1)------------------
  //// ---------------start(Approach1)------------------
  //// ---------------start(Approach1)------------------

}
// @lc code=end
