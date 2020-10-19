/*
 * @lc app=leetcode id=394 lang=java
 *
 * [394] Decode String
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200211)///////////////////////////////////
  ////////////////// first round(20200211)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200211
  // logic error
  public String decodeString1(String s) {
    Deque<String> wordStack = new ArrayDeque<>();
    Deque<Integer> intStack = new ArrayDeque<>();
    int cur = 0;
    while (cur < s.length()) {
      Character ch = s.charAt(cur);
      // System.out.println("ch: " + ch);
      if (Character.isDigit(ch)) {
        int k = 0;
        while (Character.isDigit(ch)) {
          k = k * 10 + (ch - '0');
          cur++;
          ch = s.charAt(cur);
        }
        intStack.push(k);
      } else if (ch == '[') {
        // System.out.println("[: " + ch);
        cur++;
      } else if (ch == ']') {
        // to do
        System.out.println("]: " + ch);
        String tmp = "";
        if (!wordStack.isEmpty()) {
          tmp = wordStack.pop();
          System.out.println("tmp: " + tmp);
        }
        Integer cnt = 0;
        if (!intStack.isEmpty()) {
          cnt = intStack.pop();
          System.out.println("cnt: " + cnt);
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
          str.append(tmp);
        }
        if (!wordStack.isEmpty()) {
          // System.out.println("word: " + wordStack.peek());
          str.insert(0, wordStack.pop());
        }
        // System.out.println("str: " + str);
        wordStack.push(str.toString());
        cur++;
      } else {
        StringBuilder word = new StringBuilder();
        while (!Character.isDigit(ch) && ch != '[' && ch != ']') {
          word.append(ch);
          cur++;
          if (cur < s.length()) {
            ch = s.charAt(cur);
            // System.out.println("cur: " + ch);
          } else {
            break;
          }
        }
        wordStack.push(word.toString());
      }
    }
    StringBuilder res = new StringBuilder();
    // System.out.println("res: " + wordStack.peek());
    while (!wordStack.isEmpty()) {
      // System.out.println("res: " + wordStack.peek());
      res.insert(0, wordStack.pop());
    }
    return res.toString();
  }

  //// --------------- end (Approach1)------------------------------
  //// ---------------start(Approach2)------------------------------
  // right, but with a extra strStack.
  public String decodeString2(String s) {
    if (null == s || 0 == s.length()) {
      return s;
    }
    Deque<String> strStack = new ArrayDeque<>();
    Deque<Integer> numStack = new ArrayDeque<>();

    int idx = 0;
    Character ch = s.charAt(idx);
    StringBuilder curStr = new StringBuilder();
    // strStack.push(curStr.toString());
    while (idx < s.length()) {
      ch = s.charAt(idx);
      if (Character.isDigit(ch)) {
        int cnt = 0;
        while (Character.isDigit(ch)) {
          cnt = cnt * 10 + ch - '0';
          idx++;
          ch = s.charAt(idx);
        }
        numStack.push(cnt);
      } else if (ch == '[') {
        System.out.println("curStr: " + curStr);
        strStack.push(curStr.toString());
        curStr.setLength(0);
        idx++;
      } else if (ch == ']') {
        int time = numStack.pop();
        StringBuilder tmpStr = new StringBuilder(strStack.pop());
        for (int i = 0; i < time; i++) {
          tmpStr.append(curStr);
        }
        curStr = tmpStr;
        idx++;
      } else {
        curStr.append(ch);
        idx++;
      }
    }
    return curStr.toString();
  }

  //// --------------- end (Approach2)------------------------------
  //// ---------------start(Approach3)------------------------------
  // same with approach 2
  public String decodeString3(String s) {
    if (null == s || s.length() <= 1) {
      return s;
    }
    Deque<Integer> numStack = new ArrayDeque<>();
    Deque<String> strStack = new ArrayDeque<>();
    String curStr = "";
    int repeat = 0;
    for (char ch : s.toCharArray()) {
      if (Character.isDigit(ch)) {
        repeat = 10 * repeat + ch - '0';
      } else if (ch == '[') {
        numStack.push(repeat);
        repeat = 0;
        // to do
        strStack.push(curStr);
        curStr = "";
      } else if (ch == ']') {
        String tmp = new String(new char[numStack.pop()]).replace("\0", curStr);
        curStr = strStack.pop() + tmp;
      } else {
        curStr += ch;
      }
    }

    // collect
    while (!strStack.isEmpty()) {
      curStr = strStack.pop() + curStr;
    }
    return curStr;
  }

  //// --------------- end (Approach3)------------------------------
  //// ---------------start(Approach4)------------------------------
  // only use 1 stack

  // public String decodeString(String s) {
  public String decodeString4(String s) {
    Deque<Character> stack = new ArrayDeque<>();

    StringBuilder curStr = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c != ']') {
        stack.push(c);
      } else {
        curStr.setLength(0);
        while (!stack.isEmpty() && Character.isLetter(stack.peek())) {
          curStr.insert(0, stack.pop());
        }
        String sub = curStr.toString();

        stack.pop();

        curStr.setLength(0);
        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
          curStr.insert(0, stack.pop());
        }
        int repeat = Integer.parseInt(curStr.toString());

        // generate the new string
        String repeated = new String(new char[repeat]).replace("\0", sub);
        for (char ch : repeated.toCharArray()) {
          stack.push(ch);
        }
      }
    }
    // collect
    curStr.setLength(0);
    while (!stack.isEmpty()) {
      curStr.insert(0, stack.pop());
    }
    return curStr.toString();
  }
  //// ---------------- end (Approach4)-------------------------------------
  ////////////////// third round(20200920)///////////////////////////////////
  ////////////////// third round(20200920)///////////////////////////////////
  //// ----------------start(Approach5)-------------------------------------
  // 20200920. optimal solution. 
  // refer to leetcode discuss: Python solution using stack.
  //// https://leetcode.com/problems/decode-string/discuss/87662/Python-solution-using-stack

  // 29/29 cases passed (0 ms)
  // Your runtime beats 100 % of java submissions
  // Your memory usage beats 91.5 % of java submissions (37.2 MB)

  public String decodeString(String s) {
    // public String decodeString5(String s) {
    Deque<String> stack = new ArrayDeque<>();
    // Deque<StringBuilder> stack = new ArrayDeque<>();
    StringBuilder curStr = new StringBuilder();
    StringBuilder curNum = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (c == '[') {
        stack.push(curStr.toString());
        stack.push(curNum.toString());
        curStr.setLength(0);
        curNum.setLength(0);
      } else if (c == ']') {
        String preNum = stack.pop();
        // System.out.format("preNum: %s\n", preNum);
        String preStr = stack.pop();
        int num = Integer.parseInt(preNum);
        String tmp = curStr.toString();
        while (num > 1) {
          curStr.append(tmp);
          num--;
        }
        curStr.insert(0, preStr);
      } else if (Character.isDigit(c)) {
        curNum.append(c);
      } else {
        curStr.append(c);
      }
    }
    return curStr.toString();
  }
  //// ---------------- end (Approach5)-------------------------------------
}

// @lc code=end
