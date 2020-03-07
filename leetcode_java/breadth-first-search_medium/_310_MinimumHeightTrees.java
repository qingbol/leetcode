/*
 * @lc app=leetcode id=310 lang=java
 *
 * [310] Minimum Height Trees
 */

// @lc code=start
class Solution {
  //// ------------------start(Approach1)----------------------------
  // wrong, by myself
  // Time Limit Exceeded for large testcase: 63/66 cases passed (N/A)
  // 5000
  // [[0,1],[1,2],[2,3],[3,4],[4,5],[5,6],[6,....
  int hi = 0;

  public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
    List<Integer> res = new ArrayList<>();
    if (edges == null || edges.length == 0) {
      // return new ArrayList<>(Array);
      for (int i = 0; i < n; i++) {
        res.add(i);
      }
      return res;
    }
    // build graph
    Map<Integer, List<Integer>> graph = new HashMap<>();
    for (int[] edge : edges) {
      graph.putIfAbsent(edge[0], new ArrayList<>());
      graph.get(edge[0]).add(edge[1]);
      graph.putIfAbsent(edge[1], new ArrayList<>());
      graph.get(edge[1]).add(edge[0]);
    }
    // System.out.format("graph:%s\n", graph);

    Map<Integer, Integer> map = new HashMap<>();
    Deque<Integer> queue = new ArrayDeque<>();
    Set<Integer> set = new HashSet<>();
    int minH = n;
    for (int i = 0; i < n; i++) {
      queue.clear();
      set.clear();
      queue.offer(i);
      set.add(i);
      hi = 0;
      bfs1(graph, queue, set, i);
      // System.out.format("hi: %d\n", hi);
      minH = Math.min(minH, hi);
      map.put(i, hi);
    }
    // output
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() == minH) {
        res.add(entry.getKey());
      }
    }

    return res;
  }

  private void bfs1(Map<Integer, List<Integer>> graph, Deque<Integer> queue, Set<Integer> set, int node) {
    while (!queue.isEmpty()) {
      hi++;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int cur = queue.poll();
        for (int neighbor : graph.get(cur)) {
          if (!set.contains(neighbor)) {
            queue.offer(neighbor);
            set.add(neighbor);
          }
        }
        // bfs1(graph, queue, set, neighbor);
      }
    }
    // return hi;
  }

  //// ------------------ end (Approach1)----------------------------
  //// ------------------start(Approach2)----------------------------
  // optimal
  public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    if (n == 1) {
      return Collections.singletonList(0);
    }
    // build graph
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    // System.out.format("graph: %s\n", graph);

    // find the 1st generation leaves
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (graph.get(i).size() == 1) {
        leaves.add(i);
      }
    }
    // System.out.format("leaves:%s\n", leaves);
    // update the degree, and find the next generation leaves
    while (n > 2) {
      n -= leaves.size();
      List<Integer> newLeaves = new ArrayList<>();
      for (int leaf : leaves) {
        // System.out.format("leaf: %d\n", leaf);
        int j = graph.get(leaf).get(0);
        // System.out.format("checkpoint1\n");
        graph.get(j).remove(Integer.valueOf(leaf));
        if (graph.get(j).size() == 1) {
          newLeaves.add(j);
        }
      }
      leaves = newLeaves;
    }

    return leaves;
  }
  //// ------------------ end (Approach2)----------------------------
  //// ------------------start(Approach3)----------------------------
  //// ------------------ end (Approach3)----------------------------
}
// @lc code=end
