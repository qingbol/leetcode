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
  ////////////////// first round(20200316)///////////////////////////////////
  ////////////////// first round(20200316)///////////////////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200316
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
  //// ---------------- end (Appraoch2)----------------------------------
  /////////////////////////// second round(20201115)///////////////////////
  /////////////////////////// second round(20201115)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  // 20201115.
  //// ---------------- end (Appraoch3)----------------------------------
}
// @lc code=end
