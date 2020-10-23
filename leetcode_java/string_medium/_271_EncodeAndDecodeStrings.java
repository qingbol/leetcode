/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start
public class Codec {

  //////////////////////// first round(20200215)//////////////////////////
  //////////////////////// first round(20200215)//////////////////////////
  //// ----------start(Approach1)------------------------------------
  // 20200215
  // Encodes a list of strings to a single string.
  public String encode1(List<String> strs) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < strs.size(); i++) {
      sb.append(strs.get(i).length()).append("a").append(strs.get(i));
    }
    return sb.toString();
  }

  // Decodes a single string to a list of strings.
  public List<String> decode1(String s) {
    // System.out.format("s: %s\n", s);
    List<String> lst = new ArrayList<>();
    while (s.length() > 0) {
      int idx = s.indexOf("a");
      int len = Integer.parseInt(s.substring(0, idx));
      // System.out.format("len: %d\n", len);
      // System.out.format("s: %s\n", s.substring(idx + 1, idx + 1 + len));
      lst.add(s.substring(idx + 1, idx + 1 + len));
      s = s.substring(idx + 1 + len);
      // System.out.format("s: %s\n", s);
    }
    return lst;
  }

  //// ---------------- end (Appraoch1)----------------------------------
  //// ----------------start(Appraoch2)----------------------------------
  // Encodes a list of strings to a single string.
  public String encode(List<String> strs) {
    return strs.stream().map(s -> s.replace("#", "##") + " # ").collect(Collectors.joining());
  }

  // Decodes a single string to a list of strings.
  public List<String> decode(String s) {
    List strs = Stream.of(s.split(" # ", -1)).map(t -> t.replace("##", "#")).collect(Collectors.toList());
    strs.remove(strs.size() - 1);
    return strs;
  }
  //// ---------- end (Approach2)------------------------------------
  //////////////////////// second round(20201020)//////////////////////////
  //////////////////////// second round(20201020)//////////////////////////
  //// ----------start(Approach3)------------------------------------
  // 20201020. ant figure it out by myself.
  //// ---------- end (Approach3)------------------------------------
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
// @lc code=end
