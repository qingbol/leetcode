class Solution {
  ////////////////// first round(20200804)///////////////////////////////////
  ////////////////// first round(20200804)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
  // 20200804
  //refer to labuladong <拆解复杂问题：实现计算器>

  // Runtime: 14 ms, faster than 21.02% of Java online submissions for Basic Calculator III.
  // Memory Usage: 41.8 MB, less than 5.09% of Java online submissions for Basic Calculator III.

  // // public int calculate1(String s) {
  public int calculate(String s) {
    Deque<Character> str = new ArrayDeque<>();
    // str = Arrays.asList(s.toCharArray());
    for (char c : s.toCharArray()) {
      str.add(c);
    }
    // System.out.format("str: %s\n", str);
    return helper1(str);
  }

  private int helper1(Deque<Character> str) {
    Deque<Integer> stack = new ArrayDeque<>();
    char operator = '+';
    int operand = 0;
    while (str.size() > 0) {
      Character ch = str.removeFirst();
      if (Character.isDigit(ch)) {
        operand = operand * 10 + (ch - '0');
      }

      if (ch.equals('(')) {
        operand = helper1(str);
      }

      if (!Character.isDigit(ch) && ch != ' ' || str.size() == 0) {
        switch (operator) {
          case '+':
            stack.push(operand);
            break;
          case '-':
            stack.push(-operand);
            break;
          case '*':
            stack.push(operand * stack.pop());
            break;
          case '/':
            stack.push(stack.pop() / operand);
            break;
        }
        operator = ch;
        operand = 0;
      }

      if (ch.equals(')'))
        break;
    }

    // cal the sum of the stack
    int res = 0;
    while (!stack.isEmpty()) {
      res += stack.pop();
    }

    return res;
  }
  //// ---------------- end (Approach1)-------------------------------------
}
