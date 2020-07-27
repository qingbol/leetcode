/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * // * Definition for a binary tree node. // * public class TreeNode { // * int
 * val; // * TreeNode left; TreeNode right; // * TreeNode() {} // * TreeNode(int
 * val) { this.val = val; } // * TreeNode(int val, TreeNode left, TreeNode
 * right) { // * this.val = val; this.left = left; this.right = right; } } //
 */
class Solution {
  ////////////////////// first round(20200428)////////////////////////
  //// -------------------start(Approach1)-------------------------
  // 20200428, by myselft.
  // Your runtime beats 71.5 % of java submissions

  // public TreeNode buildTree(int[] preorder, int[] inorder) {
  public TreeNode buildTree1(int[] preorder, int[] inorder) {
    // System.out.format("pre: %s", Arrays.toString(preorder));
    Map<Integer, Integer> inorderMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderMap.put(inorder[i], i);
    }
    return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inorderMap);
  }

  private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
      Map<Integer, Integer> map) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    TreeNode node = new TreeNode(preorder[preStart]);
    int idx = map.get(node.val);
    int numOfLeft = idx - inStart;
    node.left = helper(preorder, preStart + 1, preStart + numOfLeft, inorder, inStart, idx - 1, map);
    node.right = helper(preorder, preStart + numOfLeft + 1, preEnd, inorder, idx + 1, inEnd, map);

    return node;
  }

  //// ------------------- end (Approach1)-------------------------
  ////////////////////// second round(20200722)////////////////////////
  ////////////////////// second round(20200722)////////////////////////
  //// -------------------start(Approach2)-------------------------
  // 20200428, by myselft.
//refer to labuladong <学习算法和刷题的思路指南>
  // 203/203 cases passed (2 ms)
  // Your runtime beats 80.56 % of java submissions
  // Your memory usage beats 61.77 % of java submissions (39.6 MB)

  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // public TreeNode buildTree2(int[] preorder, int[] inorder) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      map.put(inorder[i], i);
    }
    TreeNode head = helper2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    return head;
  }

  private TreeNode helper2(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd,
      HashMap<Integer, Integer> map) {
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    int newRootVal = preorder[preStart];
    TreeNode node = new TreeNode(newRootVal);
    int idx = map.get(newRootVal);
    node.left = helper2(preorder, preStart + 1, preStart + idx - inStart, inorder, inStart, idx - 1, map);
    node.right = helper2(preorder, preStart + idx - inStart + 1, preEnd, inorder, idx + 1, inEnd, map);

    return node;
  }
  //// ------------------- end (Approach2)-------------------------
}
// @lc code=end
