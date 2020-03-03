/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
  //// -------------------start(Approach1)----------------------------
  // use an extra array to mark the used status
  public List<List<Integer>> permuteUnique1(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }
    Arrays.sort(nums);
    helper1(res, new ArrayList<>(), nums, new boolean[nums.length]);
    return res;
  }

  private void helper1(List<List<Integer>> res, List<Integer> lst, int[] nums, boolean[] used) {
    if (lst.size() == nums.length) {
      res.add(new ArrayList<>(lst));
    }

    for (int i = 0; i < nums.length; i++) {
      if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
        continue;
      }
      lst.add(nums[i]);
      used[i] = true;
      helper1(res, lst, nums, used);
      lst.remove(lst.size() - 1);
      used[i] = false;
    }
  }

  //// ------------------- end (Approach1)----------------------------
  //// -------------------start(Approach2)----------------------------
  // by swap
  // optimal
  public List<List<Integer>> permuteUnique2(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return res;
    }

    helper2(res, nums, 0);
    return res;
  }

  private void helper2(List<List<Integer>> res, int[] nums, int start) {
    if (start == nums.length) {
      List<Integer> lst = new ArrayList<>();
      for (int num : nums) {
        lst.add(num);
      }
      res.add(lst);
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (isSwapped(nums, start, i)) {
        continue;
      }
      swap(nums, start, i);
      helper2(res, nums, start + 1);
      swap(nums, start, i);
    }
  }

  private boolean isSwapped(int[] nums, int start, int i) {
    for (int l = start; l < i; l++) {
      if (nums[l] == nums[i]) {
        return true;
      }
    }
    return false;
  }

  private void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  //// ------------------- end (Approach2)----------------------------
  //// -------------------start(Approach3)----------------------------
  // By iteration + queue
  public List<List<Integer>> permuteUnique3(int[] nums) {
    if (nums.length == 0)
      return new ArrayList<>();
    Queue<List<Integer>> queue = new LinkedList<>();
    queue.add(Collections.singletonList(nums[0]));
    for (int i = 1; i < nums.length; i++) {
      int queueSize = queue.size();
      while (queueSize-- > 0) {
        List<Integer> record = queue.poll();
        for (int j = 0; j <= record.size(); j++) {
          boolean shouldBreak = j == record.size() || nums[i] == record.get(j);
          List<Integer> tmp = new ArrayList<>(record);
          tmp.add(j, nums[i]);
          queue.add(tmp);
          if (shouldBreak)
            break;
        }
      }
    }
    return new ArrayList<>(queue);
  }

  //// ------------------- end (Approach3)----------------------------
  //// -------------------start(Approach4)----------------------------
  // By iteration + set
  public List<List<Integer>> permuteUnique(int[] num) {
    LinkedList<List<Integer>> res = new LinkedList<>();
    res.add(new ArrayList<>());
    for (int i = 0; i < num.length; i++) {
      Set<String> cache = new HashSet<>();
      while (res.peekFirst().size() == i) {
        List<Integer> l = res.removeFirst();
        for (int j = 0; j <= l.size(); j++) {
          List<Integer> newL = new ArrayList<>(l.subList(0, j));
          newL.add(num[i]);
          newL.addAll(l.subList(j, l.size()));
          if (cache.add(newL.toString()))
            res.add(newL);
        }
      }
    }
    return res;
  }
  //// ------------------- end (Approach4)----------------------------
}
// @lc code=end
