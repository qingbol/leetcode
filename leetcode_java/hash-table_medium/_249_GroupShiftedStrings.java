/*
 * @lc app=leetcode id=249 lang=java
 *
 * [249] Group Shifted Strings
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200220)//////////////////////////////////////
  ////////////////// first round(20200220)//////////////////////////////////////
  //// -------------start(approach 1) -------------------------------------
  //20200220
  public List<List<String>> groupStrings1(String[] strings) {
    Map<String, List<String>> map = new HashMap<>();
    for (int i = 0; i < strings.length; i++) {
      char head = strings[i].charAt(0);
      // int diff = head - 'a';
      String newS = new String();
      for (int j = 0; j < strings[i].length(); j++) {
        char cur = strings[i].charAt(j);
        // char res = (char) ((cur - head + 'a' + 26) % 26);
        int dis = cur - head;
        newS += ((dis + 26) % 26) + "-";
        // newS += (dis < 0 ? dis + 26 : dis) + "-";
      }
      // System.out.format("newS: %s \n", newS);
      if (map.containsKey(newS)) {
        map.get(newS).add(strings[i]);
      } else {
        map.put(newS, new ArrayList<String>(Arrays.asList(strings[i])));
      }
    }
    // System.out.format("map:%s \n", map.values());

    return new ArrayList<>(map.values());
    // return new ArrayList<List<String>>(map.values());
  }

  //// ------------------- end (approach1)--------------------------------------
  //// -------------------start(approach2)--------------------------------------
  // by stream
  public List<List<String>> groupStrings2(String[] strings) {
    return Arrays.stream(strings).collect(Collectors.groupingBy(this::normalize)).values().stream()
        .collect(Collectors.toList());
  }

  private List<Integer> normalize(String s) {
    return s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26).collect(Collectors.toList());
  }

  //// ------------------- end (approach2)--------------------------------------
  //// -------------------start(approach3)--------------------------------------
  // by stream
  public List<List<String>> groupStrings(String[] strings) {
    return new ArrayList(Stream.of(strings)
        .collect(Collectors
            .groupingBy(s -> s.chars().mapToObj(c -> (c - s.charAt(0) + 26) % 26).collect(Collectors.toList())))
        .values());
  }
  //// ------------------- end (approach3)--------------------------------------
  ////////////////// second round(20201026)////////////////////////////////////
  ////////////////// second round(20201026)////////////////////////////////////
  //// -------------------start(approach4)--------------------------------------
  //20201026.
  //// ------------------- end (approach4)--------------------------------------
}
// @lc code=end
