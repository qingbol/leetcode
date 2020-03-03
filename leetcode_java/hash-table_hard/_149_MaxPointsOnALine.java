/*
 * @lc app=leetcode id=149 lang=java
 *
 * [149] Max Points on a Line
 */

// @lc code=start
class Solution {
  public int maxPoints(int[][] points) {
    if (null == points) {
      return 0;
    }
    if (points.length < 3) {
      return points.length;
    }
    HashMap<String, Integer> map = new HashMap<>();
    int res = 0;

    for (int i = 0; i < points.length; i++) {
      int basex = points[i][0];
      int basey = points[i][1];
      int duplicate = 0;
      int localMax = 0;
      map.clear();
      for (int j = i + 1; j < points.length; j++) {
        if (basex == points[j][0] && basey == points[j][1]) {
          duplicate++;
        } else {
          int diffx = points[j][0] - basex;
          int diffy = points[j][1] - basey;
          int gcd = findGcd(diffx, diffy);
          String key = diffy / gcd + "/" + diffx / gcd;
          map.put(key, map.getOrDefault(key, 1) + 1);
          localMax = Math.max(localMax, map.get(key));
        }
      }
      // System.out.format("map: %s\n", map);
      // System.out.format("localMax: %d\n", localMax);
      localMax = localMax == 0 ? 1 : localMax;
      res = Math.max(res, localMax + duplicate);
    }
    return res;

  }

  private int findGcd(int a, int b) {
    if (b == 0) {
      return a;
    } else {
      return findGcd(b, a % b);
    }

  }
}
// @lc code=end
