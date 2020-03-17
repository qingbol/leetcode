/*
 * @lc app=leetcode id=210 lang=java
 *
 * [210] Course Schedule II
 */

// @lc code=start
class Solution {
  //// ---------------------start(Approach1)----------------------------
  // Bfs, recursion
  public int[] findOrder1(int numCourses, int[][] prerequisites) {
    // build adjacency list with hashmap
    Map<Integer, List<Integer>> neighbors = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      int k = prerequisites[i][1];
      int v = prerequisites[i][0];
      if (!neighbors.containsKey(k)) {
        neighbors.put(k, new ArrayList<>());
      }
      neighbors.get(k).add(v);
    }
    // System.out.format("nodes: %s\n", neighbors);

    // initialize the nodes's states
    Map<Integer, Integer> states = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      states.put(i, 0);
    }
    List<Integer> lst = new ArrayList<>();

    // Bfs
    boolean isCyclic = false;
    for (int i = 0; i < numCourses; i++) {
      if (!helper1(neighbors, states, lst, i)) {
        return new int[0];
      }
    }

    // System.out.format("res:%s\n", lst);
    // output the result
    // if (!isCyclic) {
    // return new int[] {};
    // }
    Collections.reverse(lst);
    Integer[] ret = new Integer[numCourses];
    ret = lst.toArray(ret);
    int[] res = new int[numCourses];
    for (int i = 0; i < numCourses; i++) {
      res[i] = ret[i].intValue();
    }
    return res;
  }

  private boolean helper1(Map<Integer, List<Integer>> neighbors, Map<Integer, Integer> states, List<Integer> res,
      int node) {
    // System.out.format("node: %d, states: %s\n", node, states);
    if (states.get(node) == 2) {
      return true;
    } else if (states.get(node).equals(1)) {
      // System.out.format("false\n");
      return false;
    }
    if (states.get(node) == 0) {
      states.put(node, 1);
    }
    if (neighbors.containsKey(node)) {
      for (int neighbor : neighbors.get(node)) {
        // if (states.get(neighbor) == 0) {
        if (!helper1(neighbors, states, res, neighbor)) {
          return false;
        }
        // }
      }
    }
    states.put(node, 2);
    res.add(node);
    return true;
  }

  //// --------------------- end (Approach1)----------------------------
  //// ---------------------start(Approach2)----------------------------
  // improve approach1 by standard solution
  // use instance variable isAcyclic
  boolean isAcyclic = true;

  public int[] findOrder2(int numCourses, int[][] prerequisites) {
    // build adjacency list representation
    Map<Integer, List<Integer>> neighbors = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      neighbors.put(i, new ArrayList<>());
    }
    for (int i = 0; i < prerequisites.length; i++) {
      int k = prerequisites[i][1];
      int v = prerequisites[i][0];
      neighbors.get(k).add(v);
    }

    // initialize the state of nodes
    Map<Integer, Integer> status = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      status.put(i, 0);
    }

    // create a list to store the topological order
    List<Integer> lst = new ArrayList<>();

    // use bfs to traverse
    for (int i = 0; i < numCourses; i++) {
      if (status.get(i) == 0) {
        helper2(neighbors, status, lst, i);
      }
    }

    // outpute the result;
    // System.out.format("isAcyclic: %b\n", isAcyclic);
    int[] res;
    if (!isAcyclic) {
      res = new int[0];
    } else {
      res = new int[numCourses];
      for (int i = 0; i < numCourses; i++) {
        res[i] = lst.get(numCourses - 1 - i);
      }
    }
    return res;
  }

  private void helper2(Map<Integer, List<Integer>> neighbors, Map<Integer, Integer> status, List<Integer> lst,
      int node) {
    // don't recurse further, if graph is cyclic
    if (!isAcyclic) {
      return;
    }

    // start the recursion from node. mark it as 1.
    status.put(node, 1);

    // traverse on nieghboring nodes
    for (Integer neighbor : neighbors.get(node)) {
      if (status.get(neighbor) == 0) {
        helper2(neighbors, status, lst, neighbor);
      } else if (status.get(neighbor) == 1) {
        // System.out.format("false\n");
        isAcyclic = false;
      }
    }

    // recursion frome node end, mark it as 2
    status.put(node, 2);
    lst.add(node);
  }

  //// --------------------- end (Approach2)----------------------------
  //// ---------------------start(Approach3)----------------------------
  // use node indegree. topological sort
  // optimal
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // build adjcency list and indegree array
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    int[] indegrees = new int[numCourses];
    for (int i = 0; i < prerequisites.length; i++) {
      int src = prerequisites[i][1];
      int dst = prerequisites[i][0];
      List<Integer> list = adjList.getOrDefault(src, new ArrayList<>());
      list.add(dst);
      adjList.put(src, list);

      indegrees[dst]++;
    }

    // create queue and initialize it.
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < numCourses; i++) {
      if (indegrees[i] == 0) {
        queue.offer(i);
      }
    }

    // create a list to store the result
    int[] res = new int[numCourses];
    int idx = 0;
    while (!queue.isEmpty()) {
      Integer cur = queue.poll();
      res[idx++] = cur;
      if (adjList.containsKey(cur)) {
        for (Integer neighbor : adjList.get(cur)) {
          indegrees[neighbor]--;
          if (indegrees[neighbor] == 0) {
            queue.offer(neighbor);
          }
        }
      }
    }

    // output result
    if (idx == numCourses) {
      return res;
    }
    return new int[0];
  }

  //// --------------------- end (Approach3)----------------------------
}
// @lc code=end
