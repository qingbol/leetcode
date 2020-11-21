/*
 * @lc app=leetcode id=285 lang=java
 *
 * [285] Inorder Successor in BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200318)///////////////////////////////////
  ////////////////// first round(20200318)///////////////////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200318, bymyself. inorder iterative + a boolean flag
  // Your runtime beats 29.43 % of java submissions
  public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode node = root;
    boolean flag = false;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      // System.out.format("stack:%s\n", stack);
      node = stack.pop();
      // System.out.format("node: %d\n", node.val);
      if (flag == true) {
        return node;
      }
      if (node == p) {
        flag = true;
      }
      // if (node.right != null) {
      node = node.right;
      // stack.push(node.right);
      // }
    }
    return null;
  }

  // -------------- end (Approach1)------------------------------
  // --------------start(Approach2)------------------------------
  // leetcode standard approach.
  // Approach 1: Iterative Inorder Traversal
  // Your runtime beats 89.33 % of java submissions
  public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
    // successor is somewhere lower in the right tree;
    if (p.right != null) {
      p = p.right;
      while (p.left != null) {
        p = p.left;
      }
      return p;
    }

    // successor is somewhere upper in the tree
    Deque<TreeNode> stack = new ArrayDeque<>();

    TreeNode node = root;
    TreeNode predecessor = null;
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }
      node = stack.pop();
      if (predecessor == p) {
        // if (predecessor != null && predecessor.val == p.val) {
        return node;
      }
      predecessor = node;
      node = node.right;
    }
    return null;
  }

  // -------------- end (Approach2)------------------------------
  // --------------start(Approach3)------------------------------
  // 20200318, Binary search + recursion
  //
  public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
    if (root == null) {
      return null;
    }
    if (p.val >= root.val) {
      return inorderSuccessor(root.right, p);
    } else {
      TreeNode l = inorderSuccessor(root.left, p);
      if (l == null) {
        return root;
      } else {
        return l;
      }
    }
  }

  // -------------- end (Approach3)------------------------------
  // --------------start(Approach4)------------------------------
  // 20200318, Binary search + iteration
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    TreeNode res = null;
    while (root != null) {
      if (p.val >= root.val) {
        root = root.right;
      } else {
        res = root;
        root = root.left;
      }
    }
    return res;
  }

  //// ---------------- end (Approach4)----------------------------------
  /////////////////////////// second round(20201117)///////////////////////
  /////////////////////////// second round(20201117)///////////////////////
  //// ----------------start(Approach5)----------------------------------
  // 20201117.
  //// ---------------- end (Approach5)----------------------------------
}
// @lc code=end
