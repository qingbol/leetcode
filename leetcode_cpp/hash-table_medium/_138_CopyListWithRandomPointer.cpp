/*
 * @lc app=leetcode id=138 lang=cpp
 *
 * [138] Copy List with Random Pointer
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/
class Solution {
  public:
  Node *copyRandomList(Node *head) {
    Node new_head(0);
    Node *p = head;
    Node *t = nullptr;

    while (p) {
      Node *cloned = new Node(p->val);
      cloned->next = p->next;
      p->next = cloned;
      p = cloned->next;
    }
    // printList(head);

    p = head;
    while (p && p->next) {
      if (p->random) {
        p->next->random = p->random->next;
      }
      p = p->next->next;
      // printList(head);
    }

    p = head;
    t = &new_head;
    while (p && p->next) {
      t->next = p->next;
      p->next = p->next->next;
      t = t->next;
      p = p->next;
    }
    // printList(head);
    return new_head.next;
  }

  private:
  void printList(Node *h) {
    while (h) {
      cout << h->val << " ";
      h = h->next;
    }
    cout << endl;
  }
};
// @lc code=end
