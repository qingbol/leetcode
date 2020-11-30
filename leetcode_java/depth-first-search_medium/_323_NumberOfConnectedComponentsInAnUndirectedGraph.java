/*
 * @lc app=leetcode id=323 lang=java
 *
 * [323] Number of Connected Components in an Undirected Graph
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200303)///////////////////////////////////
  ////////////////// first round(20200303)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200303 
  // Quick find
  public int countComponents1(int n, int[][] edges) {
    int res = n;
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int[] edge : edges) {
      res = union1(parent, edge[0], edge[1], res);
    }
    return res;
  }

  private int union1(int[] parent, int x, int y, int cnt) {
    int parent0 = find1(parent, x);
    int parent1 = find1(parent, y);
    if (parent0 == parent1) {
      return cnt;
    }

    for (int i = 0; i < parent.length; i++) {
      if (parent[i] == parent0) {
        parent[i] = parent1;
      }
    }
    return --cnt;
  }

  private int find1(int[] parent, int idx) {
    return parent[idx];
  }

  //// ------------------ end (Approach1)---------------------------------
  //// ------------------start(Approach2)---------------------------------
  //// ------------------ end (Approach2)---------------------------------
  // Quick union
  public int countComponents(int n, int[][] edges) {
    int res = n;
    // build nodes
    int[] parent = new int[n];
    for (int i = 0; i < n; i++) {
      parent[i] = i;
    }

    for (int[] edge : edges) {
      int root0 = find2(parent, edge[0]);
      int root1 = find2(parent, edge[1]);
      if (root0 != root1) {
        parent[root0] = root1;
        // parent[edge[0]] = root1; //wrong
        res--;
      }
    }
    return res;
  }

  private int find2(int[] parent, int idx) {
    while (idx != parent[idx]) {
      parent[idx] = parent[parent[idx]]; // bonus. 67% -> 100%
      idx = parent[idx];
    }
    return idx;
  }

  //// ---------------- end (Approach2)----------------------------------
  /////////////////////////// second round(20201124)///////////////////////
  /////////////////////////// second round(20201124)///////////////////////
  //// ----------------start(Approach3)----------------------------------
  // 20201124.
  //// ---------------- end (Approach3)----------------------------------
}
// @lc code=end
