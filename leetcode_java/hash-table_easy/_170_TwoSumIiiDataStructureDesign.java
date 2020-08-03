import java.util.Map;

/*
 * @lc app=leetcode id=170 lang=java
 *
 * [170] Two Sum III - Data structure design
 */

// @lc code=start
////////////////// first round(20200411)///////////////////////////////////
////////////////// first round(20200411)///////////////////////////////////
//// ---------------------start(Approach1)-------------------------
// 20200411, by myself. hashmap
// Your runtime beats 9.98 % of java submissions
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
//// ---------------------start(Approach2)-------------------------
// 20200411, by myself. hashmap
// with less map.put: Your runtime beats 71.31 % of java submissions
class TwoSum2 {
  // public class TwoSum {

  Map<Integer, Integer> map;

  // public TwoSum() {
  public TwoSum2() {
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
////////////////// second round(20200803)///////////////////////////////////
////////////////// second round(20200803)///////////////////////////////////
//// ---------------------start(Approach3)-------------------------
// 20200803, by myself.

// Time Limit Exceeded
// 14/16 cases passed (N/A)


class TwoSum3 {
  // public class TwoSum {
  List<Integer> nums;
  Set<Integer> sums;

  /** Initialize your data structure here. */
  // public TwoSum() {
  public TwoSum3() {
    nums = new ArrayList<>();
    sums = new HashSet<>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    for (int num : nums) {
      sums.add(num + number);
    }
    nums.add(number);
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    return sums.contains(value);
  }
}

//// --------------------- end (Approach3)-------------------------
//// ----------------------start(Approach4)-------------------------
// 20200803, by myself.

// 16/16 cases passed (103 ms)
// Your runtime beats 53.04 % of java submissions
// Your memory usage beats 8.82 % of java submissions (48 MB)

// class TwoSum4 {
public class TwoSum {
  Map<Integer, Integer> nums;

  /** Initialize your data structure here. */
  public TwoSum() {
    // public TwoSum4() {
    nums = new HashMap<>();
  }

  /** Add the number to an internal data structure.. */
  public void add(int number) {
    nums.putIfAbsent(number, 0);
    nums.put(number, nums.get(number) + 1);
  }

  /** Find if there exists any pair of numbers which sum is equal to the value. */
  public boolean find(int value) {
    for (Map.Entry<Integer, Integer> entry : nums.entrySet()) {
    // for (Map.Entry entry : nums.entrySet()) {
      int other = value - entry.getKey();
      if (nums.containsKey(other) && (other != entry.getKey() || entry.getValue() > 1)) {
        return true;
      }
    }
    return false;
  }
}

//// --------------------- end (Approach4)-------------------------

/**
 * Your TwoSum object will be instantiated and called as such: TwoSum obj = new TwoSum();
 * obj.add(number); boolean param_2 = obj.find(value);
 */
// @lc code=end
