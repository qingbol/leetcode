/*
 * @lc app=leetcode id=236 lang=java
 *
 * [236] Lowest Common Ancestor of a Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200317)///////////////////////////////////
  ////////////////// first round(20200317)///////////////////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200317
  // by myselft. In a top-down, preorder way, which is bad.
  // 9/31 cases passed (N/A)
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {

    if (root.left != null) {
      return lowestCommonAncestor(root.left, p, q);
    }
    if (root.right != null) {
      return lowestCommonAncestor(root.right, p, q);
    }
    if ((root.val == p.val || helper1(root.left, p)) && (root.val == q.val || helper1(root.right, q))) {
      return root;
    }
    if ((root.val == q.val || helper1(root.left, q)) && (root.val == p.val || helper1(root.right, p))) {
      return root;
    }
    return null;
  }

  private boolean helper1(TreeNode node, TreeNode t) {
    if (node == null) {
      return false;
    }
    if (node.val == t.val) {
      return true;
    }
    helper1(node.left, t);
    helper1(node.right, t);
    return false;
  }

  //// ------------------------- end (Approach1)---------------------
  //// -------------------------start(Approach2)---------------------
  // 20200317
  // refer to the best solution in leetcode
  // preorder + postorder
  // This approach is right only if both values will exist in the binary tree.
  // Your runtime beats 73.47 % of java submissions
  public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    return helper2(root, p, q);
  }

  private TreeNode helper2(TreeNode cur, TreeNode p, TreeNode q) {
    // termination condition
    if (cur == null) {
      return null;
    }
    // preorder part
    if (cur == p || cur == q) {
      return cur;
    }

    // check in post order
    TreeNode l = helper2(cur.left, p, q);
    TreeNode r = helper2(cur.right, p, q);

    // post order part

    // verbose version return
    // TreeNode ret = null;
    // if (l == null && r == null) {
    // ret = null;
    // } else if (l == null && r != null) {
    // ret = r;
    // } else if (l != null && r == null) {
    // ret = l;
    // } else if (l != null && r != null) {
    // ret = cur;
    // }
    // return ret;

    // concise version return
    if (l != null && r != null) {
      return cur;
    }
    return l == null ? r : l;
  }

  //// ------------------------- end (Approach2)---------------------
  //// -------------------------start(Approach3)---------------------
  // 20200317
  // Approach 1: Recursive Approach
  // Your runtime beats 73.47 % of java submissions
  TreeNode res = null;

  public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
    helper3(root, p, q);
    return res;
  }

  private boolean helper3(TreeNode node, TreeNode p, TreeNode q) {
    if (node == null) {
      return false;
    }

    int l = helper3(node.left, p, q) ? 1 : 0;
    int r = helper3(node.right, p, q) ? 1 : 0;
    int m = (node == p || node == q) ? 1 : 0;

    if (l + r + m > 1) {
      res = node;
    }
    return (l + r + m) > 0;
  }

  //// ------------------------- end (Approach3)---------------------
  //// -------------------------start(Approach4)---------------------
  // Approach 2: Iterative using parent pointers
  // Your runtime beats 20.48 % of java submissions
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    Map<TreeNode, TreeNode> parent = new HashMap<>();

    stack.push(root);
    parent.put(root, null);

    while (!parent.containsKey(p) || !parent.containsKey(q)) {
      TreeNode cur = stack.pop();

      if (cur.left != null) {
        stack.push(cur.left);
        parent.put(cur.left, cur);
      }
      if (cur.right != null) {
        stack.push(cur.right);
        parent.put(cur.right, cur);
      }
    }

    Set<TreeNode> ancestor = new HashSet<>();
    // find all the ancestor of p
    while (p != null) {
      ancestor.add(p);
      p = parent.get(p);
    }

    // find q's ancestor which is the same with p
    while (!ancestor.contains(q)) {
      q = parent.get(q);
    }
    return q;
  }
  //// ---------------- end (Approach4)----------------------------------
  /////////////////////////// second round(20201116)///////////////////////
  /////////////////////////// second round(20201116)///////////////////////
  //// ----------------start(Approach5)----------------------------------
  // 20201116.
// Approach 2: Iterative using parent pointers
//this method is more intuitive than recursion methods
  //// ---------------- end (Approach5)----------------------------------
}
// @lc code=end
