/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */
public class Solution {
  ////////////////// first round(20200126)///////////////////////////////////
  ////////////////// first round(20200126)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200126
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    ListNode a = headA;
    ListNode b = headB;
    while (a != b) {
      a = a == null ? headB : a.next;
      b = b == null ? headA : b.next;
    }
    return a;
  }
  //// ---------------- end (Approach1)-------------------------------------
  ////////////////// second round(20200917)///////////////////////////////////
  ////////////////// second round(20200917)///////////////////////////////////
  //// ----------------start(Approach2)-------------------------------------
  //20200917
  //just like approach1. just remember it.
  //// ---------------- end (Approach2)-------------------------------------
}
// @lc code=end
