/*
 * @lc app=leetcode id=148 lang=java
 *
 * [148] Sort List
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200125)///////////////////////
  /////////////////////////// first round(20200125)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200125

  // public ListNode sortList(ListNode head) {
  public ListNode sortList1(ListNode head) {
    return mergeSort(head);
  }

  private ListNode mergeSort(ListNode curHead) {
    if (null == curHead || null == curHead.next) {
      return curHead;
    }
    ListNode median = findMedian(curHead);
    // printList("median: ", median);
    ListNode left = mergeSort(curHead);
    // printList("left: ", left);
    ListNode right = mergeSort(median);
    // printList("right: ", right);
    ListNode res = mergeFunc(left, right);
    // printList("res: ", res);
    return res;
  }

  private ListNode findMedian(ListNode curPtr) {
    ListNode fast = curPtr;
    ListNode slow = curPtr;
    // pay attention to this judgement statement
    while (fast.next != null && null != fast.next.next) {
      // while (fast != null && null != fast.next) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode secondHalfStart = slow.next;
    slow.next = null;
    return secondHalfStart;
  }

  private ListNode mergeFunc(ListNode l, ListNode r) {
    // printList("l: ", l);
    // printList("r: ", r);
    ListNode dummy = new ListNode(0);
    // dummy.next = l;
    ListNode prev = dummy;
    while (l != null && r != null) {
      if (l.val <= r.val) {
        prev.next = l;
        prev = l;
        l = l.next;
      } else {
        prev.next = r;
        prev = r;
        r = r.next;
      }
    }
    prev.next = l != null ? l : r;
    // printList("dummy.next: ", dummy.next);
    return dummy.next;
  }

  private void printList(String str, ListNode tmp) {
    System.out.print(str);
    while (tmp != null) {
      System.out.format("->%d", tmp.val);
      tmp = tmp.next;
    }
    System.out.println();
  }
  //// ---------------- end (Appraoch1)----------------------------------
  /////////////////////////// second round(20200918)///////////////////////
  /////////////////////////// second round(20200918)///////////////////////
  //// ----------------start(Appraoch2)----------------------------------
  // 20200918. iteration version
  // refer to leetcode:Approach 2: Bottom Up Merge Sort

  // 16/16 cases passed (6 ms)
  // Your runtime beats 44.42 % of java submissions
  // Your memory usage beats 81.78 % of java submissions (41.5 MB)

  ListNode tail2 = new ListNode();
  ListNode nextSubLst2 = new ListNode();

  public ListNode sortList(ListNode head) {
    // public ListNode sortList2(ListNode head) {
    if (head == null || head.next == null)
      return head;
    int n = getLen2(head);
    // System.out.format("n: %d\n", n);
    // 1. iterative from bottom to top
    ListNode dummy = new ListNode();
    ListNode cur = head;
    for (int size = 1; size < n; size *= 2) {
      tail2 = dummy;
      while (cur != null) {
        if (cur.next == null) {
          tail2.next = cur;
          break;
        }
        ListNode mid = split2(cur, size);
        // ListNode newHead = merge2(cur, mid);
        merge2(cur, mid);
        // tail.next = newHead;
        cur = nextSubLst2;
      }
      cur = dummy.next;
      System.out.format("size:%d  ", size);
      printList("head", dummy.next);
    }
    return dummy.next;
  }

  private ListNode split2(ListNode head, int size) {
    // ListNode slow = null, fast = head;
    ListNode slow = head, fast = head.next;
    int i = 1;
    // note: this is the tricky point. cant miss slow.next != null
    // while (i < size && fast.next != null) {
    while (i < size && (slow.next != null || fast.next != null)) {
      // while (i < size && fast != null && fast.next != null) {
      if (fast.next != null) {
        fast = fast.next.next == null ? fast.next : fast.next.next;
      }
      if (slow.next != null)
        slow = slow.next;
      i++;
    }
    ListNode mid = slow.next;
    slow.next = null;
    nextSubLst2 = fast.next;
    fast.next = null;
    return mid;
  }

  private void merge2(ListNode first, ListNode second) {
    ListNode dummy = new ListNode();
    ListNode cur = dummy;
    while (first != null && second != null) {
      if (first.val >= second.val) {
        cur.next = second;
        second = second.next;
      } else {
        cur.next = first;
        first = first.next;
      }
      cur = cur.next;
    }
    cur.next = first == null ? second : first;

    // move the cur to the last element.
    while (cur.next != null)
      cur = cur.next;
    // I missed this statement.
    tail2.next = dummy.next;
    tail2 = cur;
  }

  private int getLen2(ListNode node) {
    int n = 0;
    while (node != null) {
      node = node.next;
      n++;
    }
    return n;
  }
  //// ---------------- end (Appraoch2)----------------------------------
}
// @lc code=end
