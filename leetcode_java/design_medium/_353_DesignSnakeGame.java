/*
 * @lc app=leetcode id=353 lang=java
 *
 * [353] Design Snake Game
 */

// @lc code=start
////-------------------------start(Approach1)--------------------
//20200412. 
//Wrong Answer 534/539 cases passed (N/A)
//["SnakeGame","move","move","move","move","move","move","move","move","move","move","move","move","move","move","move"]
// ' +
// '[[3,3,[[2,0],[0,0],[0,2],[0,1],[2,2],[0,1]]],["D"],["D"],["R"],["U"],["U"],["L"],["D"],["R"],["R"],["U"],["L"],["L"],["D"],["R"],["U"]]

// public class SnakeGame {
class SnakeGame1 {
  private int[][] food;
  private static int width, height;
  private static int score;
  private static int pos;
  private static int[] head;
  private Map<String, Pair<Integer, Integer>> map;

  /**
   * Initialize your data structure here.
   * 
   * @param width  - screen width
   * @param height - screen height
   * @param food   - A list of food positions E.g food = [[1,1], [1,0]] means the
   *               first food is positioned at [1,1], the second is at [1,0].
   */
  // public SnakeGame(int width, int height, int[][] food) {
  public SnakeGame1(int width, int height, int[][] food) {
    this.food = food;
    this.width = width;
    this.height = height;
    score = 0;
    pos = 0;
    head = new int[] { 0, 0 };
    map = new HashMap<>();
    map.put("U", new Pair(0, -1));
    map.put("L", new Pair(-1, 0));
    map.put("R", new Pair(1, 0));
    map.put("D", new Pair(0, 1));
  }

  /**
   * Moves the snake.
   * 
   * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
   * @return The game's score after the move. Return -1 if game over. Game over
   *         when snake crosses the screen boundary or bites its body.
   */
  public int move(String direction) {
    // System.out.format("food:%s\n", Arrays.deepToString(food));
    // int[] newHead = new int[2];
    head[0] = head[0] + map.get(direction).getKey();
    head[1] = head[1] + map.get(direction).getValue();
    // System.out.format("head:%s\n", Arrays.toString(head));
    if (head[0] < 0 || head[0] >= width || head[1] < 0 || head[1] >= height) {
      return -1;
    } else if (pos < food.length && head[0] == food[pos][1] && head[1] == food[pos][0]) {
      pos++;
      score++;
    }
    return score;
  }
}

//// ------------------------- end (Approach1)--------------------
//// -------------------------start(Approach1)--------------------
// 20200412.
// Your runtime beats 31.72 % of java submissions
public class SnakeGame {
  // class SnakeGame2 {

  private int[][] food;
  private int width, height;
  private int score, pos;
  private Deque<Point> snake;
  private Set<Point> set;

  public SnakeGame(int width, int height, int[][] food) {
    // public SnakeGame2(int width, int height, int[][] food) {
    this.food = food;
    this.width = width;
    this.height = height;
    score = pos = 0;
    snake = new ArrayDeque<>();
    set = new HashSet<>();
    snake.offerFirst(new Point(0, 0));
    set.add(new Point(0, 0));
  }

  public int move(String direction) {
    // cal newHead
    Point currHead = snake.peek();
    Point newHead = new Point(currHead.x, currHead.y);
    switch (direction) {
      case "U":
        newHead.y--;
        break;
      case "D":
        newHead.y++;
        break;
      case "L":
        newHead.x--;
        break;
      case "R":
        newHead.x++;
        break;
    }

    // new head is legal to be in old tail's position, remove from set temporarily
    Point tail = snake.pollLast();
    set.remove(tail);

    // System.out.format("set:%s, newhead:%s\n", set, newHead);
    // System.out.format("snake:%s\n", snake);
    // case1: collision.
    if (newHead.x < 0 || newHead.x >= width || newHead.y < 0 || newHead.y >= height || set.contains(newHead)) {
      return -1;
    }

    snake.offerFirst(newHead);
    set.add(newHead);

    // case2: eat food
    if (pos < food.length && newHead.x == food[pos][1] && newHead.y == food[pos][0]) {
      score++;
      pos++;
      // snake.offerFirst(newHead);
      // set.add(newHead);
      snake.offerLast(tail);
      set.add(tail);
    }

    return score;
  }

  private class Point {
    int x, y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return String.format("%d->%d", x, y);
    }

    @Override
    public boolean equals(Object other) {
      if (!(other instanceof Point)) {
        return false;
      }
      if (this == other) {
        return true;
      }
      return x == ((Point) other).x && y == ((Point) other).y;
    }

    @Override
    public int hashCode() {
      return x * 31 + y;
    }
  }

}
//// ------------------------- end (Approach1)--------------------

/**
 * Your SnakeGame object will be instantiated and called as such: SnakeGame obj
 * = new SnakeGame(width, height, food); int param_1 = obj.move(direction);
 */
// @lc code=end
