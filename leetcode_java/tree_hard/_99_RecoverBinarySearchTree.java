/*
 * @lc app=leetcode id=99 lang=java
 *
 * [99] Recover Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// --------------start(Approach1)---------------------
  // 20200318, leetcode's standard solution. inorder iteration
  public void recoverTree1(TreeNode root) {
    TreeNode pred = null;
    TreeNode firstMistake = null;
    TreeNode secondMistake = null;

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode node = root;
    while (node != null || !stack.isEmpty()) {
      while (node != null) {
        stack.push(node);
        node = node.left;
      }

      node = stack.pop();
      // logic part
      if (pred != null && pred.val >= node.val) {
        secondMistake = node;
        if (firstMistake == null) {
          firstMistake = pred;
        } else {
          break;
        }
      }
      pred = node;

      // traverse the right subtree
      node = node.right;
    }

    // swap the two incorrect elements
    int temp = firstMistake.val;
    firstMistake.val = secondMistake.val;
    secondMistake.val = temp;
  }

  //// -------------- end (Approach1)---------------------
  //// --------------start(Approach2)---------------------
  // 20200318 Morris inorder
  public void recoverTree(TreeNode root) {
    TreeNode pred = null;
    TreeNode firstMistake = null;
    TreeNode secondMistake = null;
    TreeNode morrisPred = null;

    while (root != null) {
      // if root.left != null, find root's predecessor.
      if (root.left != null) {
        morrisPred = root.left;
        while (morrisPred.right != null && morrisPred.right != root) {
          morrisPred = morrisPred.right;
        }
        // check the predecessor link, if null, set it. if not null, break it.
        if (morrisPred.right == null) {
          morrisPred.right = root;
          root = root.left;
        } else {
          // logical part
          if (pred != null && pred.val >= root.val) {
            secondMistake = root;
            if (firstMistake == null) {
              firstMistake = pred;
              // } else {
              // break;
            }
          }
          pred = root;
          // break predecessor link
          morrisPred.right = null;
          root = root.right;
        }
        // if the root.left == null, just go right
      } else {
        if (pred != null && pred.val >= root.val) {
          secondMistake = root;
          if (firstMistake == null) {
            firstMistake = pred;
            // } else {
            // break;
          }
        }
        pred = root;
        root = root.right;
      }
    }

    // swap the two incorrect elements
    int tmp = firstMistake.val;
    firstMistake.val = secondMistake.val;
    secondMistake.val = tmp;
  }

  //// -------------- end (Approach2)---------------------
}
// @lc code=end
