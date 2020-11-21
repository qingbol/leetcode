/*
 * @lc app=leetcode id=94 lang=java
 *
 * [94] Binary Tree Inorder Traversal
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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode cur = root;
    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      res.add(cur.val);
      cur = cur.right;
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
