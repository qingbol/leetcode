/*
 * @lc app=leetcode id=108 lang=java
 *
 * [108] Convert Sorted Array to Binary Search Tree
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
  // 20200319. by myselft. binary search + inorder
  public TreeNode sortedArrayToBST(int[] nums) {
    return buildTree(nums, 0, nums.length - 1);
  }

  private TreeNode buildTree(int[] nums, int lo, int hi) {
    if (lo > hi) {
      return null;
    }
    int mid = lo + (hi - lo) / 2;
    // System.out.format("lo: %d, mid: %d, hi: %d \n", lo, mid, hi);
    TreeNode node = new TreeNode(nums[mid]);
    node.left = buildTree(nums, lo, mid - 1);
    node.right = buildTree(nums, mid + 1, hi);
    return node;
  }
  //// ---------------- end (Approach1)----------------------------------
  /////////////////////////// second round(20201118)///////////////////////
  /////////////////////////// second round(20201118)///////////////////////
  //// ----------------start(Approach2)----------------------------------
  // 20201118.
  //// ---------------- end (Approach2)----------------------------------
}
// @lc code=end
