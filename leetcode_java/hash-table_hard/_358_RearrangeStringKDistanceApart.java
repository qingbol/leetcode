/*
 * @lc app=leetcode id=358 lang=java
 *
 * [358] Rearrange String k Distance Apart
 */

// @lc code=start
class Solution {
  //// ----------------start(Approach1)--------------------------
  public String rearrangeString1(String s, int k) {
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
  public String rearrangeString(String s, int k) {
    Map<Character, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(
        (a, b) -> Integer.compare(b.getValue(), a.getValue()));
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
}
// @lc code=end
