/*
 * @lc app=leetcode id=111 lang=java
 *
 * [111] Minimum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ----------------start(Approach1)----------------------
  // 20200316
  // by myselft
  // preorder + global variable
  // Define the depth of the leaf to highest, not quite right
  int res = Integer.MAX_VALUE;

  public int minDepth1(TreeNode root) {
    if (root == null) {
      return 0;
    }
    helper1(root, 0);
    return res;
  }

  private void helper1(TreeNode cur, int depth) {
    if (cur == null) {
      return;
    }
    depth++;
    if (cur.left == null && cur.right == null) {
      res = Math.min(res, depth);
    }
    helper1(cur.left, depth);
    helper1(cur.right, depth);
  }

  //// ---------------- end (Approach1)----------------------
  //// ----------------start(Approach2)----------------------
  // 20200316
  // preoder without global variable
  // Define the depth of the leaf to highest, not quite right
  public int minDepth2(TreeNode root) {
    return helper2(root, 0);
  }

  private int helper2(TreeNode cur, int depth) {
    if (cur == null) {
      return 0;
    }
    depth++;
    if (cur.left == null && cur.right == null) {
      return depth;
    }

    int l = helper2(cur.left, depth);
    int r = helper2(cur.right, depth);
    return (l == 0 || r == 0) ? l + r : Math.min(l, r);
  }

  //// ---------------- end (Approach2)----------------------
  //// ----------------start(Approach3)----------------------
  // 20200316
  // more concise version of Approach2
  public int minDepth3(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int l = minDepth(root.left);
    int r = minDepth(root.right);
    return (l == 0 || r == 0) ? l + r + 1 : Math.min(l, r) + 1;
  }

  //// ---------------- end (Approach3)----------------------
  //// ----------------start(Approach4)----------------------
  // Define the depth of the leaf to 1, right
  public int minDepth4(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null && root.right == null) {
      return 1;
    }

    int minDepth = Integer.MAX_VALUE;
    if (root.left != null) {
      minDepth = Math.min(minDepth, minDepth(root.left));
    }
    if (root.right != null) {
      minDepth = Math.min(minDepth, minDepth(root.right));
    }
    return minDepth + 1;
  }

  //// ---------------- end (Approach4)----------------------
  //// ----------------start(Approach5)----------------------
  public int minDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }
    if (root.left == null) {
      return minDepth(root.right) + 1;
    }
    if (root.right == null) {
      return minDepth(root.left) + 1;
    }
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
  }
  //// ---------------- end (Approach5)----------------------
}
// @lc code=end
