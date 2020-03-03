import java.lang.module.ModuleFinder;

/*
 * @lc app=leetcode id=378 lang=java
 *
 * [378] Kth Smallest Element in a Sorted Matrix
 */

// @lc code=start
class Solution {
  //// --------------start(Approach1)-------------------------------
  public int kthSmallest1(int[][] matrix, int k) {
    int n = matrix.length;
    // int n = matrix[0].length;
    for (int i = 0; i < n * n; i++) {
      if (i == k - 1) {
        return matrix[i / n][i % n];
      }
    }
    return -1;
  }
  //// -------------- end (Approach1)-------------------------------
  //// --------------start(Approach2)-------------------------------

  // binary search left<= right
  public int kthSmallest2(int[][] matrix, int k) {
    int n = matrix.length;
    int lo = matrix[0][0];
    int hi = matrix[n - 1][n - 1];
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      int num = count2(matrix, mid);
      // System.out.format("lo:%d, mid:%d, hi:%d|num:%d\n", lo, mid, hi, num);
      if (num < k) {
        lo = mid + 1;
      } else if (num >= k) {
        hi = mid;
        // } else if (num == k) {
        // hi = mid;
      }
    }
    // System.out.format("lo:%d, hi:%d\n", lo, hi);
    return lo;
  }

  private int count2(int[][] mat, int val) {
    int row = mat.length - 1;
    int col = 0;
    int cnt = 0;
    while (row >= 0 && col < mat.length) {
      if (mat[row][col] <= val) {
        cnt += row + 1;
        col++;
      } else {
        row--;
      }
    }
    return cnt;
  }

  //// -------------- end (Approach2)-------------------------------
  //// --------------start(Approach3)-------------------------------
  // approach: binary search (left+ 1 < right)
  public int kthSmallest3(int[][] matrix, int k) {
    int n = matrix.length;
    int lo = matrix[0][0];
    int hi = matrix[n - 1][n - 1];
    while (lo + 1 < hi) {
      int mid = lo + (hi - lo) / 2;
      int num = count3(matrix, mid);
      // System.out.format("lo:%d, mid:%d, hi:%d|num:%d\n", lo, mid, hi, num);
      if (num >= k) {
        hi = mid;
      } else if (num < k) {
        lo = mid;
      }
    }
    // System.out.format("lo:%d, hi:%d\n", lo, hi);
    if (count3(matrix, hi) <= k - 1) {
      return hi;
    }
    return lo;
  }

  private int count3(int[][] mat, int val) {
    int row = mat.length - 1;
    int col = 0;
    int cnt = 0;
    while (row >= 0 && col < mat.length) {
      if (mat[row][col] < val) {
        cnt += row + 1;
        col++;
      } else {
        row--;
      }
    }
    return cnt;
  }

  //// -------------- end (Approach3)-------------------------------
  //// --------------start(Approach4)-------------------------------
  // priority queue
  // optimal,
  // same idea with T373
  public int kthSmallest(int[][] matrix, int k) {
    int n = matrix.length;
    PriorityQueue<Tuple> queue = new PriorityQueue<>(matrix.length);
    for (int j = 0; j < n; j++) {
      queue.offer(new Tuple(0, j, matrix[0][j]));
    }
    // Tuple tuple = new Tuple(0, 0, 1);
    // System.out.format("Tuple: %s\n", queue);
    for (int i = 0; i < k - 1; i++) {
      Tuple tmp = queue.poll();
      if (tmp.x == n - 1) {
        continue;
      }
      queue.offer(new Tuple(tmp.x + 1, tmp.y, matrix[tmp.x + 1][tmp.y]));
    }
    return queue.poll().val;
    // PriorityQueue<
  }

  private class Tuple implements Comparable<Tuple> {
    int x;
    int y;
    int val;

    public Tuple(int x, int y, int val) {
      this.x = x;
      this.y = y;
      this.val = val;
    }

    @Override
    public int compareTo(Tuple that) {
      return this.val - that.val;
    }

    @Override
    public String toString() {
      return "x:" + x + " y:" + y + " val:" + val + "\n";
    }
  }
  //// -------------- end (Approach4)-------------------------------
}
// @lc code=end
