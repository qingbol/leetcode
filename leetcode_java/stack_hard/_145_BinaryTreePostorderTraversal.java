/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200121)///////////////////////////////////
  ////////////////// first round(20200121)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200312
  // public List<Integer> postorderTraversal(TreeNode root) {
  public List<Integer> postorderTraversal1(TreeNode root) {
    LinkedList<Integer> res = new LinkedList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.addFirst(cur.val);
      if (cur.left != null) {
        stack.push(cur.left);
      }
      if (cur.right != null) {
        stack.push(cur.right);
      }
    }
    return res;
  }

  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200916)///////////////////////////////////
  ////////////////// second round(20200916)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  // 20201114
  // Approach 3: Iterative Postorder Traversal

  // 68/68 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 63.51 % of java submissions (37.3 MB)

  public List<Integer> postorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    List<Integer> res = new ArrayList<>();
    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        if (root.right != null) {
          stack.push(root.right);
        }
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // if root is not the leftmost node
      if (!stack.isEmpty() && root.right == stack.peek()) {
        stack.pop();
        stack.push(root);
        root = root.right;
      } else {
        res.add(root.val);
        root = null;
      }
    }
    return res;
  }

  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
