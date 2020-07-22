/*
 * @lc app=leetcode id=382 lang=java
 *
 * [382] Linked List Random Node
 */

// @lc code=start
//  * Definition for singly-linked list.
//  * public class ListNode {
//  *     int val;
//  *     ListNode next;
//  *     ListNode() {}
//  *     ListNode(int val) { this.val = val; }
//  *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
//  * }
/////////////////////////first round(20200720)///////////////////////
////--------------------start(Approach1)-----------------------------
//20200720
//refer to labuladong <如何在无限序列中随机抽取元素>

// 7/7 cases passed (10 ms)
// Your runtime beats 95.18 % of java submissions
// Your memory usage beats 30.04 % of java submissions (41.4 MB)

// class Solution1 {
public class Solution {

  /**
   * @param head The linked list's head. Note that the head is guaranteed to be
   *             not null, so it contains at least one node.
   */
  ListNode head;
  Random rand;
  public Solution(ListNode head) {
  // public Solution1(ListNode head) {
    this.head = head;
    rand = new Random(47);
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode cur = head, res = null;

    int k = 0; 
    while (cur != null) {
      if (rand.nextInt(++k) == 0) {
        res = cur;
      }
      cur = cur.next;
    }
    return res.val;
  }
}
////-------------------- end (Approach1)-----------------------------
////--------------------start(Approach2)-----------------------------
//20200720
class Solution2 {
// public class Solution {

  /**
   * @param head The linked list's head. Note that the head is guaranteed to be
   *             not null, so it contains at least one node.
   */
  // public Solution(ListNode head) {
  public Solution2(ListNode head) {

  }

  /** Returns a random node's value. */
  public int getRandom() {
    return 0;
  }
}
////-------------------- end (Approach2)-----------------------------

// * Your Solution object will be instantiated and called as such:
// * Solution obj = new Solution(head);
// * int param_1 = obj.getRandom();
// @lc code=end
