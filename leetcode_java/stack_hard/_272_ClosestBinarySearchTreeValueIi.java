import java.util.Deque;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=272 lang=java
 *
 * [272] Closest Binary Search Tree Value II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ------------------start(Approach1)-----------------------
  // 20200318. By myself. preorder iteracion + pq
  // Your runtime beats 12.16 % of java submissions
  // This method don't use the bst information. So it's very slow.
  // we can use inorder to get the sorted sequence.
  // In that way we can avoid the pq.poll() overhead for every node.
  public List<Integer> closestKValues1(TreeNode root, double target, int k) {
    List<Integer> res = new ArrayList<>();
    PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) -> b.getValue().compareTo(a.getValue()));
    // PriorityQueue<Pair<Integer, Double>> pq = new PriorityQueue<>((a, b) ->
    // b.getValue() - a.getValue());
    double diff = Double.MAX_VALUE;

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);
    while (!stack.isEmpty()) {
      TreeNode cur = stack.pop();
      if (pq.size() < k) {
        pq.offer(new Pair(cur.val, Math.abs(target - cur.val)));
      } else {
        diff = Math.abs(target - cur.val);
        if (diff < pq.peek().getValue()) {
          pq.poll();
          pq.offer(new Pair(cur.val, diff));
        }
      }

      if (cur.right != null) {
        stack.push(cur.right);
      }
      if (cur.left != null) {
        stack.push(cur.left);
      }
    }

    while (!pq.isEmpty()) {
      res.add(pq.poll().getKey());
    }
    return res;
  }

  //// ------------------ end (Approach1)-----------------------
  //// ------------------start(Approach2)-----------------------
  // 20200318, inorder recursion
  // Your runtime beats 100 % of java submissions
  public List<Integer> closestKValues2(TreeNode root, double target, int k) {
    LinkedList<Integer> res = new LinkedList<>();
    helper2(res, root, target, k);
    return res;
  }

  private void helper2(LinkedList<Integer> res, TreeNode node, double target, int k) {
    if (node == null) {
      return;
    }
    helper2(res, node.left, target, k);
    if (res.size() < k) {
      res.add(node.val);
    } else {
      if (Math.abs(node.val - target) < Math.abs(res.peek() - target)) {
        res.poll();
        res.add(node.val);
      } else {
        // pruning
        return;
      }
    }
    helper2(res, node.right, target, k);
  }

  //// ------------------ end (Approach2)-----------------------
  //// ------------------start(Approach3)-----------------------
  // 20200318, hard to come up.
  // o(logn)
  // Your runtime beats 63.8 % of java submissions
  public List<Integer> closestKValues(TreeNode root, double target, int k) {
    List<Integer> res = new ArrayList<>();
    Deque<TreeNode> pred = new ArrayDeque<>();
    Deque<TreeNode> succ = new ArrayDeque<>();

    initPred(pred, root, target);
    initSucc(succ, root, target);
    // System.out.format("a");

    if (!pred.isEmpty() && !succ.isEmpty() && pred.peek().val == succ.peek().val) {
      // System.out.format("b");
      getNextPred(pred);
    }
    // System.out.format("c");

    while (k-- > 0) {
      if (pred.isEmpty()) {
        // System.out.format("d");
        res.add(getNextSucc(succ));
      } else if (succ.isEmpty()) {
        // System.out.format("e");
        res.add(getNextPred(pred));
      } else {
        // System.out.format("f");
        double predDiff = Math.abs(target - (double) pred.peek().val);
        double succDiff = Math.abs(target - (double) succ.peek().val);
        if (predDiff < succDiff) {
          res.add(getNextPred(pred));
        } else {
          res.add(getNextSucc(succ));
        }
      }
    }
    return res;
  }

  private void initPred(Deque<TreeNode> pred, TreeNode node, double target) {
    while (node != null) {
      if (node.val == target) {
        pred.push(node);
        break;
      } else if (node.val < target) {
        pred.push(node);
        node = node.right;
      } else {
        node = node.left;
      }
    }
  }

  private void initSucc(Deque<TreeNode> succ, TreeNode node, double target) {
    while (node != null) {
      if (node.val == target) {
        succ.push(node);
        break;
      } else if (node.val > target) {
        succ.push(node);
        node = node.left;
      } else {
        node = node.right;
      }
    }
  }

  private int getNextPred(Deque<TreeNode> pred) {
    TreeNode cur = pred.poll();
    int ret = cur.val;
    cur = cur.left;
    while (cur != null) {
      pred.push(cur);
      cur = cur.right;
    }
    return ret;
  }

  private int getNextSucc(Deque<TreeNode> succ) {
    TreeNode cur = succ.poll();
    int ret = cur.val;
    cur = cur.right;
    while (cur != null) {
      succ.push(cur);
      cur = cur.left;
    }
    return ret;
  }

  //// ------------------ end2(Approach3)-----------------------

}
// @lc code=end
