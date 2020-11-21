/*
 * @lc app=leetcode id=314 lang=java
 *
 * [314] Binary Tree Vertical Order Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200319)///////////////////////////////////
  ////////////////// first round(20200319)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200319, bymyselft, DFS
  // dfs is worng. becausel it violate the rule of from top to bottom
  // 201/212 cases passed (N/A)
  // [3,9,8,4,0,1,7,null,null,null,2,5]
  public List<List<Integer>> verticalOrder1(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    // Map<Integer, List<Integer>> map = new HashMap<>();

    Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
    stack.push(new Pair(root, 0));

    while (!stack.isEmpty()) {
      Pair<TreeNode, Integer> curPair = stack.pop();
      TreeNode curr = curPair.getKey();
      int col = curPair.getValue();
      map.putIfAbsent(col, new ArrayList<>());
      map.get(col).add(curr.val);

      if (curr.right != null) {
        stack.push(new Pair(curr.right, col + 1));
      }
      if (curr.left != null) {
        stack.push(new Pair(curr.left, col - 1));
      }
    }

    // output
    // for (List<Integer> lst : map.values()) {
    // System.out.format("lst:%s\n", lst);
    // }
    res.addAll(map.values());
    return res;
  }

  //// ----------------- end (Approach1)------------------------
  //// -----------------start(Approach2)------------------------
  // 20200319, BFS
  // Your runtime beats 21.09 % of java submissions
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> res = new ArrayList<>();
    if (root == null) {
      return res;
    }
    TreeMap<Integer, List<Integer>> map = new TreeMap<>();
    // Map<Integer, List<Integer>> map = new HashMap<>();

    Queue<Pair<TreeNode, Integer>> queue = new ArrayDeque<>();
    queue.offer(new Pair(root, 0));

    while (!queue.isEmpty()) {
      Pair<TreeNode, Integer> curPair = queue.poll();
      TreeNode curr = curPair.getKey();
      int col = curPair.getValue();
      map.putIfAbsent(col, new ArrayList<>());
      map.get(col).add(curr.val);

      if (curr.left != null) {
        queue.offer(new Pair(curr.left, col - 1));
      }
      if (curr.right != null) {
        queue.offer(new Pair(curr.right, col + 1));
      }
    }

    // output
    // for (List<Integer> lst : map.values()) {
    // System.out.format("lst:%s\n", lst);
    // }
    res.addAll(map.values());
    return res;
  }
  //// ---------------- end (Approach2)----------------------------------
  /////////////////////////// second round(20201118)///////////////////////
  /////////////////////////// second round(20201118)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201118.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
