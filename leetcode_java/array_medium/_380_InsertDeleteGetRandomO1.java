/*
 * @lc app=leetcode id=380 lang=java
 *
 * [380] Insert Delete GetRandom O(1)
 */

// @lc code=start
//// ------------------start(Approach1)-----------------------
// 20200127.
public class RandomizedSet {
  // class RandomizedSet1 {

  List<Integer> lst;
  Random rand;
  Map<Integer, Integer> map;

  /** Initialize your data structure here. */
  public RandomizedSet() {
    // public RandomizedSet1() {
    lst = new ArrayList<>();
    rand = new Random();
    map = new HashMap<>();
  }

  /**
   * Inserts a value to the set. Returns true if the set did not already contain
   * the specified element.
   */
  public boolean insert(int val) {
    if (!map.containsKey(val)) {
      map.put(val, lst.size());
      lst.add(val);
      return true;
    }
    return false;
  }

  /**
   * Removes a value from the set. Returns true if the set contained the specified
   * element.
   */
  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    }
    int idx = map.remove(val);
    int last = lst.remove(lst.size() - 1);
    if (val != last) {
      lst.set(idx, last);
      map.put(last, idx);
    }
    return true;
  }

  /** Get a random element from the set. */
  public int getRandom() {
    return lst.get(rand.nextInt(lst.size()));
  }
  //// ------------------ end (Approach1)-----------------------
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
// @lc code=end
