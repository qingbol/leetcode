/*
 * @lc app=leetcode id=270 lang=java
 *
 * [270] Closest Binary Search Tree Value
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200317)///////////////////////////////////
  ////////////////// first round(20200317)///////////////////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200317
  // by myself. The stack is unnecessary
  // Your runtime beats 5.44 % of java submissions
  public int closestValue1(TreeNode root, double target) {
    if (root == null) {
      return 0;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode res = root;
    double diff = Math.abs(target - root.val);

    stack.push(root);
    // System.out.format("a");
    while (!stack.isEmpty()) {
      // System.out.format("b");
      TreeNode cur = stack.pop();
      // System.out.format("c");

      if (Math.abs(target - cur.val) < diff) {
        diff = Math.abs(target - cur.val);
        // System.out.format("diff:%f\n", diff);
        res = cur;
      }
      // System.out.format("d");
      if (cur.val > target && cur.left != null) {
        stack.push(cur.left);
      } else if (cur.val < target && cur.right != null) {
        stack.push(cur.right);
      } else if (cur.val == target) {
        System.out.format("=");
        return cur.val;
      }
    }
    return res.val;
  }

  //// ------------- end (Approach1)--------------------------
  //// -------------start(Approach2)--------------------------
  // 20200317
  // bs. without stack
  public int closestValue(TreeNode root, double target) {
    Double diff = Double.MAX_VALUE;
    int res = 0;

    TreeNode cur = root;
    while (cur != null) {
      if (Math.abs(target - cur.val) < diff) {
        diff = Math.abs(target - cur.val);
        res = cur.val;
      }
      if (cur.val < target) {
        cur = cur.right;
      } else if (cur.val > target) {
        cur = cur.left;
      } else {
        break;
      }
    }
    return res;
  }
  //// ---------------- end (Approach2)----------------------------------
  /////////////////////////// second round(20201117)///////////////////////
  /////////////////////////// second round(20201117)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201117.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
