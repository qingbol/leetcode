/*
 * @lc app=leetcode id=382 lang=cpp
 *
 * [382] Linked List Random Node
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
  public:
  /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
  Solution(ListNode *head) {
    this->head = head;
  }

  /** Returns a random node's value. */
  int getRandom() {
    int cnt = 1;
    ListNode *p = head;
    ListNode *res;
    while (p != nullptr) {
      if (rand() % cnt == 0) {
        res = p;
      }
      p = p->next;
      cnt++;
    }
    return res->val;
  }

  private:
  ListNode *head;
};

/**
 * Your Solution object will be instantiated and called as such:
 * Solution* obj = new Solution(head);
 * int param_1 = obj->getRandom();
 */
// @lc code=end
