/*
 * @lc app=leetcode id=251 lang=java
 *
 * [251] Flatten 2D Vector
 */

// @lc code=start
////-------------------start(Approach1)-------------------------
//20200413. by myself.
//Your runtime beats 83.35 % of java submissions
class Vector2D1 {
  // public class Vector2D {
  int r, c;
  int[][] v;

  public Vector2D1(int[][] v) {
    // public Vector2D(int[][] v) {
    this.v = v;
    r = 0;
    c = 0;
    // for (int[] v1 : v) {
    // System.out.format("v1.len: %d\n", v1.length);
    // }
  }

  public int next() {
    // if (!hasNext()) {
    // return -1;
    // }
    // System.out.format("[r,c] = [%d,%d]\n", r, c);
    // System.out.format("v[r][c]:%d\n", v[r][c]);
    int ret = v[r][c];
    if (c < v[r].length - 1) {
      c++;
    } else if (c == v[r].length - 1) {
      c = 0;
      r++;
    }
    return ret;
  }

  public boolean hasNext() {
    // System.out.format("[r,c] = [%d,%d]\n", r, c);
    while (r < v.length && v[r].length == 0) {
      r++;
    }
    if (r < v.length && c < v[r].length) {
      return true;
    }
    return false;
  }
}

//// ------------------- end (Approach1)-------------------------
//// -------------------start(Approach2)-------------------------
// 20200413. //Approach 2: Two Pointers
// optimal.
// Your runtime beats 83.35 % of java submissions

// class Vector2D2 {
public class Vector2D {
  int r, c;
  int[][] v;

  // public Vector2D1(int[][] v) {
  public Vector2D(int[][] v) {
    this.v = v;
    r = 0;
    c = 0;
    // for (int[] v1 : v) {
    // System.out.format("v1.len: %d\n", v1.length);
    // }
  }

  public int next() {
    if (!hasNext()) {
      return -1;
      // throw new NoSuchElementException();
    }
    return v[r][c++];
  }

  public boolean hasNext() {
    // System.out.format("[r,c] = [%d,%d]\n", r, c);
    while (r < v.length && c == v[r].length) {
      r++;
      c = 0;
    }

    return r < v.length;
  }
}
//// ------------------- end (Approach1)-------------------------

/**
 * Your Vector2D object will be instantiated and called as such: Vector2D obj =
 * new Vector2D(v); int param_1 = obj.next(); boolean param_2 = obj.hasNext();
 */
// @lc code=end
