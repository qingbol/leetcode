/*
 * @lc app=leetcode id=337 lang=java
 *
 * [337] House Robber III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ---------------start(Approach1)-------------------------
  // 20200317
  // actually, this ia s dp problem. I can't figure it out myself.
  // naive dp without memorization
  // Your runtime beats 21.92 % of java submissions
  public int rob1(TreeNode root) {
    // if three's no house, we can rob 0 money. This is the termination condition
    if (root == null) {
      return 0;
    }

    // calculate the amount of money from robbing childeren.
    int robChild = rob(root.left) + rob(root.right);
    // calculate the amount of money from robbing grandchildren
    int robGrandChild = 0;
    if (root.left != null) {
      robGrandChild += rob(root.left.left) + rob(root.left.right);
    }
    if (root.right != null) {
      robGrandChild += rob(root.right.left) + rob(root.right.right);
    }

    // compare the amont of money
    int max = Math.max(robGrandChild + root.val, robChild);
    return max;
  }

  //// --------------- end (Approach1)-------------------------
  //// ---------------start(Approach2)-------------------------
  // 20200317
  // dp + memorization
  // Your runtime beats 57.71 % of java submissions
  public int rob2(TreeNode root) {
    return helper2(root, new HashMap<>());
  }

  private int helper2(TreeNode node, Map<TreeNode, Integer> map) {
    if (node == null) {
      return 0;
    }
    if (map.containsKey(node)) {
      return map.get(node);
    }

    // calculate the amount of money from robbing childeren.
    int robChild = helper2(node.left, map) + helper2(node.right, map);
    // calculate the amount of money from robbing grandchildren
    int robGrandChild = 0;
    if (node.left != null) {
      robGrandChild += helper2(node.left.left, map) + helper2(node.left.right, map);
    }
    if (node.right != null) {
      robGrandChild += helper2(node.right.left, map) + helper2(node.right.right, map);
    }

    // compare the amont of money
    int max = Math.max(robGrandChild + node.val, robChild);

    map.put(node, max);
    return max;

  }

  //// --------------- end (Approach2)-------------------------
  //// ---------------start(Approach3)-------------------------
  // 20200404. dp
  // reference to
  // https://labuladong.gitbook.io/algo/dong-tai-gui-hua-xi-lie/qiang-fang-zi
  // Your runtime beats 100 % of java submissions
  public int rob(TreeNode root) {
    int[] dp = helper3(root);
    return Math.max(dp[0], dp[1]);
  }

  private int[] helper3(TreeNode node) {
    if (node == null) {
      return new int[] { 0, 0 };
    }

    int[] left = helper3(node.left);
    int[] right = helper3(node.right);

    // if root is included, then left and right child must not be included
    int robRoot = node.val + left[0] + right[0];
    int notRobRoot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    return new int[] { notRobRoot, robRoot };
  }

  //// --------------- end (Approach3)-------------------------
}
// @lc code=end
