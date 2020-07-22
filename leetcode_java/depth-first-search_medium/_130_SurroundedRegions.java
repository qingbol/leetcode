/*
 * @lc app=leetcode id=130 lang=java
 *
 * [130] Surrounded Regions
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200309)////////////////////////////
  /////////////////////// first round(20200309)////////////////////////////
  //// -----------------start(Approach1)-----------------
  // 20200309, bfs

  // 59/59 cases passed (2 ms)
  // Your runtime beats 50.96 % of java submissions
  // Your memory usage beats 7.17 % of java submissions (48.9 MB)

  public void solve1(char[][] board) {
    // public void solve(char[][] board) {
    // System.out.format("board: %s\n", Arrays.deepToString(board));
    if (board.length < 3 || board[0].length < 3) {
      return;
    }
    int nr = board.length;
    int nc = board[0].length;

    // traverse the top and bottome border
    for (int j = 0; j < nc; j++) {
      if (board[0][j] == 'O') {
        bfs1(board, 0, j);
      }
      if (board[nr - 1][j] == 'O') {
        bfs1(board, nr - 1, j);
      }
    }

    for (int i = 0; i < nr; i++) {
      if (board[i][0] == 'O') {
        bfs1(board, i, 0);
      }
      if (board[i][nc - 1] == 'O') {
        bfs1(board, i, nc - 1);
      }
    }

    // Post processing, turn 'E' to 'X', turn
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (board[i][j] == 'E') {
          board[i][j] = 'O';
        } else if (board[i][j] == 'O') {
          board[i][j] = 'X';
        }
      }
    }
  }

  private void bfs1(char[][] board, int r, int c) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
      return;
    }
    board[r][c] = 'E';
    bfs1(board, r - 1, c);
    bfs1(board, r + 1, c);
    bfs1(board, r, c - 1);
    bfs1(board, r, c + 1);
  }

  //// ----------------- end (Approach1)-----------------
  /////////////////////// second round(20200721)////////////////////////////
  //// -----------------start(Approach2)-----------------
  // 20200721: union find
  // refer to labuladong <Union-Find算法应用>
  // https://github.com/labuladong/fucking-algorithm/blob/master/%E7%AE%97%E6%B3%95%E6%80%9D%E7%BB%B4%E7%B3%BB%E5%88%97/UnionFind%E7%AE%97%E6%B3%95%E5%BA%94%E7%94%A8.md

  // Wrong Answer
  // 58/59 cases passed (N/A)

  public void solve(char[][] board) {
    // public void solve2(char[][] board) {
    if (board.length < 3 || board[0].length < 3) {
      return;
    }
    int m = board.length;
    int n = board[0].length;
    UnionFind uf = new UnionFind(m * n + 1);
    // UF uf = new UF(m * n + 1);
    int dummy = m * n;

    // connect the 'O' on the edge with dummy.
    for (int i = 0; i < m; i++) {
      if (board[i][0] == 'O') {
        uf.union(i * n, dummy);
        // uf.union(dummy, i * n);
      }
      if (board[i][n - 1] == 'O') {
        uf.union(i * n + n - 1, dummy);
      }
    }

    for (int j = 0; j < n; j++) {
      if (board[0][j] == 'O') {
        uf.union(j, dummy);
      }
      if (board[m - 1][j] == 'O') {
        uf.union((m - 1) * n + j, dummy);
      }
    }

    // connect the inside 'O'
    int[][] direction = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
    for (int i = 1; i < m - 1; i++) {
      for (int j = 1; j < n - 1; j++) {
        if (board[i][j] == 'O') {
          for (int k = 0; k < 4; k++) {
            int x = i + direction[k][0];
            int y = j + direction[k][1];
            if (board[x][y] == 'O') {
              if (i == 4 && j == 13) {
                System.out.format("i: %d, j: %d, board[] : %c \n", i, j, board[i][j]);
                System.out.format("x: %d, y: %d, board[] : %c \n", x, y, board[x][y]);
              }
              uf.union(x * n + y, i * n + j);
            }
          }
        }
      }
    }

    // substitute the cell which not connect to dummy
    // for (int i = 0; i < m; i++) {
    for (int i = 1; i < m - 1; i++) {
      // for (int j = 0; j < n ; j++) {
      for (int j = 1; j < n - 1; j++) {
        if (!uf.connected(dummy, i * n + j)) {
          // if (board[i][j] == 'O' && !uf.isConnected(dummy, i * n + j)) {
          board[i][j] = 'X';
        }
      }
    }
  }

  class UnionFind {
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      size = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
        size[i] = 1;
      }
    }

    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) {
        return;
      }

      if (size[rootP] > size[rootQ]) {
        parent[rootQ] = rootP;
        size[rootP] += size[rootQ];
      } else {
        parent[rootP] = rootQ;
        size[rootQ] += size[rootP];
      }
      count--;
    }

    private int find(int x) {
      //note: dont use if here. 
      while (parent[x] != x) {
      // if (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
      }
      return x;
    }

    public boolean connected(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (q == 93 || q == 112)
        System.out.format("p: %d, rootP: %d; q: %d, rootQ: %d\n", p, rootP, q, rootQ);
      return rootP == rootQ;
    }

    public int count() {
      return count;
    }
  }

  //// ----------------- end (Approach2)-------------------------
  //// -----------------start(Approach3)-------------------------
  // public void solve(char[][] board) {
  public void solve3(char[][] board) {
  }
  //// ----------------- end (Approach3)-----------------
}
// @lc code=end
