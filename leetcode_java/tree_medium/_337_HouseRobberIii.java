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
  ////////////////// first round(20200317)///////////////////////////////////
  ////////////////// first round(20200317)///////////////////////////////////
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

  // public int rob(TreeNode root) {
  public int rob3(TreeNode root) {
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
  ////////////////// second round(20200814)///////////////////////////////////
  ////////////////// second round(20200814)///////////////////////////////////
  //// ---------------start(Approach4)-------------------------
  // 20200814. recursive traversal without memo.
  // refer to labuladong<团灭 LeetCode 打家劫舍问题>

  // 124/124 cases passed (790 ms)
  // Your runtime beats 15.85 % of java submissions
  // Your memory usage beats 79.29 % of java submissions (39.1 MB)

  // public int rob(TreeNode root) {
  public int rob4(TreeNode root) {
    if (root == null)
      return 0;
    // traverse
    int left = rob(root.left);
    int right = rob(root.right);
    int ll = root.left == null ? 0 : rob(root.left.left);
    int lr = root.left == null ? 0 : rob(root.left.right);
    int rl = root.right == null ? 0 : rob(root.right.left);
    int rr = root.right == null ? 0 : rob(root.right.right);
    // post-order process
    int noRob = left + right;
    int yesRob = root.val + ll + lr + rl + rr;
    return Math.max(noRob, yesRob);

  }
  //// --------------- end (Approach4)-------------------------
  //// ---------------start(Approach5)-------------------------
  // 20200814.
  // refer to labuladong<团灭 LeetCode 打家劫舍问题>

  // 124/124 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 66.68 % of java submissions (39.3 MB)

  public int rob(TreeNode root) {
    // public int rob5(TreeNode root) {
    Pair5 res = helper5(root);
    return Math.max(res.noRob, res.yesRob);
  }

  private Pair5 helper5(TreeNode node) {
    if (node == null)
      return new Pair5(0, 0);
    // post-order traversal
    Pair5 left = helper5(node.left);
    Pair5 right = helper5(node.right);
    int noRob = Math.max(left.noRob, left.yesRob) + Math.max(right.noRob, right.yesRob);
    int yesRob = node.val + left.noRob + right.noRob;

    return new Pair5(noRob, yesRob);
  }

  class Pair5 {
    int noRob;
    int yesRob;

    public Pair5(int v1, int v2) {
      noRob = v1;
      yesRob = v2;
    }
  }
  //// --------------- end (Approach5)-------------------------
}
// @lc code=end
