/*
 * @lc app=leetcode id=103 lang=java
 *
 * [103] Binary Tree Zigzag Level Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ----------------start(Approach1)--------------------------
  // Your runtime beats 9.79 % of java submissions
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.offer(root);
    boolean flag = false;
    while (!queue.isEmpty()) {
      flag = !flag;
      int size = queue.size();
      List<Integer> lst = new LinkedList<>();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (flag) {
          lst.add(cur.val);
        } else {
          lst.add(0, cur.val);
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
      res.add(new LinkedList<>(lst));
    }
    return res;

  }
  //// ---------------- end (Approach1)--------------------------
  //// ----------------start(Approach2)--------------------------
  //// ---------------- end (Approach2)--------------------------
  //// ----------------start(Approach3)--------------------------
  //// ---------------- end (Approach3)--------------------------
}
// @lc code=end
