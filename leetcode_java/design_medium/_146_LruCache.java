import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
////////////////// first round(20200225)///////////////////////////////////
////////////////// first round(20200225)///////////////////////////////////
////---------------------start(Approach1)----------------------------
//20200225, delete from head
class LRUCache1 {
  // public class LRUCache {
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

  public LRUCache1(int capacity) {
    // public LRUCache(int capacity) {
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

//// --------------------- end (Approach1)----------------------------
//// ---------------------start(Approach2)----------------------------
// 20200412. delete from tail. without dummy node
// Your runtime beats 95.93 % of java submissions
// public class LRUCache {
class LRUCache2 {

  Map<Integer, Node> map;
  Node head, tail;
  int size;
  int capacity;

  // public LRUCache(int capacity) {
  public LRUCache2(int capacity) {
    map = new HashMap<>();
    head = null;
    tail = null;
    size = 0;
    this.capacity = capacity;
  }

  public int get(int key) {
    // System.out.format("get key:%d\n", key);
    Node currNode = map.get(key);
    if (currNode == null) {
      return -1;
    }
    if (currNode != head) {
      moveToHead(currNode);
    }

    // printNext(head);
    // printPrev(tail);
    // System.out.format("get:%d\n", currNode.v);
    return currNode.v;
  }

  public void put(int key, int value) {
    // System.out.format("put[%d, %d]\n", key, value);
    if (map.containsKey(key)) {
      Node currNode = map.get(key);
      currNode.v = value;
      if (currNode != head) {
        moveToHead(currNode);
      }
    } else {
      Node newNode = new Node(key, value);
      map.put(key, newNode);
      // System.out.format("map:%s\n", map);

      if (head == null && tail == null) {
        tail = newNode;
      } else {
        head.prev = newNode;
        newNode.next = head;
        // newNode.prev = null;
      }
      head = newNode;
      size++;

      // printNext(head);
      // printPrev(tail);

      if (size > capacity) {
        // System.out.format("tail:%d\n", tail.k);
        // System.out.format("tail.prev:%d\n", tail.prev.k);
        Node tmp = tail;
        tail = tail.prev;
        tail.next = null;
        map.remove(tmp.k);
        size--;
      }
    }
  }

  private void printNext(Node node) {
    // System.out.format("node->next:\n");
    while (node != null) {
      // System.out.format("%d ->", node.k);
      node = node.next;
    }
    System.out.println();
  }

  private void printPrev(Node node) {

    // System.out.format("node->prev:\n");
    while (node != null) {
      // System.out.format("%d ->", node.k);
      node = node.prev;
    }
    System.out.println();
  }

  private void moveToHead(Node node) {
    if (node == tail) {
      tail = tail.prev;
      tail.next = null;
    } else {
      node.prev.next = node.next;
      node.next.prev = node.prev;
    }
    node.next = head;
    node.prev = null;
    head.prev = node;
    head = node;
  }

  private class Node {
    int k, v;
    Node prev, next;

    public Node(int k, int v) {
      this.k = k;
      this.v = v;
      prev = null;
      next = null;
    }
  }
}

//// --------------------- end (Approach2)----------------------------
//// ---------------------start(Approach3)----------------------------
// 20200412. delete from tail. without dummy node
// optimal.
// refer to: Approach 2: Hashmap + DoubleLinkedList
// Your runtime beats 75.26 % of java submissions
// public class LRUCache {
class LRUCache3 {

  Map<Integer, Node> map;
  Node head, tail;
  int capacity;

  // public LRUCache(int capacity) {
  public LRUCache3(int capacity) {
    map = new HashMap<>();
    head = new Node();
    tail = new Node();
    head.next = tail;
    tail.prev = head;
    // printNext(head);
    // printPrev(tail);
    this.capacity = capacity;
  }

  public int get(int key) {
    Node currNode = map.get(key);
    if (currNode == null) {
      return -1;
    }
    moveToHead(currNode);
    return currNode.v;
  }

  public void put(int key, int value) {
    Node currNode = map.get(key);
    if (currNode == null) {
      Node newNode = new Node(key, value);
      addNode(newNode);
      map.put(key, newNode);
      if (map.size() > capacity) {
        map.remove(tail.prev.k);
        delNode(tail.prev);
      }
    } else {
      currNode.v = value;
      moveToHead(currNode);
    }
  }

  private void printNext(Node node) {
    System.out.format("node->next:\n");
    while (node != null) {
      System.out.format("%d ->", node.k);
      node = node.next;
    }
    System.out.println();
  }

  private void printPrev(Node node) {
    System.out.format("node->prev:\n");
    while (node != null) {
      System.out.format("%d ->", node.k);
      node = node.prev;
    }
    System.out.println();
  }

  private void moveToHead(Node node) {
    delNode(node);
    addNode(node);
  }

  private void addNode(Node newNode) {
    // Node newNode = new Node(key, val);
    newNode.next = head.next;
    newNode.prev = head;
    head.next.prev = newNode;
    head.next = newNode;
  }

  private void delNode(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  private class Node {
    int k, v;
    Node prev, next;

    public Node() {

    }

    public Node(int k, int v) {
      this.k = k;
      this.v = v;
      prev = null;
      next = null;
    }
  }
}

//// --------------------- end (Approach3)----------------------------
////////////////// second round(20200728)///////////////////////////////////
////////////////// second round(20200728)///////////////////////////////////
//// ---------------------start(Approach4)----------------------------
// 20200728. by myself.

// Runtime Error
// Error
// java.lang.NullPointerException

class LRUCache4 {
  // public class LRUCache {
  HashMap<Integer, Node> map;
  Node dummy;
  Node tail;
  int capacity;
  int n;

  // public LRUCache(int capacity) {
  public LRUCache4(int capacity) {
    map = new HashMap<>();
    dummy = new Node();
    tail = null;
    this.capacity = capacity;
    n = 0;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      Node cur = map.get(key);
      delNode(cur);
      addFirst(cur);
      return cur.v;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      Node cur = map.get(key);
      cur.v = value;
      delNode(cur);
      addFirst(cur);
    } else {
      Node cur = new Node(key, value);
      map.put(key, cur);
      if (n >= capacity) {
        delNode(tail);
      }
      addFirst(cur);
      map.put(key, cur);
      if (tail == null)
        tail = cur;
      // n++;
    }
  }

  private void addFirst(Node node) {
    node.next = dummy.next;
    dummy.next.prev = node;
    dummy.next = node;
    node.prev = dummy;
    n++;
  }

  private void delNode(Node node) {
    if (node == tail)
      tail = tail.prev;
    node.prev.next = node.next;
    node.next.prev = node.prev;
    map.remove(node.k);
    n--;
  }

  private class Node {
    int k;
    int v;
    Node next;
    Node prev;

    public Node() {
      this.k = -1;
      this.v = -1;
      next = null;
      prev = null;
    }

    public Node(int k, int v) {
      this.k = k;
      this.v = v;
      next = null;
      prev = null;
    }
  }
}
//// --------------------- end (Approach4)----------------------------
//// ---------------------start(Approach5)----------------------------
// 20200728, by myself.
//refer to labuladong <LRU算法详解>

// 18/18 cases passed (15 ms)
// Your runtime beats 40.32 % of java submissions
// Your memory usage beats 30.63 % of java submissions (48.1 MB)

// class LRUCache5 {
public class LRUCache {
  Map<Integer, Node> map;
  DoubleList cache;
  int capacity;

  // public LRUCache5(int capacity) {
  public LRUCache(int capacity) {
    map = new HashMap<>();
    cache = new DoubleList();
    this.capacity = capacity;
  }

  public int get(int key) {
    if (!map.containsKey(key))
      return -1;
    int val = map.get(key).v;
    put(key, val);
    return val;
  }

  public void put(int key, int value) {
    Node x = new Node(key, value);

    if (map.containsKey(key)) {
      cache.remove(map.get(key));
      cache.addFirst(x);
      map.put(key, x);
    } else {
      if (cache.size() == capacity) {
        Node last = cache.removeLast();
        map.remove(last.k);
      }
      cache.addFirst(x);
      map.put(key, x);
    }
  }

  class DoubleList {
    Node head, tail;
    int sz;

    public DoubleList() {
      head = new Node(-1, -1);
      tail = new Node(-1, -1);
      head.next = tail;
      tail.prev = head;
    }

    public void addFirst(Node node) {
      node.next = head.next;
      node.prev = head;
      head.next.prev = node;
      head.next = node;
      sz++;
    }

    public void remove(Node node) {
      node.prev.next = node.next;
      node.next.prev = node.prev;
      sz--;
    }

    public Node removeLast() {
      if (tail.prev == head)
        return null;
      Node cur = tail.prev;
      remove(cur);
      return cur;
    }

    public int size() {
      return sz;
    }
  }

  class Node {
    int k, v;
    Node prev, next;

    public Node(int k, int v) {
      this.k = k;
      this.v = v;
      prev = null;
      next = null;
    }
  }

}
//// --------------------- end (Approach5)----------------------------
/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
