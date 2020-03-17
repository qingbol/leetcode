/*
 * @lc app=leetcode id=317 lang=java
 *
 * [317] Shortest Distance from All Buildings
 */

// @lc code=start
class Solution {
  //// -----------------start(Approach1)-----------------------------
  // 20200309
  // bfs
  public int shortestDistance(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return 0;
    }

    // declare the needed data structure
    int nr = grid.length;
    int nc = grid[0].length;
    int[][] distance = new int[nr][nc];
    int[][] reachNum = new int[nr][nc];
    int buildingNum = 0;

    // traverse the whole node. to find every building.
    // Then, cal the distance from empyt land to this buiding.
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          buildingNum++;
          bfs1(grid, distance, reachNum, i, j);
        }
      }
    }
    // System.out.format("distance: %s\n", Arrays.deepToString(distance));

    // extract the shortest distance.
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (grid[i][j] == 0 && buildingNum == reachNum[i][j]) {
          res = Math.min(res, distance[i][j]);
        }
      }
    }

    return res == Integer.MAX_VALUE ? -1 : res;
  }

  private void bfs1(int[][] grid, int[][] distance, int[][] reachNum, int row, int col) {
    int nr = grid.length;
    int nc = grid[0].length;
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    boolean[][] visited = new boolean[nr][nc];
    Deque<Tuple> queue = new ArrayDeque<>();
    int level = 1;

    queue.offer(new Tuple(row, col));
    while (!queue.isEmpty()) {
      int size = queue.size();

      // traverse level by level
      for (int i = 0; i < size; i++) {
        Tuple cur = queue.poll();
        for (int[] dir : directions) {
          int newR = cur.r + dir[0];
          int newC = cur.c + dir[1];
          if (newR < 0 || newR >= nr || newC < 0 || newC >= nc || grid[newR][newC] != 0
              || visited[newR][newC] == true) {
            continue;
          }
          distance[newR][newC] += level;
          reachNum[newR][newC]++;
          visited[newR][newC] = true;
          queue.offer(new Tuple(newR, newC));
        }
      }
      level++;

    }
  }

  private class Tuple {
    int r;
    int c;

    public Tuple(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }
}
// @lc code=end
