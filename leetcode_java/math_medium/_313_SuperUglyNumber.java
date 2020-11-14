import java.io.InvalidClassException;

/*
 * @lc app=leetcode id=313 lang=java
 *
 * [313] Super Ugly Number
 */

// @lc code=start
class Solution {
  ////////////////// first round(20200226)///////////////////////////////////
  ////////////////// first round(20200226)///////////////////////////////////
  //// ----------------start(Approach1)-------------------------------------
//20200226
//https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explained
  public int nthSuperUglyNumber1(int n, int[] primes) {
    // use ugly to store the ugly number
    int[] ugly = new int[n];
    // idx used to indicate the index of ugly array
    int[] idx = new int[primes.length];

    // initial state
    ugly[0] = 1;
    for (int i = 1; i < n; i++) {
      ugly[i] = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);
      }
      for (int j = 0; j < primes.length; j++) {
        if (primes[j] * ugly[idx[j]] <= ugly[i]) {
          idx[j]++;
        }
      }
      // System.out.format("ugly: %s\n", Arrays.toString(ugly));
    }

    return ugly[n - 1];
  }

  //// ---------------- end (Approach1)------------------------
  //// ----------------start(Approach2)------------------------
  public int nthSuperUglyNumber2(int n, int[] primes) {
    int[] ugly = new int[n];
    int[] idx = new int[primes.length];
    // use val to memorize the last multiplication
    int[] val = new int[primes.length];

    int next = 1;
    for (int i = 0; i < n; i++) {
      ugly[i] = next;
      next = Integer.MAX_VALUE;
      for (int j = 0; j < primes.length; j++) {
        if (val[j] == ugly[i]) {
          val[j] = ugly[idx[j]++] * primes[j];
        }
        next = Math.min(next, val[j]);
      }
    }
    return ugly[n - 1];
  }

  //// ---------------- end (Approach2)------------------------
  //// ----------------start(Approach3)------------------------
  public int nthSuperUglyNumber(int n, int[] primes) {
    int[] ugly = new int[n];
    ugly[0] = 1;
    // create pq, and initialize it
    PriorityQueue<Tuple> pq = new PriorityQueue<>();
    for (int i = 0; i < primes.length; i++) {
      pq.offer(new Tuple(primes[i], 1, primes[i]));
    }

    for (int i = 1; i < n; i++) {
      ugly[i] = pq.peek().val;
      // System.out.format("pq:%s\n", pq);
      while (ugly[i] == pq.peek().val) {
        Tuple tmp = pq.poll();
        // System.out.format("prime:%d, ugly[idx]:%d\n", tmp.prime, ugly[tmp.idx]);
        pq.offer(new Tuple(tmp.prime * ugly[tmp.idx], tmp.idx + 1, tmp.prime));
      }
    }
    return ugly[n - 1];
  }

  private class Tuple implements Comparable<Tuple> {
    private int val;
    private int idx;
    private int prime;

    public Tuple(int val, int idx, int prime) {
      this.val = val;
      this.idx = idx;
      this.prime = prime;
    }

    @Override
    public int compareTo(Tuple that) {
      return this.val - that.val;
    }

    @Override
    public String toString() {
      return "val: " + val;
    }
  }
  //// ---------------- end (Approach3)------------------------
  ////////////////// second round(20201113)///////////////////////////////////
  ////////////////// second round(20201113)///////////////////////////////////
//// -------------start(approach3)------------------------------
// 20201113
//refer to leetcode discussion:  https://leetcode.com/problems/super-ugly-number/discuss/76291/Java-three-methods-23ms-36-ms-58ms(with-heap)-performance-explaine
//Java three methods, 23ms, 36 ms, 58ms(with heap), performance explained
  //// ---------------- end (Approach3)------------------------
}
// @lc code=end
