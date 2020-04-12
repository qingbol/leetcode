/*
 * @lc app=leetcode id=244 lang=java
 *
 * [244] Shortest Word Distance II
 */

// @lc code=start
////---------------------------start(Approach1)-----------------------
//20200411, hashmap + PriorityQueue
//Time Limit Exceeded 11/12 cases passed (N/A)
class WordDistance1 {
  // public class WordDistance {
  Map<Pair<String, String>, PriorityQueue<Integer>> map;

  // public WordDistance(String[] words) {
  public WordDistance1(String[] words) {
    map = new HashMap<>();
    for (int i = 0; i < words.length - 1; i++) {
      for (int j = 1; j < words.length; j++) {
        Pair<String, String> pair1 = new Pair<>(words[i], words[j]);
        Pair<String, String> pair2 = new Pair<>(words[j], words[i]);
        map.putIfAbsent(pair1, new PriorityQueue<>());
        map.get(pair1).add(Math.abs(i - j));
        map.putIfAbsent(pair2, new PriorityQueue<>());
        map.get(pair2).add(Math.abs(i - j));
      }
    }
  }

  public int shortest(String word1, String word2) {
    Pair<String, String> pair = new Pair<>(word1, word2);
    return map.get(pair).peek();
  }
}

//// --------------------------- end (Approach1)-----------------------
//// ---------------------------start(Approach2)-----------------------
// 20200411, hashmap + two pointers
// Your runtime beats 84.01 % of java submissions

// class WordDistance2 {
public class WordDistance {
  Map<String, List<Integer>> map;

  public WordDistance(String[] words) {
    // public WordDistance2(String[] words) {
    map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      // for (String s: words) {
      map.putIfAbsent(words[i], new ArrayList<>());
      map.get(words[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> loc1 = map.get(word1);
    List<Integer> loc2 = map.get(word2);

    int l = 0, r = 0;
    int res = Integer.MAX_VALUE;
    while (l < loc1.size() && r < loc2.size()) {
      res = Math.min(res, Math.abs(loc1.get(l) - loc2.get(r)));
      if (loc1.get(l) < loc2.get(r)) {
        l++;
      } else {
        r++;
      }
    }
    return res;
  }
}
//// --------------------------- end (Approach2)-----------------------

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words); int param_1 =
 * obj.shortest(word1,word2);
 */
// @lc code=end
