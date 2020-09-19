/*
 * @lc app=leetcode id=237 lang=java
 *
 * [237] Delete Node in a Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200123)///////////////////////
  /////////////////////////// first round(20200123)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200123

  // public void deleteNode(ListNode node) {
  public void deleteNode1(ListNode node) {
    if (node != null && node.next != null) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20200918)///////////////////////
  /////////////////////////// second round(20200918)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20200918.

  public void deleteNode(ListNode node) {
  // public void deleteNode2(ListNode node) {
    if (node != null && node.next != null) {
      node.val = node.next.val;
      node.next = node.next.next;
    }
  }
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
