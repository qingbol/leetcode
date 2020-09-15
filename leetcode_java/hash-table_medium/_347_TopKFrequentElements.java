import java.util.Map;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200109)///////////////////////////////////
  ////////////////// first round(20200109)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200109
  // use array

  public List<Integer> topKFrequent1(int[] nums, int k) {
    // public List<Integer> topKFrequent(int[] nums, int k) {
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

  // public List<Integer> topKFrequent(int[] nums, int k) {
  public List<Integer> topKFrequent2(int[] nums, int k) {
    // use hashmap to count the frequency
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }

    // sort by frequency
    PriorityQueue<Map.Entry<Integer, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
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
  ////////////////// second round(20200908)///////////////////////////////////
  ////////////////// second round(20200908)///////////////////////////////////
  //// ----------------start(Approach3)-------------------------------------
  // 20200908
  // refer to leetcode standard solution. //Approach 1: Heap
  // I can't analysis the time complexity. can't come up with a correct approach by myself.

  // public List<Integer> topKFrequent3(int[] nums, int k) {
  // public List<Integer> topKFrequent(int[] nums, int k) {
  public int[] topKFrequent(int[] nums, int k) {
    int n = nums.length;
    //boundary case
    // if (k == n) return Arrays.stream(nums).boxed().collect(Collectors.toList());
    // if (k == n) return new ArrayList<Integer>(Arrays.asList(nums));
    // if (k == n) return Arrays.asList(nums);
    if (k == n) return nums;

    //1. count the frequency. by hashmap or counting sort.
    Map<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.putIfAbsent(num, 0);
      map.put(num, map.get(num) + 1);
    }

    //2.use pq to select out the k most frequent nums
    // PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
    for (int key : map.keySet()) {
      pq.offer(key);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    int[] res = new int[k];
    // List<Integer> res = new ArrayList<>();
    int i = 0;
    while (!pq.isEmpty()) {
      // res.add(pq.poll());
      res[i++] = pq.poll();
    }
    return res;
  }
  //// ----------------- end (Approach3)-----------------------------
}
// @lc code=end
