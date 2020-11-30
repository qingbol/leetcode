/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 */

// @lc code=start
class Solution {
  ////////////////// first round(202000305)////////////////////////////////////
  ////////////////// first round(202000305)////////////////////////////////////
  //// -------------------start(Approach1)---------------------------------
  // 20200305.
  // backtrack + greedy + List

  // Your runtime beats 13.32 % of java submissions

  public List<String> findItinerary1(List<List<String>> tickets) {
    // 1: build the graph
    Map<String, List<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
      String k = ticket.get(0);
      String v = ticket.get(1);
      graph.putIfAbsent(k, new ArrayList<>());
      graph.get(k).add(v);
    }
    // System.out.format("graph: %s\n", graph);

    // sort the neighbors and inialize the visited map
    // The default value of List is null. So we have to use Boolean[]
    Map<String, List<Boolean>> visited = new HashMap<>();
    // Map<String,Boolean[]> visited = new HashMap<>();
    // for (List<String> value : graph.values()) {
    for (Map.Entry<String, List<String>> entry : graph.entrySet()) {
      Collections.sort(entry.getValue());
      int len = entry.getValue().size();
      visited.put(entry.getKey(), new ArrayList<>(Collections.nCopies(len, false)));
    }
    // System.out.format("visited: %s\n", visited);

    // 2: create needed container
    int nTicket = tickets.size();
    List<String> res = new ArrayList<>();
    // List<String> res = null;
    List<String> lst = new ArrayList<>();

    // 3: search
    lst.add("JFK");
    backtrack1(graph, nTicket, visited, res, lst, "JFK");
    return res;
  }

  private boolean backtrack1(Map<String, List<String>> graph, int nTicket,
      Map<String, List<Boolean>> visited, List<String> res, List<String> lst, String src) {
    if (lst.size() == nTicket + 1) {
      // res = (List<String>) lst.clone();
      res.clear();
      res.addAll(lst);
      // System.out.format("lst:%s\n", lst);
      return true;
    }

    if (!graph.containsKey(src)) {
      return false;
    }

    for (int i = 0; i < graph.get(src).size(); i++) {
      // System.out.format("i: %d\n", i);
      String neighbor = graph.get(src).get(i);
      Boolean isVisited = visited.get(src).get(i);
      if (!isVisited) {
        visited.get(src).set(i, true);
        lst.add(neighbor);
        boolean ret = backtrack1(graph, nTicket, visited, res, lst, neighbor);
        // lst.pollLast();
        lst.remove(lst.size() - 1);
        visited.get(src).set(i, false);

        // we need this to stop the further search.
        if (ret) {
          return true;
        }
      }
    }
    return false;
  }

  //// -------------------start(Approach1)------------------------
  //// ------------------- end (Approach2)------------------------
  // Eulerian path algo + List
  //refer to leetcode: Approach 2: Hierholzer's Algorithm

  public List<String> findItinerary2(List<List<String>> tickets) {
    // build grapsh
    Map<String, LinkedList<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
      String k = ticket.get(0);
      String v = ticket.get(1);
      graph.putIfAbsent(k, new LinkedList<>());
      graph.get(k).add(v);
    }
    // System.out.format("graph: %s\n", graph);

    // sort the list
    graph.forEach((k, v) -> Collections.sort(v));

    // declare a list to hold the res
    LinkedList<String> res = new LinkedList<>();

    backtrack2(graph, res, "JFK");

    return res;
  }

  private void backtrack2(Map<String, LinkedList<String>> graph, List<String> res, String src) {
    while (graph.containsKey(src) && !graph.get(src).isEmpty()) {
      String neighbor = graph.get(src).poll();
      backtrack2(graph, res, neighbor);
    }
    res.add(0, src);
  }

  //// ------------------- end (Approach2)------------------------
  //// -------------------start(Approach3)------------------------
  // Eulerian path + priorityQueue
  //refer to leetcode: Approach 2: Hierholzer's Algorithm

  // 80/80 cases passed (5 ms)
  // Your runtime beats 72.92 % of java submissions
  // Your memory usage beats 86.29 % of java submissions (39.5 MB)

  public List<String> findItinerary(List<List<String>> tickets) {
    // build the graph
    Map<String, Queue<String>> graph = new HashMap<>();
    for (List<String> ticket : tickets) {
      String k = ticket.get(0);
      String v = ticket.get(1);
      graph.putIfAbsent(k, new PriorityQueue<>());
      graph.get(k).add(v);
    }

    //
    LinkedList<String> res = new LinkedList<>();

    backtrack3(graph, res, "JFK");
    return res;
  }

  private void backtrack3(Map<String, Queue<String>> graph, LinkedList<String> res, String src) {
    while (graph.containsKey(src) && !graph.get(src).isEmpty()) {
      String dst = graph.get(src).poll();
      backtrack3(graph, res, dst);
    }
    res.offerFirst(src);
  }

  //// ------------------- end (Approach3)---------------------------------
  /////////////////////////// second round(20201122)///////////////////////
  /////////////////////////// second round(20201122)///////////////////////
  //// ----------------start(Approach4)----------------------------------
  // 20201122.
  //// ---------------- end (Approach4)----------------------------------
}
// @lc code=end
