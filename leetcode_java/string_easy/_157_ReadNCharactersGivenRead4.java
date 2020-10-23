/*
 * @lc app=leetcode id=157 lang=java
 *
 * [157] Read N Characters Given Read4
 */

// @lc code=start
/**
 * The read4 API is defined in the parent class Reader4. int read4(char[] buf);
 */
public class Solution extends Reader4 {
  /**
   * @param buf Destination buffer
   * @param n   Number of characters to read
   * @return The number of actual characters read
   */
  //////////////////////// first round(20200217)//////////////////////////
  //////////////////////// first round(20200217)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200217
  public int read(char[] buf, int n) {
    int idx = 0;
    // int cnt = 0;
    while (idx < n) {
      // System.out.format("idx: %d\n", idx);
      char[] charArray = new char[4];
      int cnt = read4(charArray);
      for (int i = 0; i < cnt && idx < n; i++) {
        buf[idx++] = charArray[i];
      }
      if (cnt < 4) {
        break;
      }
    }

    return idx;
  }
  //// ---------- end (Approach1)------------------------------------
  //////////////////////// second round(20201022)//////////////////////////
  //////////////////////// second round(20201022)//////////////////////////
  //// ----------start(Approach2)------------------------------------
  // 20201022. 
  //// ---------- end (Approach2)------------------------------------
}
// @lc code=end
