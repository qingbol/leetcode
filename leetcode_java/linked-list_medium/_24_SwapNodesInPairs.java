/*
 * @lc app=leetcode id=24 lang=java
 *
 * [24] Swap Nodes in Pairs
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  ////////////////// first round(20200122)///////////////////////////////////
  ////////////////// first round(20200122)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200122
  public ListNode swapPairs1(ListNode head) {
    if (null == head) {
      return head;
    }
    ListNode p = head;
    ListNode q = p.next;
    ListNode prev = null;
    while (p != null && q != null) {
      // System.out.format("head: %d, p: %d, q: %d\n", head.val, p.val, q.val);
      p.next = q.next;
      q.next = p;
      if (prev != null) {
        prev.next = q;
      }
      if (p == head) {
        head = q;
      }
      prev = p;
      p = p.next;
      if (p != null) {
        q = p.next;
      }
    }
    // System.out.format("head: %d, q: %d\n", head.val, q.val);
    return head;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // video
  public ListNode swapPairs2(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode p = dummy;
    ListNode q = head;
    // System.out.format("dummy:%d\n", dummy.next.val);
    while (q != null && q.next != null) {
      // System.out.format("dummy:%d\n", dummy.next.val);
      ListNode s = q.next.next;
      p.next = q.next;
      q.next.next = q;
      q.next = s;
      p = q;
      q = q.next;
    }
    return dummy.next;
  }

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // recursion
  public ListNode swapPairs3(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    ListNode first = head;
    ListNode second = head.next;

    first.next = swapPairs(second.next);
    second.next = first;
    return second;
  }

  //// ---------------- end (Approach3)-------------------------------------
  //// ----------------start(Approach4)-------------------------------------
  // iteration

  // public ListNode swapPairs(ListNode head) {
  public ListNode swapPairs4(ListNode head) {
    if (null == head || null == head.next) {
      return head;
    }
    // dummy node acts as the previous node for the head node of the list,
    // and hence store the pointers to the head node,
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prev = dummy;
    while (head != null && null != head.next) {
      // nodes to be swapped
      ListNode first = head;
      ListNode second = head.next;

      // swapping
      prev.next = second;
      first.next = second.next;
      second.next = first;

      // reinitialize the head and prev for the next swap
      prev = first;
      head = first.next;
    }
    return dummy.next;
  }
  //// ---------------- end (Approach3)-------------------------------------
  ////////////////// second round(20200917)///////////////////////////////////
  ////////////////// second round(20200917)///////////////////////////////////
  //// ----------------start(Approach4)-------------------------------------
  // 20200917
  // I can figure out approach3,
  // iterative version is a little tricky, remember it

  // 55/55 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 44.26 % of java submissions (37.3 MB)

  public ListNode swapPairs(ListNode head) {
    // public ListNode swapPairs5(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode dummy = new ListNode(-1);
    dummy.next = head;

    ListNode prev = dummy;
    while (head != null && head.next != null) {
      // ListNode cur = head;
      ListNode nxt = head.next;

      prev.next = nxt;
      head.next = nxt.next;
      nxt.next = head;

      prev = head;
      head = head.next;
    }
    return dummy.next;
  }
  //// ---------------- end (Approach4)-------------------------------------
}
// @lc code=end
