/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
  ////////////////// first round(202000304)////////////////////////////////////
  ////////////////// first round(202000304)////////////////////////////////////
  //// -------------------start(Approach1)---------------------------------
  // 20200304.
  // By cspiration
  // Build GraphNode
  public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
    // if beginWord is not included in the wordList, add it.
    if (!wordList.contains(beginWord)) {
      wordList.add(beginWord);
    }

    // build node from wordList
    Graph graph = new Graph();
    for (String word : wordList) {
      graph.addNode(new Node(word));
    }

    // biuld the adjacency lsit;
    for (String word : wordList) {
      Node node = graph.getNode(word);
      // char[] wordArr = word.toCharArray();
      for (int i = 0; i < word.length(); i++) {
        for (char j = 'a'; j <= 'z'; j++) {
          String newWord = word.substring(0, i) + j + word.substring(i + 1);
          // System.out.format("newWord: %s\n", newWord);
          if (graph.getNode(newWord) != null && !node.neighbors.contains(graph.getNode(newWord))
              && !newWord.equals(word)) {
            node.neighbors.add(graph.getNode(newWord));
          }
        }
      }
    }
    // System.out.format("graph: %s\n", graph.toString());

    // use bfs (iteration) to traverse the graph
    Deque<Node> queue = new ArrayDeque<>();
    Set<Node> visited = new HashSet<>();

    queue.offer(graph.getNode(beginWord));
    visited.add(graph.getNode(beginWord));

    int res = 0;
    while (!queue.isEmpty()) {
      res++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        Node cur = queue.poll();
        if (cur.word.equals(endWord)) {
          return res;
        }
        // System.out.format("neighbors: %s\n", cur.neighbors);
        for (Node neighbor : cur.neighbors) {
          if (!visited.contains(neighbor)) {
            queue.offer(neighbor);
            visited.add(neighbor);
          }
        }
      }
    }

    return 0;
  }

  // use Graph and Node classes to build the word graph
  private class Graph {
    List<Node> nodes;
    Map<String, Integer> map;

    public Graph() {
      nodes = new ArrayList<>();
      map = new HashMap<>();
    }

    public void addNode(Node node) {
      map.put(node.word, nodes.size());
      nodes.add(node);
    }

    public Node getNode(String str) {
      if (map.containsKey(str)) {
        return nodes.get(map.get(str));
      }
      return null;
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      for (Node node : nodes) {
        sb.append(node.word);
        sb.append("->");
      }
      return sb.toString();
    }
  }

  private class Node {
    String word;
    List<Node> neighbors;

    public Node(String word) {
      this.word = word;
      neighbors = new ArrayList<>();
    }
  }

  //// --------------------- end (Approach1)------------------------
  //// ---------------------start(Approach2)------------------------
  // by leetcode Approach 1: Breadth First Search

  // 43/43 cases passed (39 ms)
  // Your runtime beats 87.69 % of java submissions
  // Your memory usage beats 19.88 % of java submissions (46.9 MB)

  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Map<String, List<String>> map = new HashMap<>();

    // Build adjacency list
    for (String word : wordList) {
      for (int i = 0; i < word.length(); i++) {
        String newWord = word.substring(0, i) + "*" + word.substring(i + 1);
        List<String> lst = map.getOrDefault(newWord, new ArrayList<>());
        lst.add(word);
        map.put(newWord, lst);
      }
    }

    // use bfs to traverse the graph
    Deque<Pair<String, Integer>> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();

    queue.offer(new Pair(beginWord, 1));
    visited.add(beginWord);

    // int res = 0;
    while (!queue.isEmpty()) {
      // res++;
      Pair<String, Integer> cur = queue.poll();
      String curWord = cur.getKey();
      Integer level = cur.getValue();
      if (curWord.equals(endWord)) {
        return level;
      }
      for (int i = 0; i < curWord.length(); i++) {
        String newWord = curWord.substring(0, i) + "*" + curWord.substring(i + 1);
        for (String neighbor : map.getOrDefault(newWord, new ArrayList<>())) {
          if (!visited.contains(neighbor)) {
            queue.offer(new Pair(neighbor, level + 1));
            visited.add(neighbor);
          }
        }
      }
    }

    return 0;
  }
  //// ------------------- end (Approach2)---------------------------------
  /////////////////////////// second round(20201123)///////////////////////
  /////////////////////////// second round(20201123)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201123.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
