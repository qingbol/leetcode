/*
 * @lc app=leetcode id=179 lang=java
 *
 * [179] Largest Number
 */

// @lc code=start
class Solution {
  //////////////////////// first round(20200217)//////////////////////////
  //////////////////////// first round(20200217)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200217
  // Comparator class
  public String largestNumber1(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, new myComparator());
    // System.out.format("strs: %s\n", Arrays.toString(strs));
    if (strs[0].charAt(0) == '0') {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s);
    }
    return sb.toString();
  }

  private class myComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      String ab = a + b;
      String ba = b + a;
      return ba.compareTo(ab);
    }
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // lambda
  public String largestNumber(int[] nums) {
    String[] strs = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      strs[i] = String.valueOf(nums[i]);
    }
    Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
    // System.out.format("strs: %s\n", Arrays.toString(strs));
    if (strs[0].charAt(0) == '0') {
      return "0";
    }
    StringBuilder sb = new StringBuilder();
    for (String s : strs) {
      sb.append(s);
    }
    return sb.toString();
  }
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201022)//////////////////////////
  //////////////////////// second round(20201022)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201022. 
  //// ---------- end (Approach3)------------------------------------
}
// @lc code=end
