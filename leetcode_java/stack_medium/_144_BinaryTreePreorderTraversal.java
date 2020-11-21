/*
 * @lc app=leetcode id=144 lang=java
 *
 * [144] Binary Tree Preorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200312)///////////////////////////////////
  ////////////////// first round(20200312)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200312
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Deque<TreeNode> stack = new ArrayDeque<>();

    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      res.add(cur.val);
      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }
    }
    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200916)///////////////////////////////////
  ////////////////// second round(20200916)///////////////////////////////////
  //20201114
  //// ----------------start(Approach2)-------------------------------------

  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
