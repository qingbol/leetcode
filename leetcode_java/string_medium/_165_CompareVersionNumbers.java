/*
 * @lc app=leetcode id=165 lang=java
 *
 * [165] Compare Version Numbers
 */

// @lc code=start
class Solution {
  /////////////////////////// first round(20200213)///////////////////////
  /////////////////////////// first round(20200213)///////////////////////
  //// ----------------start(Approach1)----------------------------------
  // 20200213
  public int compareVersion1(String version1, String version2) {
    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");
    // System.out.println("ver1: " + Arrays.toString(ver1));
    // System.out.println("ver2: " + Arrays.toString(ver2));

    if (ver1.length > ver2.length) {
      String[] ver = new String[ver1.length];
      Arrays.fill(ver, "0");
      System.arraycopy(ver2, 0, ver, 0, ver2.length);
      ver2 = ver;
    } else if (ver1.length < ver2.length) {
      String[] ver = new String[ver2.length];
      Arrays.fill(ver, "0");
      System.arraycopy(ver1, 0, ver, 0, ver1.length);
      ver1 = ver;
    }
    // System.out.println("ver1: " + Arrays.toString(ver1));
    // System.out.println("ver2: " + Arrays.toString(ver2));

    for (int i = 0; i < ver1.length; i++) {
      int a = Integer.parseInt(ver1[i]);
      int b = Integer.parseInt(ver2[i]);
      if (a < b) {
        return -1;
      } else if (a > b) {
        return 1;
      }
    }
    return 0;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // better
  public int compareVersion(String version1, String version2) {
    String[] ver1 = version1.split("\\.");
    String[] ver2 = version2.split("\\.");

    int len = Math.max(ver1.length, ver2.length);
    for (int i = 0; i < len; i++) {
      int a = i >= ver1.length ? 0 : Integer.parseInt(ver1[i]);
      int b = i >= ver2.length ? 0 : Integer.parseInt(ver2[i]);
      if (a < b) {
        return -1;
      } else if (a > b) {
        return 1;
      }
    }
    return 0;
  }
  //// ---------------- end (Appraoch2)----------------------------------
  /////////////////////////// second round(20201019)///////////////////////
  /////////////////////////// second round(20201019)///////////////////////
  //// ----------------start(Appraoch3)----------------------------------
  //20201019.
  //just like approach2.
  //// ---------------- end (Appraoch3)----------------------------------
}
// @lc code=end
