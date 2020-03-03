import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
  //// -----------------start(Approach1)-----------------------------
  // use array
  public List<Integer> topKFrequent1(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      if (map.containsKey(nums[i])) {
        map.put(nums[i], map.get(nums[i]) + 1);
      } else {
        map.put(nums[i], 1);
      }
    }

    // bucket sort
    List<Integer>[] bucket = new List[nums.length + 1];
    for (int num : map.keySet()) {
      int freq = map.get(num);
      // System.out.println("freq: " + freq);
      if (null == bucket[freq]) {
        // System.out.println("freq1: " + freq);
        // System.out.println("freq1: " + bucket.toString());
        bucket[freq] = new ArrayList<>();
      }
      bucket[freq].add(num);
    }
    // System.out.println("freq1: " + Arrays.toString(bucket));

    List<Integer> res = new ArrayList<>();
    for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
      if (bucket[i] != null) {
        res.addAll(bucket[i]);
      }
    }

    return res;
    // return null;
  }

  //// ----------------- end (Approach1)-----------------------------
  //// -----------------start(Approach2)-----------------------------
  // use priorityQueue
  public List<Integer> topKFrequent(int[] nums, int k) {
    // use hashmap to count the frequency
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // sort by frequency
    PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      pq.offer(entry);
    }

    // collect the top k
    List<Integer> res = new ArrayList<>();
    while (!pq.isEmpty() && k-- > 0) {
      res.add(pq.poll().getKey());
    }
    return res;
  }

  //// ----------------- end (Approach2)-----------------------------
}
// @lc code=end
