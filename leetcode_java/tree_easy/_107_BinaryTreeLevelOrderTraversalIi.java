import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=107 lang=java
 *
 * [107] Binary Tree Level Order Traversal II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  // ----------------------start(Approach1)-------------------
  // 20200316
  // by myself. bfs
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> res = new LinkedList<>();
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
      res.addFirst(new ArrayList<>(lst));
    }

    return res;
  }

  // ----------------------start(Approach2)-------------------
  // dfs, by leetcode discussion
  public List<List<Integer>> levelOrderBottom2(TreeNode root) {
    List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
    levelMaker(wrapList, root, 0);
    return wrapList;
  }

  public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
    if (root == null)
      return;
    if (level >= list.size()) {
      list.add(0, new LinkedList<Integer>());
    }
    levelMaker(list, root.left, level + 1);
    levelMaker(list, root.right, level + 1);
    list.get(list.size() - level - 1).add(root.val);
  }
  // ---------------------- end (Approach2)-------------------
}
// @lc code=end
