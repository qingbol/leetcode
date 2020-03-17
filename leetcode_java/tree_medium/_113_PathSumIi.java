/*
 * @lc app=leetcode id=113 lang=java
 *
 * [113] Path Sum II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    List<List<Integer>> res = new ArrayList<>();
    helper1(res, new ArrayList<>(), root, sum);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, TreeNode node, int sum) {
    if (node == null) {
      return;
    }
    sum -= node.val;
    lst.add(node.val);
    if (node.left == null && node.right == null) {
      if (sum == 0) {
        res.add(new ArrayList<>(lst));
      }
    }
    helper1(res, lst, node.left, sum);
    // lst.remove(lst.size() - 1);
    helper1(res, lst, node.right, sum);
    lst.remove(lst.size() - 1);
  }
}
// @lc code=end
