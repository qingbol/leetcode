/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200124)///////////////////////
  /////////////////////////// first round(20200124)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200124
  // by myself
  public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
    if (null == l1 && null == l2) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode cur = null;
    dummy.next = cur;
    while (null != l1 && null != l2) {
      if (l1.val <= l2.val) {
        if (dummy.next == null) {
          dummy.next = l1;
          cur = l1;
        } else {
          cur.next = l1;
          cur = cur.next;
        }
        l1 = l1.next;
      } else {
        if (dummy.next == null) {
          dummy.next = l2;
          cur = l2;
        } else {
          cur.next = l2;
          cur = cur.next;
        }
        l2 = l2.next;
      }
      // printList(dummy.next);
    }

    if (null != l1) {
      if (dummy.next == null) {
        dummy.next = l1;
        cur = l1;
      } else {
        cur.next = l1;
        cur = cur.next;
      }
    }
    if (null != l2) {
      if (dummy.next == null) {
        dummy.next = l2;
        cur = l2;
      } else {
        cur.next = l2;
        cur = cur.next;
      }
    }
    // printList(dummy.next);
    return dummy.next;
  }

  private void printList(ListNode h) {
    while (h != null) {
      System.out.format("->%d", h.val);
      h = h.next;
    }
    System.out.println();
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // better
  public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    if (null == l1) {
      return l2;
    }
    if (null == l2) {
      return l1;
    }
    ListNode dummy = new ListNode(0);
    ListNode prev = dummy;

    while (l1 != null && null != l2) {
      if (l1.val <= l2.val) {
        prev.next = l1;
        l1 = l1.next;
      } else {
        prev.next = l2;
        l2 = l2.next;
      }
      prev = prev.next;
    }

    prev.next = l1 == null ? l2 : l1;
    return dummy.next;
  }

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // recusion

  // public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
  public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
    if (null == l1) {
      return l2;
    } else if (null == l2) {
      return l1;
    } else if (l1.val <= l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }
  //// ---------------- end (Appraoch3)----------------------------------
  /////////////////////////// second round(20200920)///////////////////////
  /////////////////////////// second round(20200920)///////////////////////
  //// ----------------start(Appraoch4)----------------------------------
  // 20200920.
  //just like approach2.
  //// ---------------- end (Appraoch4)----------------------------------
}
// @lc code=end
