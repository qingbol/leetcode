/*
 * @lc app=leetcode id=305 lang=java
 *
 * [305] Number of Islands II
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200308)///////////////////////////////////
  ////////////////// first round(20200308)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200308

  // 162/162 cases passed (7 ms)
  // Your runtime beats 95.71 % of java submissions
  // Your memory usage beats 92.77 % of java submissions (42.1 MB)

  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    // declare res to hold the result
    int nr = positions.length;
    // int nc = positions[0].length;
    List<Integer> res = new ArrayList<>(nr);

    // build UF array: root array
    int[] roots = new int[m * n];
    Arrays.fill(roots, -1);
    int count = 0;
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // iteratelly add every land. and cal the number islands
    for (int[] pos : positions) {
      int curRoot = n * pos[0] + pos[1];
      // handle duplicates.
      if (roots[curRoot] != -1) {
        res.add(count);
        continue;
      }

      count++;
      roots[curRoot] = curRoot;
      // check it's four neibors.
      // if not belong to the same island, union them.
      for (int[] dir : directions) {
        // location of neighbor
        int x = pos[0] + dir[0];
        int y = pos[1] + dir[1];
        if (x < 0 || x >= m || y < 0 || y >= n || roots[x * n + y] == -1) {
          continue;
        }
        int neighborRoot = find1(roots, x * n + y);

        // union
        if (curRoot != neighborRoot) {
          // System.out.format("(pos[0], pos[1]):(%d,%d) (x, y):(%d, %d),
          // neighboRoot:%d\n", pos[0], pos[1], x, y,
          // neighborRoot);
          count--;
          roots[curRoot] = neighborRoot;
          curRoot = neighborRoot;
        }
      }
      res.add(count);
    }

    return res;
  }

  private int find1(int[] roots, int node) {
    // if (roots[node] == node) {
    // return node;
    // }

    if (roots[node] != node)
      roots[node] = find1(roots, roots[node]);
    return roots[node];
  }
  //// ---------------- end (Approach1)----------------------------------
  /////////////////////////// second round(20201124)///////////////////////
  /////////////////////////// second round(20201124)///////////////////////
  //// ----------------start(Approach2)----------------------------------
  // 20201124.
  //// ---------------- end (Approach2)----------------------------------
}
// @lc code=end
