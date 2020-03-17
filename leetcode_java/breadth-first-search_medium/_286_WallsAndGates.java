/*
 * @lc app=leetcode id=286 lang=java
 *
 * [286] Walls and Gates
 */

// @lc code=start
class Solution {
  //// ------------start(Approach1)--------------------------------
  // 20200309
  // by bfs.
  public void wallsAndGates(int[][] rooms) {
    if (rooms == null || rooms.length == 0) {
      return;
    }
    int nr = rooms.length;
    int nc = rooms[0].length;
    Deque<Tuple> queue = new ArrayDeque<>();
    for (int i = 0; i < nr; i++) {
      for (int j = 0; j < nc; j++) {
        if (rooms[i][j] == 0) {
          queue.offer(new Tuple(i, j));
          // queue.offer(new Tuple(i, j, 0));
        }
      }
    }
    bfs1(queue, rooms);
    // System.out.format("queue:%s\n", queue);
  }

  private void bfs1(Deque<Tuple> queue, int[][] rooms) {
    int[][] directions = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
    // Deque<Tuple> queue = new ArrayDeque<>();
    // queue.offer(new Tuple(r, c, 0));

    while (!queue.isEmpty()) {
      // System.out.format("queue:%s\n", queue);
      // int size = queue.size();
      // for (int i = 0; i < size; i++) {
      Tuple cur = queue.poll();
      for (int[] dir : directions) {
        int h = cur.r + dir[0];
        int v = cur.c + dir[1];
        // int level = cur.val + 1;
        if (h < 0 || h >= rooms.length || v < 0 || v >= rooms[0].length || rooms[h][v] != Integer.MAX_VALUE) {
          continue;
        }
        rooms[h][v] = rooms[cur.r][cur.c] + 1;
        // rooms[h][v] = level;
        queue.offer(new Tuple(h, v));
        // queue.offer(new Tuple(h, v, level));
      }
      // }
    }
  }

  private class Tuple {
    int r;
    int c;
    // int val;

    public Tuple(int r, int c) {
      // public Tuple(int r, int c, int val) {
      this.r = r;
      this.c = c;
      // this.val = val;
    }
  }
}
// @lc code=end
