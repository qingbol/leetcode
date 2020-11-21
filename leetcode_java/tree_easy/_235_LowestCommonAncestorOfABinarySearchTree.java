/*
 * @lc app=leetcode id=235 lang=java
 *
 * [235] Lowest Common Ancestor of a Binary Search Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200316)///////////////////////////////////
  ////////////////// first round(20200316)///////////////////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200316
  // public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
  public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) {
      return null;
    }
    if (root.val >= p.val && root.val <= q.val || root.val <= p.val && root.val >= q.val) {
      return root;
    } else if (root.val > p.val && root.val > q.val) {
      // } else if (root.val >= p.val && root.val >= q.val) {
      return lowestCommonAncestor(root.left, p, q);
    } else {
      return lowestCommonAncestor(root.right, p, q);
    }
    // return null;
  }
  //// ---------------- end (Approach1)----------------------------------
  /////////////////////////// second round(20201117)///////////////////////
  /////////////////////////// second round(20201117)///////////////////////
  //// ----------------start(Approach2)----------------------------------
  // 20201117.
  // refer to : Approach 1: Recursive Approach
  //more concise than approach1
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

    // Value of current node or parent node.
    int parentVal = root.val;

    // Value of p
    int pVal = p.val;

    // Value of q;
    int qVal = q.val;

    if (pVal > parentVal && qVal > parentVal) {
        // If both p and q are greater than parent
        return lowestCommonAncestor(root.right, p, q);
    } else if (pVal < parentVal && qVal < parentVal) {
        // If both p and q are lesser than parent
        return lowestCommonAncestor(root.left, p, q);
    } else {
        // We have found the split point, i.e. the LCA node.
        return root;
    }
}
  //// ---------------- end (Approach2)----------------------------------
}
// @lc code=end
