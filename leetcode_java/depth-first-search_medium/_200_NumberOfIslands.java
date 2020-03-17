/*
 * @lc app=leetcode id=200 lang=java
 *
 * [200] Number of Islands
 */

// @lc code=start
class Solution {
  //// -----------------------start(Approach1)-----------------------
  // flood fill, dfs.
  // optimal
  // Your runtime beats 99.98 % of java submissions
  // much better than bfs
  public int numIslands1(char[][] grid) {
    int res = 0;
    if (null == grid || grid.length == 0) {
      return res;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == '1') {
          ++res;
          dfs(grid, i, j);
        }
      }
    }
    return res;
  }

  private void dfs(char[][] grid, int i, int j) {
    int nr = grid.length;
    int nc = grid[0].length;
    if (i < 0 || i >= nr || j < 0 || j >= nc || grid[i][j] == '0') {
      return;
    }

    grid[i][j] = '0';
    dfs(grid, i - 1, j);
    dfs(grid, i + 1, j);
    dfs(grid, i, j - 1);
    dfs(grid, i, j + 1);
  }

  //// ----------------------- end (Approach1)-----------------------
  //// -----------------------start(Approach2)-----------------------
  // Flood fill, bfs
  // Your runtime beats 46.25 % of java submissions
  // If put "grid[cur.x][cur.y] = '0';" after queue.poll, there will be "
  // Time Limit Exceeded. 38/47 cases passed (N/A)
  // [["1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","0","1","0","1","1"],["0","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","0"],["1","0","1","1","1","0","0","1","1","0","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","0","0","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","0","1","1","1","1","1","1","0","1","1","1","0","1","1","1","0","1","1","1"],["0","1","1","1","1","1","1","1","1","1","1","1","0","1","1","0","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","1","1"],["1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["0","1","1","1","1","1","1","1","0","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","0","1","1","1","1","1","1","1","0","1","1","1","1","1","1"],["1","0","1","1","1","1","1","0","1","1","1","0","1","1","1","1","0","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","1","1","0"],["1","1","1","1","1","1","1","1","1","1","1","1","1","0","1","1","1","1","0","0"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"],["1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1","1"]]
  public int numIslands2(char[][] grid) {
    int res = 0;
    if (grid == null || grid.length == 0) {
      return res;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == '1') {
          ++res;
          bfs(grid, i, j);
        }
      }
    }
    return res;
  }

  private void bfs(char[][] grid, int i, int j) {
    int nr = grid.length;
    int nc = grid[0].length;
    Deque<Point> queue = new ArrayDeque<>();
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    queue.offer(new Point(i, j));
    grid[i][j] = '0';
    while (!queue.isEmpty()) {
      Point cur = queue.poll();
      // grid[cur.x][cur.y] = '0'; //put here, will lead to TLE

      for (int[] dir : directions) {
        int newX = cur.x + dir[0];
        int newY = cur.y + dir[1];
        if (newX < 0 || newX >= nr || newY < 0 || newY >= nc || grid[newX][newY] == '0') {
          continue;
        }
        queue.offer(new Point(newX, newY));
        grid[newX][newY] = '0';
      }
    }
  }

  private class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }

  //// ----------------------- end (Approach2)-----------------------
  //// -----------------------start(Approach3)-----------------------
  // by union find.
  class UnionFind {
    int count; // # of connected components
    int[] parent;
    int[] rank;

    public UnionFind(char[][] grid) { // for problem 200
      count = 0;
      int m = grid.length;
      int n = grid[0].length;
      parent = new int[m * n];
      rank = new int[m * n];
      for (int i = 0; i < m; ++i) {
        for (int j = 0; j < n; ++j) {
          if (grid[i][j] == '1') {
            parent[i * n + j] = i * n + j;
            ++count;
          }
          rank[i * n + j] = 0;
        }
      }
    }

    public int find(int i) { // path compression
      if (parent[i] != i)
        parent[i] = find(parent[i]);
      return parent[i];
    }

    public void union(int x, int y) { // union with rank
      int rootx = find(x);
      int rooty = find(y);
      if (rootx != rooty) {
        if (rank[rootx] > rank[rooty]) {
          parent[rooty] = rootx;
        } else if (rank[rootx] < rank[rooty]) {
          parent[rootx] = rooty;
        } else {
          parent[rooty] = rootx;
          rank[rootx] += 1;
        }
        --count;
      }
    }

    public int getCount() {
      return count;
    }
  }

  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    int nr = grid.length;
    int nc = grid[0].length;
    // int num_islands = 0;
    UnionFind uf = new UnionFind(grid);
    for (int r = 0; r < nr; ++r) {
      for (int c = 0; c < nc; ++c) {
        if (grid[r][c] == '1') {
          grid[r][c] = '0';
          if (r - 1 >= 0 && grid[r - 1][c] == '1') {
            // grid[r - 1][c] = '0';
            uf.union(r * nc + c, (r - 1) * nc + c);
          }
          if (r + 1 < nr && grid[r + 1][c] == '1') {
            // grid[r + 1][c] = '0';
            uf.union(r * nc + c, (r + 1) * nc + c);
          }
          if (c - 1 >= 0 && grid[r][c - 1] == '1') {
            // grid[r][c - 1] = '0';
            uf.union(r * nc + c, r * nc + c - 1);
          }
          if (c + 1 < nc && grid[r][c + 1] == '1') {
            // grid[r][c + 1] = '0';
            uf.union(r * nc + c, r * nc + c + 1);
          }
        }
      }
    }

    return uf.getCount();
  }
  //// ----------------------- end (Approach3)-----------------------
}
// @lc code=end
