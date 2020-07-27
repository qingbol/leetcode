/*
 * @lc app=leetcode id=886 lang=java
 *
 * [886] Possible Bipartition
 */

// @lc code=start
class Solution {
  /////////////////////// first round(20200724)/////////////////////
  /////////////////////// first round(20200724)/////////////////////
  //// -------------------------start(Approah1)--------------------
  // 20200724.
  // refer to leetcode discusion
  // https://leetcode.com/problems/possible-bipartition/discuss/159085/java-graph

  // 70/70 cases passed (27 ms)
  // Your runtime beats 40.25 % of java submissions
  // Your memory usage beats 5.02 % of java submissions (86.2 MB)

  enum Color {
    RED, BLUE, UNKNOWN
  }

  public boolean possibleBipartition(int N, int[][] dislikes) {
    // public boolean possibleBipartition1(int N, int[][] dislikes) {
    Color[] color = new Color[N + 1];
    Arrays.fill(color, Color.UNKNOWN);

    List<List<Integer>> adj = new ArrayList<>(N + 1);
    for (int i = 0; i <= N; i++)
      adj.add(new ArrayList<>());
    for (int[] dislike : dislikes) {
      adj.get(dislike[0]).add(dislike[1]);
      adj.get(dislike[1]).add(dislike[0]);
    }

    // coloring
    for (int i = 1; i <= N; i++) {
      if (color[i] != Color.UNKNOWN)
        continue;
      color[i] = Color.RED;
      Queue<Integer> queue = new ArrayDeque<>();
      queue.offer(i);
      while (!queue.isEmpty()) {
        int cur = queue.poll();
        for (int neighbor : adj.get(cur)) {
          if (color[neighbor] == Color.UNKNOWN) {
            color[neighbor] = color[cur] == Color.RED ? Color.BLUE : Color.RED;
            queue.offer(neighbor);
          } else {
            if (color[neighbor] == color[cur])
              return false;
          }
        }
      }
    }

    return true;
  }
  //// ------------------------- end (Approah1)--------------------
}
// @lc code=end
