/*
 * @lc app=leetcode id=109 lang=java
 *
 * [109] Convert Sorted List to Binary Search Tree
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null) {
      return null;
    }

    // --------------start(Find the mid node)------------------------
    ListNode fast = head;
    ListNode slow = head;
    ListNode prev = null;
    while (fast != null && fast.next != null) {
      // while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      prev = slow;
      slow = slow.next;
    }
    if (prev != null) {
      // System.out.format("prev: %d\n", prev.val);
      prev.next = null;
    }

    // if (slow == null) {
    // return null;
    // }
    // -------------- end (Find the mid node)------------------------

    System.out.format("slow: %d\n", slow.val);
    TreeNode node = new TreeNode(slow.val);

    // Base case when there is just one element in the linked list
    if (slow == head) {
      return node;
    }

    // if (prev != null) {
    node.left = sortedListToBST(head);
    // } else {
    // node.left = null;
    // }

    // if (slow.next != null) {
    node.right = sortedListToBST(slow.next);
    // } else {
    // node.right = null;
    // }
    return node;
  }
}
// @lc code=end
