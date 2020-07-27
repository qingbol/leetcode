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
  //////////////// first round(20200315)////////////////////////
  //////////////// first round(20200315)////////////////////////
  //// ---------------start(Approach1)-------------------------
  // 20200315
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
  // 20200315
  // postorder
  // correct

  // public int maxPathSum(TreeNode root) {
  public int maxPathSum2(TreeNode root) {
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
  //// --------------- end (Approach2)-------------------------
  //////////////// second round(20200722)////////////////////////
  //////////////// second round(20200722)////////////////////////
  //// ---------------start(Approach3)-------------------------
  // 20200722. by myself, wrong

//   Wrong Answer
// 44/93 cases passed (N/A)
// Testcase
// [-3]

  public int maxPathSum3(TreeNode root) {
  // public int maxPathSum(TreeNode root) {
    if (root == null)
      return 0;
    int sum = 0;

    // int leftSum = maxPathSum3(root.left);
    int leftSum = maxPathSum(root.left);
    // int rightSum = maxPathSum3(root.right);
    int rightSum = maxPathSum(root.right);

    if (root.val > 0) {
      sum += root.val;
      if (leftSum > 0)
        sum += leftSum;
      if (rightSum > 0)
        sum += rightSum;
    } else {
      sum = Math.max(leftSum, rightSum);
    }

    return sum;
  }
  //// --------------- end (Approach3)-------------------------
  //// ---------------start(Approach4)-------------------------
  // 20200722, refer to leetcode standard solution

//   93/93 cases passed (1 ms)
// Your runtime beats 48.99 % of java submissions
// Your memory usage beats 5.03 % of java submissions (45.7 MB)

  // public int maxPathSum4(TreeNode root) {
  public int maxPathSum(TreeNode root) {
    int[] maxSum = new int[]{Integer.MIN_VALUE};
    maxGain4(root, maxSum);
    return maxSum[0];
  }

  private int maxGain4(TreeNode node, int[] maxSum) {
    if (node == null) return 0;
    int leftGain = Math.max(0, maxGain4(node.left, maxSum));
    int rightGain = Math.max(0, maxGain4(node.right, maxSum));
    
    int newPathSum = node.val + leftGain + rightGain;
    maxSum[0] = Math.max(maxSum[0], newPathSum);

    return node.val + Math.max(leftGain, rightGain);

  }
  //// --------------- end (Approach4)-------------------------

}
// @lc code=end
