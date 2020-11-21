/*
 * @lc app=leetcode id=199 lang=java
 *
 * [199] Binary Tree Right Side View
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200315)///////////////////////////////////
  ////////////////// first round(20200315)///////////////////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200315
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    if (root == null) {
      return res;
    }

    Queue<TreeNode> queue = new ArrayDeque<>();

    queue.offer(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();
        if (i == size - 1) {
          res.add(cur.val);
        }
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
      }
    }
    return res;
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20201116)///////////////////////
  /////////////////////////// second round(20201116)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20201116.
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
