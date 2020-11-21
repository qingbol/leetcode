/*
 * @lc app=leetcode id=230 lang=java
 *
 * [230] Kth Smallest Element in a BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200314)///////////////////////////////////
  ////////////////// first round(20200314)///////////////////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200314
  // by myself. inorder recursion
  // wrong
  public int kthSmallest1(TreeNode root, int k) {
    // int res = -1;
    System.out.format("val:%d, k: %d\n", root.val, k);
    if (root == null) {
      return -1;
    }
    if (root.left != null) {
      kthSmallest(root.left, k);
    }
    k--;
    if (k == 0) {
      System.out.format("root.val:%d\n", root.val);
      return root.val;
    }
    if (root.right != null) {
      kthSmallest(root.right, k);
    }
    return -1;
  }

  // --------------------- end (Approach1)----------------------------
  // ---------------------start(Approach2)----------------------------
  // use inorder recursion + global variables
  private static int res = 0;
  private static int count = 0;

  public int kthSmallest2(TreeNode root, int k) {
    count = k;
    helper2(root);
    return res;
  }

  private void helper2(TreeNode node) {
    if (node.left != null) {
      helper2(node.left);
    }
    count--;
    if (count == 0) {
      res = node.val;
      return;
    }
    if (node.right != null) {
      helper2(node.right);
    }
  }

  // --------------------- end (Approach2)----------------------------
  // ---------------------start(Approach3)----------------------------
  // inorder iteration
  // optimal
  public int kthSmallest3(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (!stack.isEmpty() || cur != null) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }

      cur = stack.pop();
      k--;
      if (k == 0) {
        return cur.val;
      }
      cur = cur.right;
    }
    return -1;
  }

  // --------------------- end (Approach3)----------------------------
  // ---------------------start(Approach4)----------------------------
  // binary search method
  public int kthSmallest(TreeNode root, int k) {
    int l = countNodes(root.left);
    if (l == k - 1) {
      return root.val;
    }
    if (l < k - 1) {
      return kthSmallest(root.right, k - l - 1);
    } else {
      return kthSmallest(root.left, k);
    }
  }

  private int countNodes(TreeNode node) {
    if (node == null) {
      return 0;
    }
    return countNodes(node.left) + countNodes(node.right) + 1;
  }
  //// ---------------- end (Approach4)----------------------------------
  /////////////////////////// second round(20201117)///////////////////////
  /////////////////////////// second round(20201117)///////////////////////
  //// ----------------start(Approach5)----------------------------------
  // 20201117.
  //// ---------------- end (Approach5)----------------------------------
}
// @lc code=end
