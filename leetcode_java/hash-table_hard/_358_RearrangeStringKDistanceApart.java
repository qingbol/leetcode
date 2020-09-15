/*
 * @lc app=leetcode id=358 lang=java
 *
 * [358] Rearrange String k Distance Apart
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200114)///////////////////////////////////
  ////////////////// first round(20200114)///////////////////////////////////
  //// ---------------------------start(Approach1)-----------------------
  // 20200114

  public String rearrangeString1(String s, int k) {
    // public String rearrangeString(String s, int k) {
    int[] count = new int[26];
    int[] valid = new int[26];
    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      int nextLetter = findNextLetter(count, valid, i);
      if (-1 == nextLetter) {
        return "";
      }
      res.append((char) (nextLetter + 'a'));
      count[nextLetter]--;
      valid[nextLetter] = i + k;
    }
    return res.toString();
  }

  public int findNextLetter(int[] count, int[] valid, int idx) {
    int maxCount = 0;
    int nextLetter = -1;
    for (int i = 0; i < count.length; i++) {
      if (count[i] > maxCount && valid[i] <= idx) {
        nextLetter = i;
        maxCount = count[i];
      }
    }
    return nextLetter;
  }

  //// ---------------- end (Approach1)--------------------------
  //// ----------------start(Approach2)--------------------------
  //
  // public String rearrangeString(String s, int k) {
  public String rearrangeString2(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
    Queue<Map.Entry<Character, Integer>> que = new LinkedList<>();
    StringBuilder res = new StringBuilder();

    for (char c : s.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    pq.addAll(map.entrySet());

    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> pair = pq.poll();
      res.append(pair.getKey());
      pair.setValue(pair.getValue() - 1);
      que.offer(pair);
      if (que.size() >= k) {
        pair = que.poll();
        if (pair.getValue() > 0) {
          pq.offer(pair);
        }
      }
    }
    return res.length() == s.length() ? res.toString() : "";
  }
  //// ---------------- end (Approach2)--------------------------
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ---------------------------start(Approach3)-----------------------
  // 20200908, can't come up with a soluton by myself
  // refer to Java 7 version of PriorityQueue O(nlogn) with comments and explanations
  // https://leetcode.com/problems/rearrange-string-k-distance-apart/discuss/83192/Java-7-version-of-PriorityQueue-O(nlogn)-with-comments-and-explanations

  // 57/57 cases passed (21 ms)
  // Your runtime beats 50.05 % of java submissions
  // Your memory usage beats 66.63 % of java submissions (40.3 MB)

  public String rearrangeString(String s, int k) {
    // public String rearrangeString3(String s, int k) {
    // 1. count the frequencey of each char
    Map<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      map.putIfAbsent(c, 0);
      map.put(c, map.get(c) + 1);
    }
    // 2. put entries in map to a pq
    PriorityQueue<Map.Entry<Character, Integer>> pq =
        new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
    pq.addAll(map.entrySet());
    // 3. build a queue to hold the rearranged elements
    Queue<Map.Entry<Character, Integer>> q = new ArrayDeque<>();
    // 4. try to rearrange, put the rearranged elments to q
    StringBuilder sb = new StringBuilder();
    while (!pq.isEmpty()) {
      Map.Entry<Character, Integer> cur = pq.poll();
      sb.append(cur.getKey());
      cur.setValue(cur.getValue() - 1);
      q.offer(cur);
      if (q.size() >= k) {
        cur = q.poll();
        if (cur.getValue() > 0)
          pq.offer(cur);
      }
    }

    return sb.length() == s.length() ? sb.toString() : "";
  }
  //// ---------------- end (Approach3)--------------------------
}
// @lc code=end
