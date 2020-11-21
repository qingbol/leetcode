/*
 * @lc app=leetcode id=257 lang=java
 *
 * [257] Binary Tree Paths
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(2020315)///////////////////////
  /////////////////////////// first round(2020315)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  //20200315
  // by myselft. preorder recursion. + backtrack + StringBuilder
  // Your runtime beats 100 % of java submissions
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> res = new ArrayList<>();
    helper1(res, root, new StringBuilder());
    return res;
  }

  private void helper1(List<String> res, TreeNode node, StringBuilder sb) {
    if (node == null) {
      return;
    }
    // the position of this statement is important.
    // dont put it after sb.append(node.val)
    int len = sb.length();

    // small improvement
    // put sb.append(node.val); here
    sb.append(node.val);
    if (node.left == null && node.right == null) {
      // sb.append(node.val);
      res.add(sb.toString());
      // } else if (sb.length() == 0) {
      // sb.append(node.val);
    } else {
      // sb.append(node.val);
      sb.append("->");
    }
    helper1(res, node.left, sb);
    // sb.setLength(len);
    // len = sb.length();
    helper1(res, node.right, sb);
    sb.setLength(len);
  }

  //// ---------------- end (Approach1)----------------------
  //// ----------------start(Approach2)----------------------
  // . preorder recursion. + backtrack + String
  // we dont need backtrack explicitly with String
  public List<String> binaryTreePaths2(TreeNode root) {
    List<String> res = new ArrayList<>();
    helper2(res, root, "");
    return res;
  }

  private void helper2(List<String> res, TreeNode node, String s) {
    if (node == null) {
      return;
    }

    s += node.val;
    if (node.left == null && node.right == null) {
      res.add(s);
    } else {
      s += "->";
    }

    System.out.format("s befor: %s\n", s);
    helper2(res, node.left, s);
    System.out.format("s after: %s\n", s);
    helper2(res, node.right, s);
  }
  //// ---------------- end (Approach2)----------------------
  /////////////////////////// second round(20201114)///////////////////////
  /////////////////////////// second round(20201114)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  // 20201114.
  //// ---------------- end (Appraoch3)----------------------------------
}
// @lc code=end
