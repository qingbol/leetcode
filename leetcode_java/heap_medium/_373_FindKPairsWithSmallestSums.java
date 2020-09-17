/*
 * @lc app=leetcode id=373 lang=java
 *
 * [373] Find K Pairs with Smallest Sums
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200225)///////////////////////////////////
  ////////////////// first round(20200225)///////////////////////////////////
  //// ----------------start(Approach1)------------------------------------
  // 20200225.
  public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
    if (null == nums1 || null == nums2 || 0 == nums1.length || 0 == nums2.length) {
      return new ArrayList<>();
    }
    int size = nums1.length * nums2.length;
    int[][] pairs = new int[size][2];
    for (int i = 0; i < nums1.length; i++) {
      for (int j = 0; j < nums2.length; j++) {
        pairs[i * nums2.length + j][0] = nums1[i];
        pairs[i * nums2.length + j][1] = nums2[j];
      }
    }
    Arrays.sort(pairs, (a, b) -> (a[0] + a[1]) - (b[0] + b[1]));
    // System.out.format("pairs: %s\n", Arrays.deepToString(pairs));

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < Math.min(k, size); i++) {
      // System.out.format("pairs: %s\n", Arrays.toString(pairs[i]));
      List<Integer> tmp = Arrays.asList(pairs[i][0], pairs[i][1]);
      res.add(tmp);
    }
    return res;
  }

  //// :------------------ end (Approach1)----------------------------------
  //// :------------------start(Approach2)----------------------------------
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0 || k == 0) {
      return res;
    }
    // Build initial priorityQueue
    PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> (a.get(0) + a.get(1) - b.get(0) - b.get(1)));
    for (int i = 0; i < k && i < nums1.length; i++) {
      List<Integer> tmp = new ArrayList<>(Arrays.asList(nums1[i], nums2[0], 0));
      // System.out.format("tmp: %s\n", tmp);
      pq.offer(tmp);
    }
    // System.out.format("pq: %s\n", pq);

    // poll the smallest pair and append another pair
    while (!pq.isEmpty() && k-- > 0) {
      List<Integer> tmp = pq.poll();
      res.add(Arrays.asList(tmp.get(0), tmp.get(1)));
      if (tmp.get(2) == nums2.length - 1) {
        continue;
      }
      pq.offer(new ArrayList<>(Arrays.asList(tmp.get(0), nums2[tmp.get(2) + 1], tmp.get(2) + 1)));

    }
    return res;
  }
  //// :------------------ end (Approach2)----------------------------------
  ////////////////// second round(20200916)///////////////////////////////////
  ////////////////// second round(20200916)///////////////////////////////////
  //// :------------------start(Approach3)----------------------------------
  //20200916.
  //just like approach2.
  //// :------------------ end (Approach3)----------------------------------
}
// @lc code=end
