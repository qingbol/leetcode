/*
 * @lc app=leetcode id=855 lang=java
 *
 * [855] Exam Room
 */

// @lc code=start
//////////////////////////first round(20200720)/////////////////////////
//////////////////////////first round(20200720)/////////////////////////
////-----------------------start(Approach1)----------------------------
//20200720.by myself. wrong
//this problem is too hard to come up a solution by myself. really hard

class ExamRoom1 {
  // public class ExamRoom {
  boolean[] seats;
  int occupied;

  // public ExamRoom(int N) {
  public ExamRoom1(int N) {
    seats = new boolean[N];
    occupied = 0;

  }

  public int seat() {
    if (occupied == 0) {
      occupied++;
      return 0;
    }

    int left = -1, right = -1;
    int maxDis = 0;
    int start = -1;

    for (int i = 0; i < seats.length; i++) {
      if (seats[i]) {
        if (left != -1 && right != -1) {
          if (right - left > 1 && right - left > maxDis) {
            start = left;
            maxDis = right - left;
            left = right = -1;
          } else if (left != -1 && right == -1) {
            right = i;
          } else if (left != -1) {
            left = i;
          }
        }
      }
    }
    seats[start + maxDis / 2] = true;
    occupied++;
    return start + maxDis / 2;
  }

  public void leave(int p) {
    seats[p] = false;
    occupied--;
  }
}
//// ----------------------- end (Approach1)----------------------------
//// -----------------------start(Approach2)----------------------------
// 20200721
// refer to labuladong <如何调度考生的座位>

// 128/128 cases passed (13 ms)
// Your runtime beats 82.82 % of java submissions
// Your memory usage beats 30.27 % of java submissions (40.1 MB)

class ExamRoom2 {
  // public class ExamRoom {
  TreeSet<int[]> lines;
  HashMap<Integer, int[]> startPoint;
  HashMap<Integer, int[]> endPoint;
  int N;

  // public ExamRoom(int N) {
  public ExamRoom2(int N) {
    this.N = N;
    lines = new TreeSet<>((a, b) -> {
      int distA = distance(a);
      int distB = distance(b);
      if (distA == distB) {
        return b[0] - a[0];
      }
      return distA - distB;
    });
    startPoint = new HashMap<>();
    endPoint = new HashMap<>();

    int[] dummy = new int[] { -1, N };
    addInterval(dummy);
  }

  public int seat() {
    int curSeat = -1;
    int[] longestIntv = lines.last();
    int x = longestIntv[0];
    int y = longestIntv[1];

    if (x == -1) {
      curSeat = 0;
    } else if (y == N) {
      curSeat = N - 1;
    } else {
      curSeat = x + (y - x) / 2;
    }

    removeInterval(longestIntv);
    addInterval(new int[] { x, curSeat });
    addInterval(new int[] { curSeat, y });
    return curSeat;
  }

  public void leave(int p) {
    int[] leftIntv = endPoint.get(p);
    int[] rightIntv = startPoint.get(p);
    int[] newIntv = new int[] { leftIntv[0], rightIntv[1] };

    removeInterval(leftIntv);
    removeInterval(rightIntv);
    addInterval(newIntv);
  }

  private void addInterval(int[] intv) {
    lines.add(intv);
    startPoint.put(intv[0], intv);
    endPoint.put(intv[1], intv);
  }

  private void removeInterval(int[] intv) {
    lines.remove(intv);
    startPoint.remove(intv[0]);
    endPoint.remove(intv[1]);
  }

  private int distance(int[] intv) {
    int x = intv[0];
    int y = intv[1];
    if (x == -1) {
      return y;
    } else if (y == N) {
      return N - x - 1;
    } else {
      return (y - x) / 2;
    }
  }
}
//// ----------------------- end (Approach2)----------------------------
//// -----------------------start(Approach3)----------------------------
// 20200721
// refer to leetcode standard solution

// 128/128 cases passed (28 ms)
// Your runtime beats 64.52 % of java submissions
// Your memory usage beats 20.31 % of java submissions (40.3 MB)

// class ExamRoom3 {
public class ExamRoom {
  TreeSet<Integer> occupiedSeat;
  int N;

  public ExamRoom(int N) {
    // public ExamRoom3(int N) {
    occupiedSeat = new TreeSet<>();
    this.N = N;
  }

  public int seat() {
    // System.out.println("occupied before:" + occupiedSeat);
    // base case
    if (occupiedSeat.size() == 0) {
      occupiedSeat.add(0);
      return 0;
    }

    // initial value of distance. suppose there's a dummy student -1.
    //the default newSeat should be 0, instead of -1.
    int dist = occupiedSeat.first();
    int newSeat = 0;
    // int newSeat = -1;
    Integer prev = null;
    for (Integer s : occupiedSeat) {
      if (prev == null) {
        prev = s;
        continue;
      }

      int d = (s - prev) / 2;
      if (d > dist) {
        dist = d;
        newSeat = prev + d;
        // System.out.format("d: %d, dist: %d, newSeat: %d\n", d, dist, newSeat);
      }
      prev = s;
    }

    // considering the rightmost seat
    if (N - 1 - occupiedSeat.last() > dist) {
      newSeat = N - 1;
    }

    occupiedSeat.add(newSeat);
    // System.out.println("occupied after:" + occupiedSeat);
    return newSeat;
  }

  public void leave(int p) {
    // System.out.println("occupied before leav:" + occupiedSeat);
    occupiedSeat.remove(p);
    // System.out.println("occupied after leave:" + occupiedSeat);
  }
}
//// ----------------------- end (Approach3)----------------------------
// /**
// * Your ExamRoom object will be instantiated and called as such:
// * ExamRoom obj = new ExamRoom(N);
// * int param_1 = obj.seat();
// * obj.leave(p);
// */
// @lc code=end
