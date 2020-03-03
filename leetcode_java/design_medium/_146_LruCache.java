/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class LRUCache {
  private class Node {
    int k;
    int v;
    Node prev;
    Node next;

    public Node(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }

  private Map<Integer, Node> map;
  Node head;
  Node tail;
  int capacity;
  int size;

  public LRUCache(int capacity) {
    map = new HashMap<>();
    head = null;
    tail = null;
    this.capacity = capacity;
    size = 0;
  }

  public int get(int key) {
    // System.out.format("checkpoint 3\n");
    Node cur = map.get(key);
    if (cur == null) {
      return -1;
    }
    if (cur != tail) {
      if (cur == head) {
        head = head.next;
      } else {
        // skip the cur Node
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
      }
      // append the cur Node to tail
      tail.next = cur;
      cur.prev = tail;
      cur.next = null;
      tail = tail.next;
    }
    // System.out.format("checkpoint 4\n");
    return cur.v;
  }

  public void put(int key, int value) {
    // System.out.format("checkpoint 1\n");
    // if (cur != null) {
    Node cur;
    if (map.containsKey(key)) {
      // System.out.format("checkpoint 11\n");
      cur = map.get(key);
      cur.v = value;
      // map.put(key, new Node(key, value));
      if (cur != tail) {
        if (cur == head) {
          head = head.next;
        } else {
          cur.prev.next = cur.next;
          cur.next.prev = cur.prev;
        }
        tail.next = cur;
        cur.prev = tail;
        cur.next = null;
        tail = cur;
      }
    } else {
      cur = new Node(key, value);
      // System.out.format("checkpoint 12\n");
      if (size >= capacity) {
        // System.out.format("size: %d\n", size);
        Node tmp = head;
        head = head.next;
        map.remove(tmp.k);
        size--;
      }
      if (head == null && tail == null) {
        head = cur;
      } else {
        tail.next = cur;
        cur.prev = tail;
        cur.next = null;
      }
      tail = cur;
      map.put(key, cur);
      size++;
    }
    // move the cur Node to the tail
    // System.out.format("checkpoint 2\n");
    // System.out.format("head.key: %d\n", head.k);

  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
