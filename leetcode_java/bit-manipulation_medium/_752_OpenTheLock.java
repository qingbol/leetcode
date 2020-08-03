/*
 * @lc app=leetcode id=752 lang=java
 *
 * [752] Open the Lock
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200728)///////////////////////////////////
  ////////////////// first round(20200728)///////////////////////////////////
  //// ----------------start(Approach6)----------------------
  // 20200728
  // refer to labuladong <BFS算法套路框架>

  // 43/43 cases passed (92 ms)
  // Your runtime beats 73.25 % of java submissions
  // Your memory usage beats 63.14 % of java submissions (45.9 MB)

  public int openLock(String[] deadends, String target) {
    // public int openLock1(String[] deadends, String target) {
    if (target == "0000")
      return -1;
    Queue<String> q = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    for (String s : deadends) {
      visited.add(s);
    }

    String start = "0000";
    if (!visited.contains(start)) {
      q.offer(start);
      visited.add(start);
    }
    int step = 0;

    while (!q.isEmpty()) {
      int sz = q.size();
      // System.out.format("q:%s\n", q);
      for (int i = 0; i < sz; i++) {
        String cur = q.poll();
        if (cur.equals(target))
          return step;

        for (int j = 0; j < 4; j++) {
          String up = plusOne(cur, j);
          String dn = minusOne(cur, j);
          if (!visited.contains(up)) {
            q.offer(up);
            visited.add(up);
          }
          if (!visited.contains(dn)) {
            q.offer(dn);
            visited.add(dn);
          }
        }
      }
      step++;
    }
    return -1;
  }

  private String plusOne(String cur, int j) {
    char[] ch = cur.toCharArray();
    if (ch[j] == '9') {
      ch[j] = '0';
    } else {
      ch[j] += 1;
    }
    return new String(ch);
  }

  private String minusOne(String cur, int j) {
    char[] ch = cur.toCharArray();
    if (ch[j] == '0') {
      ch[j] = '9';
    } else {
      ch[j] -= 1;
    }
    return new String(ch);
  }
}
// @lc code=end
