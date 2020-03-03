/*
 * @lc app=leetcode id=356 lang=java
 *
 * [356] Line Reflection
 */

// @lc code=start
class Solution {
  public boolean isReflected1(int[][] points) {
    Set<String> set = new HashSet<>();
    for (int i = 0; i < points.length; i++) {
      set.add(points[i][0] + "-" + points[i][1]);
    }
    System.out.format("set: %s\n", set);
    for (int i = 0; i < points.length; i++) {
      int neg = points[i][0] * -1;
      String tmp = neg + "-" + points[i][1];
      System.out.format("tmp: %s\n", tmp);
      if (!set.contains(neg + "-" + points[i][1])) {
        return false;
      }
    }
    return true;
  }

  public boolean isReflected(int[][] points) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    HashSet<String> set = new HashSet<>();
    for (int[] p : points) {
      max = Math.max(max, p[0]);
      min = Math.min(min, p[0]);
      String str = p[0] + "a" + p[1];
      set.add(str);
    }
    // System.out.format("set: %s\n", set);
    int sum = max + min;
    for (int[] p : points) {
      // int[] arr = {sum-p[0],p[1]};
      String str = (sum - p[0]) + "a" + p[1];
      // System.out.format("tmp: %s\n", str);
      if (!set.contains(str))
        return false;

    }
    return true;
  }
}
// @lc code=end
