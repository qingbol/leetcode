/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200125)///////////////////////
  /////////////////////////// first round(20200125)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200125
  // recursion (misunderstand the requirement)
  public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
    int val = addHelper(l1, l2);
    if (val > 0) {
      ListNode dummy = new ListNode(val);
      dummy.next = l1;
      return dummy;
    }
    return l1;
  }

  private int addHelper(ListNode l1, ListNode l2) {
    if (l1.next == null) {
      int lastCarry = (l1.val + l2.val) / 10;
      l1.val = (l1.val + l2.val) % 10;
      return lastCarry;
    }
    int preCarry = addHelper(l1.next, l2.next);
    int carry = (l1.val + l2.val + preCarry) / 10;
    l1.val = (l1.val + l2.val + preCarry) % 10;
    return carry;
  }

  //// ---------------- end (Approach1)-------------------------------------
  //// ----------------start(Approach2)-------------------------------------
  // by myself
  public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
    ListNode cur = l1;
    ListNode prev = null;
    int carry = 0;
    ListNode dummy = new ListNode(0);
    // dummy.next = l1;

    while (cur != null && l2 != null) {
      int tmp = cur.val;
      cur.val = (tmp + l2.val + carry) % 10;
      carry = (tmp + l2.val + carry) / 10;
      // System.out.format("cur.val:%d, l2: %d\n", cur.val, l2.val);
      prev = cur;
      cur = cur.next;
      l2 = l2.next;
    }

    if (l2 != null) {
      prev.next = l2;
      cur = l2;
    }
    while (cur != null) {
      int tmp = cur.val;
      cur.val = (tmp + carry) % 10;
      carry = (tmp + carry) / 10;
      prev = cur;
      cur = cur.next;
    }

    if (carry > 0) {
      prev.next = dummy;
      dummy.val = carry;
    }

    return l1;
  }

  //// ---------------- end (Approach2)-------------------------------------
  //// ----------------start(Approach3)-------------------------------------
  // better
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    int carry = 0;
    ListNode p = l1;
    ListNode q = l2;
    while (p != null || q != null || carry != 0) {
      if (p != null) {
        carry += p.val;
        p = p.next;
      }
      if (q != null) {
        carry += q.val;
        q = q.next;
      }
      curr.next = new ListNode(carry % 10);
      curr = curr.next;
      carry /= 10;
    }

    return dummy.next;
  }

  //// ---------------- end (Appraoch3)----------------------------------
  /////////////////////////// second round(20200919)///////////////////////
  /////////////////////////// second round(20200919)///////////////////////
  //// ----------------start(Appraoch4)----------------------------------
  // 20200919.
  //just like approach3.
  //// ---------------- end (Appraoch4)----------------------------------
}
// @lc code=end
