import java.util.HashMap;
import java.util.List;

/*
 * @lc app=leetcode id=207 lang=java
 *
 * [207] Course Schedule
 */

// @lc code=start
class Solution {
  //// ---------------------start(Approach1)---------------------------
  // topological sort
  public boolean canFinish1(int numCourses, int[][] prerequisites) {
    int n = prerequisites.length;
    if (prerequisites == null || n == 0) {
      return true;
    }
    // cal the indegree array
    // build graph
    HashMap<Integer, List<Integer>> graph = new HashMap<>();
    int[] indegrees = new int[numCourses];
    for (int[] pre : prerequisites) {
      graph.putIfAbsent(pre[1], new ArrayList<>());
      graph.get(pre[1]).add(pre[0]);
      indegrees[pre[0]]++;
      // outdegrees[pre[1]]++;
    }
    // System.out.format("indegree:%s\n", Arrays.toString(indegrees));
    // System.out.format("graph: %s\n", graph);

    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }
    // System.out.format("queue: %s\n", queue);

    int res = 0;
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      res++;
      if (!graph.containsKey(cur)) {
        continue;
      }
      for (Integer neighbor : graph.get(cur)) {
        indegrees[neighbor]--;
        if (indegrees[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    return res == numCourses;
  }

  //// --------------------- end (Approach1)---------------------------
  //// ---------------------start(Approach2)---------------------------
  // backtracking
  // use a nested list to hold the graph
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // use a nested List to hold the graph
    List<List<Integer>> graph = new ArrayList<>(numCourses);
    for (int i = 0; i < numCourses; i++) {
      graph.add(new ArrayList<>());
    }

    for (int[] edge : prerequisites) {
      graph.get(edge[1]).add(edge[0]);
    }
    // System.out.format("graph: %s\n", graph);

    // traverset every node to check if there's cycle
    boolean[] visited = new boolean[numCourses];
    boolean[] checked = new boolean[numCourses];
    for (int i = 0; i < numCourses; i++) {
      if (isCyclic(graph, visited, checked, i)) {
        return false;
      }
    }
    return true;
  }

  private boolean isCyclic(List<List<Integer>> graph, boolean[] visited, boolean[] checked, int idx) {
    if (checked[idx]) {
      return false;
    }
    if (visited[idx]) {
      return true;
    }
    if (graph.get(idx).size() == 0) {
      return false;
    }

    visited[idx] = true;
    boolean ret = false;
    for (Integer neighbor : graph.get(idx)) {
      ret = isCyclic(graph, visited, checked, neighbor);
      if (ret) {
        break;
      }
    }
    visited[idx] = false;
    checked[idx] = true;
    return ret;
  }
  //// ------------------- end (Approach2)---------------------------------
  /////////////////////////// second round(20201124)///////////////////////
  /////////////////////////// second round(20201124)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201124.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
