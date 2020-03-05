/*
 * @lc app=leetcode id=133 lang=java
 *
 * [133] Clone Graph
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
  //// -------------------start(Approach1)---------------------------------
  // Bfs, recursion, wrong
  public Node cloneGraph1(Node node) {
    Node dummy = new Node();

    Set<Node> visited = new HashSet<>();
    helper1(node, visited, dummy);
    return dummy;
  }

  private void helper1(Node node, Set<Node> visited, Node dummy) {
    visited.add(node);
    dummy = new Node(node.val, new ArrayList<>());
    for (Node neighbor : node.neighbors) {
      dummy.neighbors.add(neighbor);
      if (!visited.contains(neighbor)) {
        helper1(node, visited, dummy);
      }
    }
  }

  //// ------------------- end (Approach1)---------------------------------
  //// -------------------start(Approach2)---------------------------------
  // bfs iteration. wrong
  public Node cloneGraph2(Node node) {
    Deque<Node> stack = new ArrayDeque<>();
    Set<Node> visited = new HashSet<>();

    stack.push(node);
    Node newNode = new Node(node.val, new ArrayList<>());
    while (!stack.isEmpty()) {
      Node vertex = stack.pop();
      for (Node neighbor : vertex.neighbors) {
        newNode.neighbors.add(neighbor);
        if (!visited.contains(neighbor)) {
          stack.push(neighbor);
          Node tmp = new Node(neighbor.val, new ArrayList<>());
        }
      }
    }
    return newNode;
  }

  //// ------------------- end (Approach2)---------------------------------
  //// -------------------start(Approach3)---------------------------------
  // Bfs, recursion. by cspiration
  public Node cloneGraph3(Node node) {
    if (node == null) {
      return null;
    }
    // Map<Node, Node> map = new HashMap<>();
    return helper3(node, new HashMap<>());
  }

  private Node helper3(Node node, Map<Node, Node> map) {
    Node newNode = new Node(node.val, new ArrayList<>());
    map.put(node, newNode);
    for (Node neighbor : node.neighbors) {
      if (!map.containsKey(neighbor)) {
        newNode.neighbors.add(helper3(neighbor, map));
      } else {
        newNode.neighbors.add(map.get(neighbor));
      }
    }
    return map.get(node);
  }

  //// ------------------- end (Approach3)---------------------------------
  //// -------------------start(Approach4)---------------------------------
  // bfs, recursion. by standard solution. better than approach3
  // optimal
  public Node cloneGraph4(Node node) {
    if (node == null) {
      return null;
    }
    return helper4(node, new HashMap<>());
  }

  private Node helper4(Node node, Map<Node, Node> map) {
    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node newNode = new Node(node.val, new ArrayList<>());
    map.put(node, newNode);
    for (Node neighbor : node.neighbors) {
      newNode.neighbors.add(helper4(neighbor, map));
    }
    return newNode;
  }

  //// ------------------- end (Approach4)---------------------------------
  //// -------------------start(Approach5)---------------------------------
  // bfs, iteration
  public Node cloneGraph(Node node) {
    if (node == null) {
      return null;
    }
    Map<Node, Node> map = new HashMap<>();
    Deque<Node> queue = new ArrayDeque<>();

    queue.offer(node);
    map.put(node, new Node(node.val, new ArrayList<>()));

    while (!queue.isEmpty()) {
      Node curr = queue.poll();
      for (Node neighbor : curr.neighbors) {
        if (!map.containsKey(neighbor)) {
          map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
          queue.offer(neighbor);
          map.get(curr).neighbors.add(map.get(neighbor));
          // }
        } else {
          map.get(curr).neighbors.add(map.get(neighbor));
        }
      }
    }
    return map.get(node);
  }
  //// ------------------- end (Approach5)---------------------------------
  //// -------------------start(Approach6)---------------------------------
  //// ------------------- end (Approach6)---------------------------------
}
// @lc code=end
