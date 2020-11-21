/*
 * @lc app=leetcode id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200121)///////////////////////////////////
  ////////////////// first round(20200121)///////////////////////////////////
  //// ---------------start(Approach1)---------------------
  // 20200312
  // Iteration
  public List<List<Integer>> levelOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      List<Integer> lst = new ArrayList<>();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        lst.add(cur.val);
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      res.add(lst);
    }
    return res;
  }

  //// --------------- end (Approach1)---------------------
  //// ---------------start(Approach2)---------------------
  // 20200312
  // Recursion
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    helper2(res, root, 0);
    return res;
  }

  private void helper2(List<List<Integer>> res, TreeNode node, int level) {
    if (node == null) {
      return;
    }
    if (res.size() <= level) {
      res.add(new ArrayList<>());
    }
    res.get(level).add(node.val);
    helper2(res, node.left, level + 1);
    helper2(res, node.right, level + 1);
  }
  //// ---------------- end (Approach2)-------------------------------------
  ////////////////// second round(20201114)///////////////////////////////////
  ////////////////// second round(20201114)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  //// ---------------- end (Approach3)-------------------------------------
}
// @lc code=end
