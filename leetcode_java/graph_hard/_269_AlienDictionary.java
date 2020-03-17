import java.util.Map;

/*
 * @lc app=leetcode id=269 lang=java
 *
 * [269] Alien Dictionary
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)---------------------------------
  // wrote by myself.
  // The dict container is redundant
  public String alienOrder1(String[] words) {
    // generate the dictionary
    Set<Character> dict = new HashSet<>();
    for (String word : words) {
      for (char ch : word.toCharArray()) {
        dict.add(ch);
      }
    }

    // generate the graph
    Map<Character, Set<Character>> graph = new HashMap<>();
    for (int i = 0; i < words.length - 1; i++) {
      // if (words[i].equals(words[i + 1])) {
      // dict.add(words[i]);
      // continue;
      // }
      for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
        char p = words[i].charAt(j);
        char n = words[i + 1].charAt(j);
        // dict.add(p);
        // dict.add(n);
        if (p != n) {
          graph.putIfAbsent(p, new HashSet<>());
          graph.get(p).add(n);
          break;
        }
      }
    }
    // System.out.format("graph: %s\n", graph);

    // genereate the indegree map from graph and dict
    Map<Character, Integer> degree = new HashMap<>();
    for (Character c : dict) {
      degree.put(c, 0);
    }
    for (Set<Character> set : graph.values()) {
      // System.out.format("val: %s\n", set);
      for (Character ch : set) {
        // degree.putIfAbsent(ch, 0);
        degree.put(ch, degree.get(ch) + 1);
      }
    }
    // System.out.format("indegree: %s\n", Arrays.toString(indegree));
    // System.out.format("degree: %s\n", degree);

    // topological sort
    Deque<Character> queue = new ArrayDeque<>();
    for (Map.Entry<Character, Integer> entry : degree.entrySet()) {
      if (entry.getValue() == 0) {
        queue.offer(entry.getKey());
      }
    }
    // System.out.format("queue: %s\n", queue);

    StringBuilder sb = new StringBuilder();
    while (!queue.isEmpty()) {
      Character cur = queue.poll();
      sb.append(cur);
      if (!graph.containsKey(cur)) {
        continue;
      }
      // System.out.format("sb: %s\n", sb.toString());
      for (Character neighbor : graph.get(cur)) {
        degree.put(neighbor, degree.get(neighbor) - 1);
        if (degree.get(neighbor) == 0) {
          // System.out.format("neighbor: %c, degree: %d\n", neighbor,
          // degree.get(neighbor));
          queue.offer(neighbor);
        }
      }
      // System.out.format("queue: %s\n", queue);
    }
    // System.out.format("sb: %s\n", sb.toString());
    return dict.size() == sb.length() ? sb.toString() : "";
  }

  //// ---------------- end (Approach1)---------------------------------
  //// ----------------start(Approach2)---------------------------------
  // imporement of Approach1
  // remove the redundant dict container.
  public String alienOrder(String[] words) {
    // Build graph map and indegree map
    Map<Character, Set<Character>> graph = new HashMap<>();
    Map<Character, Integer> degree = new HashMap<>();
    buildGraph2(graph, degree, words);

    // topological sort
    StringBuilder res = new StringBuilder();
    topoSort2(graph, degree, res);
    return degree.size() == res.length() ? res.toString() : "";
  }

  private void topoSort2(Map<Character, Set<Character>> graph, Map<Character, Integer> degree, StringBuilder res) {
    Deque<Character> queue = new ArrayDeque<>();
    for (char k : degree.keySet()) {
      if (degree.get(k) == 0) {
        queue.offer(k);
      }
    }

    while (!queue.isEmpty()) {
      char cur = queue.poll();
      res.append(cur);

      if (!graph.containsKey(cur)) {
        continue;
      }
      for (Character neighbor : graph.get(cur)) {
        degree.put(neighbor, degree.get(neighbor) - 1);
        if (degree.get(neighbor) == 0) {
          queue.offer(neighbor);
        }
      }
    }
    // System.out.format("res: %s\n", res.toString());
  }

  private void buildGraph2(Map<Character, Set<Character>> graph, Map<Character, Integer> degree, String[] words) {
    // initialize the indegreee map
    for (String word : words) {
      for (char ch : word.toCharArray()) {
        degree.put(ch, 0);
      }
    }

    // generate the graph and indegree
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
        char p = words[i].charAt(j);
        char n = words[i + 1].charAt(j);
        if (p != n) {
          graph.putIfAbsent(p, new HashSet<>());
          if (!graph.get(p).contains(n)) {
            graph.get(p).add(n);
            degree.put(n, degree.get(n) + 1);
          }
          // very important, if the different character is found. stop search further.
          break;
        }
      }
    }
    // System.out.format("graph: %s\n", graph);
    // System.out.format("degree: %s\n", degree);
  }
  //// ---------------- end (Approach2)---------------------------------
  //// ----------------start(Approach3)---------------------------------
  //// ---------------- end (Approach3)---------------------------------
}
// @lc code=end
