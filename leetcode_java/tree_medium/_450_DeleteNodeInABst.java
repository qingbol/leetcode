/*
 * @lc app=leetcode id=450 lang=java
 *
 * [450] Delete Node in a BST
 */

// @lc code=start
// /**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode() {}
// * TreeNode(int val) { this.val = val; }
// * TreeNode(int val, TreeNode left, TreeNode right) {
// * this.val = val;
// * this.left = left;
// * this.right = right;
// * }
// * }
// */
class Solution {
  ////////////////// first round(20200729)///////////////////////////////////
  ////////////////// first round(20200729)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200729, by myself.
  // refer to leetcode standard solution

  // 85/85 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 5.22 % of java submissions (47.2 MB)

  // public TreeNode deleteNode(TreeNode root, int key) {
  public TreeNode deleteNode1(TreeNode root, int key) {
    if (root == null)
      return root;
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else if (root.val == key) {
      // System.out.format("check1: root: %d\n", root.val);
      if (root.left == null && root.right == null) {
        // System.out.format("I'm here2");
        return null;
      } else if (root.right != null) {
        // System.out.format("check3:\n");
        TreeNode successor = getSuccessor1(root);
        root.val = successor.val;
        root.right = deleteNode(root.right, successor.val);
        // deleteNode(successor, key);
      } else if (root.left != null) {
        // System.out.format("check4:\n");
        TreeNode predecessor = getPredecessor1(root);
        root.val = predecessor.val;
        root.left = deleteNode(root.left, predecessor.val);
        // deleteNode(predecessor, key);
      }
    }
    return root;
  }

  private TreeNode getSuccessor1(TreeNode node) {
    node = node.right;
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }

  private TreeNode getPredecessor1(TreeNode node) {
    node = node.left;
    while (node.right != null) {
      node = node.right;
    }
    return node;
  }
  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // 20200729, by myself. better than approach1
  // refer to labuladong <二叉搜索树操作集锦>


  public TreeNode deleteNode(TreeNode root, int key) {
    // public TreeNode deleteNode2(TreeNode root, int key) {
    if (root == null)
      return null;
    if (root.val > key) {
      root.left = deleteNode(root.left, key);
    } else if (root.val < key) {
      root.right = deleteNode(root.right, key);
    } else {
      if (root.right == null)
        return root.left;
      if (root.left == null)
        return root.right;
      TreeNode successor = getSuccessor2(root);
      root.val = successor.val;
      root.right = deleteNode(root.right, successor.val);
    }
    return root;
  }

  private TreeNode getSuccessor2(TreeNode node) {
    node = node.right;
    while (node.left != null) {
      node = node.left;
    }
    return node;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
// @lc code=end

