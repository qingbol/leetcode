/*
 * @lc app=leetcode id=399 lang=java
 *
 * [399] Evaluate Division
 */

// @lc code=start
class Solution {
  //// ---------------start(Appoach1)-----------------------------
  // bfs
  public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
    // build graph
    Map<String, Map<String, Double>> graph = buildGraph(equations, values);

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      res[i] = bfs(graph, queries.get(i).get(0), queries.get(i).get(1), new HashSet<>());
    }
    return res;
  }

  private double bfs(Map<String, Map<String, Double>> graph, String src, String dst, Set<String> visited) {
    // rejection case
    if (!graph.containsKey(src)) {
      return -1.0;
    }
    // accepting case
    if (graph.get(src).containsKey(dst)) {
      return graph.get(src).get(dst);
    }

    visited.add(src);
    for (Map.Entry<String, Double> neighbor : graph.get(src).entrySet()) {
      if (!visited.contains(neighbor.getKey())) {
        double factor = bfs(graph, neighbor.getKey(), dst, visited);
        if (factor != -1.0) {
          return factor * neighbor.getValue();
        }
      }
    }
    return -1.0;
  }

  private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
    Map<String, Map<String, Double>> graph = new HashMap<>();
    for (int i = 0; i < values.length; i++) {
      // for (List lst : equations) {
      String u = equations.get(i).get(0);
      String v = equations.get(i).get(1);
      graph.putIfAbsent(u, new HashMap<>());
      graph.get(u).put(v, values[i]);
      graph.putIfAbsent(v, new HashMap<>());
      graph.get(v).put(u, 1 / values[i]);
    }
    return graph;
  }

  //// --------------- end (Appoach1)-----------------------------
  //// ---------------start(Appoach2)-----------------------------
  // union find
  // https://leetcode.com/problems/evaluate-division/discuss/88170/0ms-C%2B%2B-Union-Find-Solution-EASY-to-UNDERSTAND
  public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, String> parent = new HashMap<>(); // <node, parent of the node>
    Map<String, Double> ratio = new HashMap<>(); // <node, node / parent>
    for (int i = 0; i < equations.size(); i++) {
      union1(parent, ratio, equations.get(i).get(0), equations.get(i).get(1), values[i]);
      System.out.format("parent: %s\n", parent);
      System.out.format("ratio: %s\n", ratio);
      System.out.println("-------------------");
    }

    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String s1 = queries.get(i).get(0), s2 = queries.get(i).get(1);
      // System.out.format("s1: %s, rotio(s1): %f\n", s1, ratio.get(s1));
      if (!parent.containsKey(s1) || !parent.containsKey(s2)
          || !find(parent, ratio, s1).equals(find(parent, ratio, s2))) {
        res[i] = -1.0;
      } else {
        System.out.format("parent: %s\n", parent);
        System.out.format("ratio: %s\n", ratio);
        System.out.format("s1: %s, rotio(s1): %f\n", s1, ratio.get(s1));
        System.out.format("s2: %s, rotio(s2): %f\n", s2, ratio.get(s2));
        res[i] = ratio.get(s1) / ratio.get(s2);
      }
    }
    return res;
  }

  private void union1(Map<String, String> parent, Map<String, Double> ratio, String s1, String s2, double val) {
    if (!parent.containsKey(s1)) {
      parent.put(s1, s1);
      ratio.put(s1, 1.0);
    }
    if (!parent.containsKey(s2)) {
      parent.put(s2, s2);
      ratio.put(s2, 1.0);
    }
    String p1 = find(parent, ratio, s1);
    String p2 = find(parent, ratio, s2);
    parent.put(p1, p2);
    ratio.put(p1, val * ratio.get(s2) / ratio.get(s1));
  }

  private String find(Map<String, String> parent, Map<String, Double> ratio, String s) {
    if (s.equals(parent.get(s))) {
      return s;
    }
    String father = parent.get(s);
    String grandpa = find(parent, ratio, father);
    parent.put(s, grandpa);
    ratio.put(s, ratio.get(s) * ratio.get(father));
    return grandpa;
  }

  //// --------------- end (Appoach2)-----------------------------
  //// ---------------start(Appoach3)-----------------------------
  // by union find, same with approach2
  // just type by myself. modify several varibale name.
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    Map<String, String> roots = new HashMap<>();
    Map<String, Double> ratioToRoot = new HashMap<>();

    // build the root and ratio
    for (int i = 0; i < equations.size(); i++) {
      union2(roots, ratioToRoot, equations.get(i).get(0), equations.get(i).get(1), values[i]);
      // System.out.format("parent: %s\n", roots);
      // System.out.format("ratio: %s\n", ratioToRoot);
      // System.out.println("-------------------");
    }

    // calculate
    double[] res = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String s1 = queries.get(i).get(0);
      String s2 = queries.get(i).get(1);
      // System.out.format("s1:%s, s2: %s\n", s1, s2);

      if (!roots.containsKey(s1) || !roots.containsKey(s2)
          || !(findRoot(roots, ratioToRoot, s1).equals(findRoot(roots, ratioToRoot, s2)))) {
        res[i] = -1.0;
      } else {
        // System.out.format("parent: %s\n", roots);
        // System.out.format("ratio: %s\n", ratioToRoot);
        // System.out.format("s1: %s, rotio(s1): %f\n", s1, ratioToRoot.get(s1));
        // System.out.format("s2: %s, rotio(s2): %f\n", s2, ratioToRoot.get(s2));
        res[i] = ratioToRoot.get(s1) / ratioToRoot.get(s2);
      }
    }
    return res;
  }

  private void union2(Map<String, String> roots, Map<String, Double> ratioToRoot, String numerator, String denominator,
      double val) {
    if (!roots.containsKey(numerator)) {
      roots.put(numerator, numerator);
      ratioToRoot.put(numerator, 1.0);
    }
    if (!roots.containsKey(denominator)) {
      roots.put(denominator, denominator);
      ratioToRoot.put(denominator, 1.0);
    }

    String root1 = findRoot(roots, ratioToRoot, numerator);
    String root2 = findRoot(roots, ratioToRoot, denominator);

    // root2 becom the new root
    roots.put(root1, root2);
    ratioToRoot.put(root1, val * ratioToRoot.get(denominator) / ratioToRoot.get(numerator));
  }

  private String findRoot(Map<String, String> roots, Map<String, Double> ratioToRoot, String s) {
    if (roots.get(s) == s) {
      return s;
    }
    String father = roots.get(s);
    String grandpa = findRoot(roots, ratioToRoot, father);
    roots.put(s, grandpa);
    ratioToRoot.put(s, ratioToRoot.get(s) * ratioToRoot.get(father));

    return grandpa;
  }

  //// --------------- end (Appoach3)-----------------------------
}
// @lc code=end
