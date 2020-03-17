/*
 * @lc app=leetcode id=261 lang=java
 *
 * [261] Graph Valid Tree
 */

// @lc code=start
class Solution {
  //// ---------------start(Approach1)-------------------------
  // 20200308
  // union find. by myself
  public boolean validTree1(int n, int[][] edges) {
    int[] nodes = new int[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = i;
    }

    // union
    for (int[] edge : edges) {
      int lroot = find1(nodes, edge[0]);
      int rroot = find1(nodes, edge[1]);
      if (lroot == rroot) {
        return false;
      } else {
        nodes[lroot] = rroot;
      }
    }

    // check if has only one root
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      set.add(find1(nodes, i));
    }
    return set.size() == 1 ? true : false;
  }

  private int find1(int[] nodes, int idx) {
    while (idx != nodes[idx]) {
      nodes[idx] = nodes[nodes[idx]];
      idx = nodes[idx];
    }
    return idx;
  }

  //// --------------- end (Approach1)-------------------------
  //// ---------------start(Approach2)-------------------------
  // 20200308
  // improved union find
  // optimal
  public boolean validTree(int n, int[][] edges) {
    int[] nums = new int[n];
    Arrays.fill(nums, -1);

    // perform union find
    for (int[] edge : edges) {
      int x = find2(nums, edge[0]);
      int y = find2(nums, edge[1]);
      // if two vertices happen to be in the same set. cycle is found.
      if (x == y) {
        return false;
      }
      // union
      nums[x] = y;
    }

    return n - 1 == edges.length;
  }

  private int find2(int[] nums, int idx) {
    if (nums[idx] == -1) {
      return idx;
    }
    return find2(nums, nums[idx]);
  }

  //// --------------- end (Approach2)-------------------------
  //// ---------------start(Approach3)-------------------------
  // 20200308
  // By dfs
  public boolean validTree3(int n, int[][] edges) {
    // buld graph
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      graph.add(new ArrayList<>());
    }
    for (int[] edge : edges) {
      graph.get(edge[0]).add(edge[1]);
      graph.get(edge[1]).add(edge[0]);
    }
    // System.out.format("graph: %s\n", graph);

    // checke cycle by bfs
    boolean[] visited = new boolean[n];
    if (hasCycle(graph, visited, 0, -1)) {
      return false;
    }

    for (boolean visit : visited) {
      if (visit == false) {
        return false;
      }
    }
    return true;
  }

  private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int cur, int parent) {
    if (visited[cur]) {
      return true;
    }

    visited[cur] = true;
    for (Integer neighbor : graph.get(cur)) {
      if (neighbor != parent) {
        boolean ret = hasCycle(graph, visited, neighbor, cur);
        if (ret) {
          return true;
        }
      }
    }

    return false;
  }

  //// --------------- end (Approach3)-------------------------
}
// @lc code=end
