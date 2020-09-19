import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
  /////////////////////////// first round(20200126)///////////////////////
  /////////////////////////// first round(20200126)///////////////////////
  //// ----------------start(Appraoch1)----------------------------------
  // 20200126
  // by myself
  public ListNode mergeKLists1(ListNode[] lists) {
    int len = lists.length;
    if (null == lists || 0 == len) {
      return null;
    }
    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (int i = 0; i < len; i++) {
      if (lists[i] != null) {
        pq.offer(lists[i]);
        // lists[i] = lists[i].next;
      }
    }

    // ListNode tmp = pq.poll();
    while (!pq.isEmpty()) {
      ListNode tmp = pq.poll();
      // System.out.format("tmp: %d\n", tmp.val);
      curr.next = new ListNode(tmp.val);
      curr = curr.next;
      if (tmp.next != null) {
        // System.out.format("tmp: %d\n", tmp.next.val);
        pq.add(tmp.next);
      }
    }
    return dummy.next;
  }

  //// -------------------- end (Approach1)------------------------------
  //// --------------------start(Approach2)------------------------------
  // better
  public ListNode mergeKLists(ListNode[] lists) {
    int len = lists.length;
    if (null == lists || len == 0) {
      return null;
    }
    PriorityQueue<ListNode> pq = new PriorityQueue<>(len, new Comparator<ListNode>() {
      public int compare(ListNode a, ListNode b) {
        if (a.val < b.val) {
          return -1;
        } else if (a.val > b.val) {
          return 1;
        } else {
          return 0;
        }
      }
    });

    ListNode dummy = new ListNode(0);
    ListNode curr = dummy;

    for (ListNode list : lists) {
      if (list != null) {
        pq.add(list);
      }
    }

    while (!pq.isEmpty()) {
      curr.next = pq.poll();
      curr = curr.next;
      if (curr.next != null) {
        pq.offer(curr.next);
      }
    }
    return dummy.next;
  }
  //// -------------------- end (Approach2)------------------------------
  /////////////////////////// second round(20200920)///////////////////////
  /////////////////////////// second round(20200920)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  // 20200920.
  //just like approach2.
  //// ---------------- end (Appraoch3)----------------------------------

}
// @lc code=end
