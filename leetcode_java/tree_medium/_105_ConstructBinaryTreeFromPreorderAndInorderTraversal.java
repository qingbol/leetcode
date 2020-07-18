/*
 * @lc app=leetcode id=105 lang=java
 *
 * [105] Construct Binary Tree from Preorder and Inorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  //// -------------------start(Approach1)-----------------
  // 20200438, by myselft.
  // Your runtime beats 71.5 % of java submissions
  public TreeNode buildTree(int[] preorder, int[] inorder) {
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
}
// @lc code=end
