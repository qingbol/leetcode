/*
 * @lc app=leetcode id=381 lang=java
 *
 * [381] Insert Delete GetRandom O(1) - Duplicates allowed
 */

// @lc code=start
////----------------------start(Approach1)-------------------------
//20200412, by myselft. hashmap<Integer, List<Integer>> + List
//Your runtime beats 98.53 % of java submissions
public class RandomizedCollection {
  // class RandomizedCollection1 {
  Map<Integer, List<Integer>> map;
  List<Integer> list;
  Random rand;

  /** Initialize your data structure here. */
  public RandomizedCollection() {
    // public RandomizedCollection1() {
    map = new HashMap<>();
    list = new ArrayList<>();
    rand = new Random();
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not
   * already contain the specified element.
   */
  public boolean insert(int val) {
    map.putIfAbsent(val, new ArrayList<>());
    map.get(val).add(list.size());
    list.add(val);
    // System.out.format("map:%s, list:%s\n", map, list);
    return map.get(val).size() == 1;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained
   * the specified element.
   */
  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    List<Integer> curIdx = map.get(val);
    // System.out.format("curIdx:%s\n", curIdx);
    int idx = curIdx.remove(curIdx.size() - 1);
    if (curIdx.isEmpty()) {
      map.remove(val);
    }
    // System.out.format("idx:%d\n", idx);

    int last = list.remove(list.size() - 1);
    // System.out.format("last:%d\n", last);
    if (last != val) {
      list.set(idx, last);
      // System.out.format("list:%s\n", list);
      // System.out.format("map:%s\n", map);
      map.get(last).remove(Integer.valueOf(list.size()));
      map.get(last).add(idx);
      // System.out.format("map:%s\n", map);
    }
    return true;
  }

  /** Get a random element from the collection. */
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}
//// ---------------------- end (Approach1)-------------------------

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection(); boolean param_1 =
 * obj.insert(val); boolean param_2 = obj.remove(val); int param_3 =
 * obj.getRandom();
 */
// @lc code=end
