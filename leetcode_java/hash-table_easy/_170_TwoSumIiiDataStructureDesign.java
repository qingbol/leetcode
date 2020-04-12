import java.util.Map;

/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 */

// @lc code=start
////---------------------start(Approach1)-------------------------
//20200411, by myself. hashmap
//Your runtime beats 9.98 % of java submissions
class TwoSum1 {
  // public class TwoSum {

  Map<Integer, Integer> map;

  /** Initialize your data structure here. */
  // public TwoSum() {
  public TwoSum1() {
    map = new HashMap<>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    map.putIfAbsent(number, 0);
    map.put(number, map.get(number) + 1);
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (Integer k : map.keySet()) {
      map.put(k, map.get(k) - 1);
      int complement = value - k;
      if (map.containsKey(complement) && map.get(complement) > 0) {
        map.put(k, map.get(k) + 1);
        return true;
      }
      map.put(k, map.get(k) + 1);
    }
    return false;
  }
}

//// --------------------- end (Approach1)-------------------------
//// ---------------------start(Approach1)-------------------------
// 20200411, by myself. hashmap
// with less map.put: Your runtime beats 71.31 % of java submissions
// class TwoSum2 {
public class TwoSum {

  Map<Integer, Integer> map;

  public TwoSum() {
    // public TwoSum2() {
    map = new HashMap<>();
  }

  public void add(int number) {
    map.putIfAbsent(number, 0);
    map.put(number, map.get(number) + 1);
  }

  public boolean find(int value) {
    for (Integer k : map.keySet()) {
      int complement = value - k;
      if (complement != k) {
        if (map.containsKey(complement)) {
          return true;
        }
      } else {
        if (map.containsKey(complement) && map.get(complement) > 1) {
          return true;
        }
      }
    }
    return false;
  }
}
//// --------------------- end (Approach2)-------------------------

/**
 * Your TwoSum object will be instantiated and called as such: TwoSum obj = new
 * TwoSum(); obj.add(number); boolean param_2 = obj.find(value);
 */
// @lc code=end
