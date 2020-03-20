/*
 * @lc app=leetcode id=366 lang=java
 *
 * [366] Find Leaves of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ---------------start(Approach1)-------------------------------
  // 20200316
  // by myself
  // wrong, Time Limit Exceeded
  public List<List<Integer>> findLeaves1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    // while (root != null) {
    // print(root);
    // System.out.println();
    List<Integer> lst = helper1(res, new ArrayList<>(), root);
    res.add(new ArrayList<>(lst));
    // }
    return res;
  }

  private List<Integer> helper1(List<List<Integer>> res, List<Integer> lst, TreeNode node) {
    if (node == null) {
      return lst;
    }

    helper1(res, lst, node.left);
    helper1(res, lst, node.right);
    if (node.left == null && node.right == null) {
      lst.add(node.val);
      // delete the leaf node
      // node = null;
    }

    return lst;
  }

  private void print(TreeNode node) {
    if (node == null) {
      return;
    }
    System.out.format("%d->", node.val);
    print(node.left);
    print(node.right);
  }

  //// --------------- end (Approach1)-------------------------------
  //// ---------------start(Approach2)-------------------------------
  // leetcode best solution
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    helper2(res, root);
    return res;
  }

  private int helper2(List<List<Integer>> res, TreeNode node) {
    if (node == null) {
      return -1;
    }
    int lh = helper2(res, node.left);
    int rh = helper2(res, node.right);
    int h = Math.max(lh, rh) + 1;

    if (h >= res.size()) {
      res.add(new ArrayList<>());
    }
    res.get(h).add(node.val);
    return h;
  }

  //// --------------- end (Approach2)-------------------------------
}
// @lc code=end
