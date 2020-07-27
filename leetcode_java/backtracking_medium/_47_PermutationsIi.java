import java.util.HashMap;

/*
 * @lc app=leetcode id=47 lang=java
 *
 * [47] Permutations II
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200227)///////////////////////
  //////////////////////// first round(20200227)///////////////////////
  //// -------------------start(Approach1)----------------------------
  // 20200227
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
  // can't understand it

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
  // cant understand it

  // public List<List<Integer>> permuteUnique(int[] num) {
  public List<List<Integer>> permuteUnique4(int[] num) {
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
  //////////////////////// second round(20200725)///////////////////////
  //////////////////////// second round(20200725)///////////////////////
  //// -------------------start(Approach5)----------------------------
  // 20200725, by myself. wrong.

  // public List<List<Integer>> permuteUnique(int[] nums) {
  public List<List<Integer>> permuteUnique5(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int num : nums) {
      map.put(num, map.getOrDefault(num, 0) + 1);
    }
    helper5(nums, new ArrayList<>(), res);
    return res;
  }

  private void helper5(int[] nums, List<Integer> track, List<List<Integer>> res) {
    if (track.size() == nums.length) {
      res.add(new ArrayList<>(track));
      return;
    }

    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (!set.add(nums[i])) {
        continue;
      }
      // ......
    }
  }
  //// ------------------- end (Approach5)----------------------------
  //// -------------------start(Approach6)----------------------------
  // 20200725, use an extra array

  // 30/30 cases passed (1 ms)
  // Your runtime beats 99.71 % of java submissions
  // Your memory usage beats 41.22 % of java submissions (40.2 MB)

  // public List<List<Integer>> permuteUnique(int[] nums) {
  public List<List<Integer>> permuteUnique6(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    boolean[] used = new boolean[nums.length];
    Arrays.sort(nums);

    helper6(nums, new ArrayList<>(), res, used);
    return res;
  }

  private void helper6(int[] nums, List<Integer> track, List<List<Integer>> res, boolean[] used) {
    if (track.size() == nums.length) {
      res.add(new ArrayList<>(track));
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      // like track.contains(nums[i])
      if (used[i])
        continue;
      // skip the duplicates
      if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
        continue;
      track.add(nums[i]);
      used[i] = true;
      helper6(nums, track, res, used);
      track.remove(track.size() - 1);
      used[i] = false;
    }
  }
  //// ------------------- end (Approach6)----------------------------
  //// -------------------start(Approach7)----------------------------
  // 20200725, by swap

  // 30/30 cases passed (5 ms)
  // Your runtime beats 34.64 % of java submissions
  // Your memory usage beats 12.5 % of java submissions (40.5 MB)

  public List<List<Integer>> permuteUnique(int[] nums) {
    // public List<List<Integer>> permuteUnique6(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();

    helper7(nums, 0, new ArrayList<>(), res);
    return res;
  }

  private void helper7(int[] nums, int start, List<Integer> track, List<List<Integer>> res) {
    if (start == nums.length) {
      List<Integer> lst = Arrays.stream(nums).boxed().collect(Collectors.toList());
      res.add(lst);
      return;
    }

    for (int i = start; i < nums.length; i++) {
      if (isSwapped7(nums, start, i))
        continue;
      swap7(nums, start, i);
      helper7(nums, start + 1, track, res);
      swap7(nums, start, i);
    }
  }

  private boolean isSwapped7(int[] nums, int start, int i) {
    for (int j = start; j < i; j++) {
      if (nums[j] == nums[i]) {
        return true;
      }
    }
    return false;
  }

  private void swap7(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }
  //// ------------------- end (Approach7)----------------------------

}
// @lc code=end
