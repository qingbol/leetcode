/*
 * @lc app=leetcode id=244 lang=java
 *
 * [244] Shortest Word Distance II
 */

// @lc code=start
////////////////// first round(20200411)///////////////////////////////////
////////////////// first round(20200411)///////////////////////////////////
//// ---------------------------start(Approach1)-----------------------
// 20200411, hashmap + PriorityQueue
// Time Limit Exceeded 11/12 cases passed (N/A)
class WordDistance1 {
  // public class WordDistance {

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


class WordDistance2 {
  // public class WordDistance {
  Map<String, List<Integer>> map2;

  // public WordDistance(String[] words) {
  public WordDistance2(String[] words) {
    map2 = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      // for (String s: words) {
      map2.putIfAbsent(words[i], new ArrayList<>());
      map2.get(words[i]).add(i);
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> loc1 = map2.get(word1);
    List<Integer> loc2 = map2.get(word2);

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
////////////////// second round(20200908)///////////////////////////////////
////////////////// second round(20200908)///////////////////////////////////
//// ---------------------------start(Approach3)-----------------------
// 20200908

// 12/12 cases passed (24 ms)
// Your runtime beats 94.32 % of java submissions
// Your memory usage beats 77.99 % of java submissions (46.1 MB)


// class WordDistance3 {
public class WordDistance {

  Map<String, List<Integer>> map;

  public WordDistance(String[] words) {
    // public WordDistance3(String[] words) {
    map = new HashMap<>();
    for (int i = 0; i < words.length; i++) {
      map.putIfAbsent(words[i], new ArrayList<>());
      map.get(words[i]).add(i);
      // map.put(words[i], map.get(words[i]).add(i));
    }
  }

  public int shortest(String word1, String word2) {
    List<Integer> idx1 = map.get(word1);
    List<Integer> idx2 = map.get(word2);

    int i = 0, j = 0;
    int res = Integer.MAX_VALUE;
    while (i < idx1.size() && j < idx2.size()) {
      int pos1 = idx1.get(i);
      int pos2 = idx2.get(j);
      res = Math.min(res, Math.abs(pos1 - pos2));
      if (pos1 > pos2) {
        j++;
      } else {
        i++;
      }
    }
    return res;
  }
}
//// --------------------------- end (Approach3)-----------------------

/**
 * Your WordDistance object will be instantiated and called as such: WordDistance obj = new
 * WordDistance(words); int param_1 = obj.shortest(word1,word2);
 */
// @lc code=end
