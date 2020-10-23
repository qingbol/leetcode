/*
 * @lc app=leetcode id=158 lang=java
 *
 * [158] Read N Characters Given Read4 II - Call multiple times
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
  private List<Character> stock = new ArrayList<>();

  public int read1(char[] buf, int n) {
    int p = 0;
    int q = 0;
    for (int i = 0; i < stock.size() && p < n; i++) {
      buf[p++] = stock.get(i).charValue();
      stock.remove(i--);
    }
    // System.out.format("buf: %s\n", Arrays.toString(buf));
    while (p < n) {
      char[] tmp = new char[4];
      int cnt = read4(tmp);
      // System.out.format("tmp: %s\n", Arrays.toString(tmp));
      for (int i = 0; i < cnt; i++) {
        // sum++;
        if (p < n) {
          buf[p++] = tmp[i];
        } else {
          // System.out.format("elem: %c\n", tmp[i]);
          stock.add(tmp[i]);
        }
      }
      // System.out.format("stock: %s\n", stock);
      // System.out.format("stock: %s\n", Arrays.toString(stock));
      if (cnt < 4) {
        break;
      }
    }
    return p;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // better solution
  private char[] pool = new char[4];
  private int ptr = 0;
  private int cnt = 0;

  public int read(char[] buf, int n) {
    int p = 0;
    while (p < n) {
      if (ptr == 0) {
        cnt = read4(pool);
      }
      if (cnt == 0) {
        break;
      }
      while (p < n && ptr < cnt) {
        buf[p++] = pool[ptr++];
      }
      if (ptr >= cnt) {
        ptr = 0;
      }
    }
    return p;
  }
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201022)//////////////////////////
  //////////////////////// second round(20201022)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201022. 
  //// ---------- end (Approach3)------------------------------------
}
// @lc code=end
