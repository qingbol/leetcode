/*
 * @lc app=leetcode id=129 lang=java
 *
 * [129] Sum Root to Leaf Numbers
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ---------------start(Approach1)---------------------
  // preorder with a global variable
  int res = 0;

  public int sumNumbers1(TreeNode root) {
    helper1(root, 0);
    return res;
  }

  private void helper1(TreeNode cur, int num) {
    if (cur == null) {
      return;
    }
    num = num * 10 + cur.val;
    if (cur.left == null && cur.right == null) {
      res += num;
    }
    helper1(cur.left, num);
    helper1(cur.right, num);
  }

  //// --------------- end (Approach1)---------------------
  //// ---------------start(Approach2)---------------------
  // preorder without global variable
  public int sumNumbers(TreeNode root) {
    return helper2(root, 0);
  }

  private int helper2(TreeNode cur, int num) {
    if (cur == null) {
      return 0;
    }
    if (cur.left == null && cur.right == null) {
      return num * 10 + cur.val;
    }

    return helper2(cur.left, num * 10 + cur.val) + helper2(cur.right, num * 10 + cur.val);
  }

  //// --------------- end (Approach2)---------------------
}
// @lc code=end
