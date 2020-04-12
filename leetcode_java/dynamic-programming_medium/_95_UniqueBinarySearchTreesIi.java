/*
 * @lc app=leetcode id=95 lang=java
 *
 * [95] Unique Binary Search Trees II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  //// ----------------start(Approach1)------------------
  // 20200409, by myself.
  // wrong
  public List<TreeNode> generateTrees1(int n) {
    return helper1(1, n);
  }

  private List<TreeNode> helper1(int lo, int hi) {
    List<TreeNode> res = new ArrayList<>();
    if (lo > hi) {
      return res;
    }
    for (int i = lo; i <= hi; i++) {
      TreeNode node = new TreeNode(i);
      // node.left = helper1(lo, i - 1);
      // node.right = helper1(i + 1, hi);
      // res.add(node);
    }
    return null;
  }

  //// ---------------- end (Approach1)------------------
  //// ----------------start(Approach1)------------------
  // 20200409,
  // Your runtime beats 97.07 % of java submissions
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) {
      return new ArrayList<>();
    }
    return helper2(1, n);
  }

  private List<TreeNode> helper2(int lo, int hi) {
    List<TreeNode> lst = new ArrayList<>();
    if (lo > hi) {
      lst.add(null);
      return lst;
    }

    for (int i = lo; i <= hi; i++) {
      // TreeNode curr = new TreeNode(i);
      List<TreeNode> left = helper2(lo, i - 1);
      List<TreeNode> right = helper2(i + 1, hi);

      for (TreeNode l : left) {
        for (TreeNode r : right) {
          TreeNode curr = new TreeNode(i);
          curr.left = l;
          curr.right = r;
          lst.add(curr);
        }
      }
    }

    return lst;
  }
  //// ---------------- end (Approach1)------------------
}
// @lc code=end
