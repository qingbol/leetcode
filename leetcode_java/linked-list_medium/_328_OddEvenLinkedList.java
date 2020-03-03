/*
 * @lc app=leetcode id=328 lang=java
 *
 * [328] Odd Even Linked List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  public ListNode oddEvenList1(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode p = head;
    ListNode h = head.next;
    ListNode q = head.next;
    while (p.next != null && p.next.next != null || q.next != null && q.next.next != null) {
      if (p.next != null && p.next.next != null) {
        p.next = p.next.next;
        p = p.next;
      }
      if (q.next != null && q.next.next != null) {
        q.next = q.next.next;
        q = q.next;
      }
    }
    p.next = h;
    q.next = null;
    return head;
  }

  // optimal
  public ListNode oddEvenList(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = head.next;
    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }
    odd.next = evenHead;
    return head;
  }

}
// @lc code=end
