/*
 * @lc app=leetcode id=355 lang=java
 *
 * [355] Design Twitter
 */

// @lc code=start
////////////////// first round(20200410)///////////////////////////////////
////////////////// first round(20200410)///////////////////////////////////
//// ------------------------start(Approach1)-----------------------
// 20200410, by myself. map + hashset + pq. Not ood based.
// Your runtime beats 48.58 % of java submissions
class Twitter1 {
  // public class Twitter {
  int seq;
  Map<Integer, Set<Integer>> follower;
  Map<Integer, PriorityQueue<Pair<Integer, Integer>>> ownPost;
  // Map<Integer, PriorityQueue<Pair<Integer, Integer>>> allPost;

  /** Initialize your data structure here. */
  public Twitter1() {
    // public Twitter() {
    seq = 0;
    follower = new HashMap<>();
    ownPost = new HashMap<>();
    // allPost = new HashMap<>();
    // System.out.format("check point 1\n");
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    // System.out.format("check point 2\n");
    ownPost.putIfAbsent(userId, new PriorityQueue<>((a, b) -> a.getKey() - b.getKey()));
    // allPost.putIfAbsent(userId, new PriorityQueue<>((a, b) -> a.getKey() -
    // b.getKey()));
    // System.out.format("check point 3\n");
    ownPost.get(userId).add(new Pair(seq, tweetId));
    // System.out.format("check point 4\n");
    // allPost.get(userId).add(new Pair(seq, tweetId));
    // System.out.format("check point 5\n");
    seq++;

    follower.putIfAbsent(userId, new HashSet<>());
    follower.get(userId).add(userId);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();
    // System.out.format("ownPost:%s\n", ownPost.get(userId));
    PriorityQueue<Pair<Integer, Integer>> pq =
        new PriorityQueue<>((a, b) -> b.getKey() - a.getKey());

    // System.out.format("follower:%s\n", follower.get(userId));
    // if (ownPost.containsKey(userId)) {
    // pq.addAll(ownPost.get(userId));
    // }
    if (follower.containsKey(userId)) {
      for (Integer other : follower.get(userId)) {
        if (ownPost.containsKey(other)) {
          pq.addAll(ownPost.get(other));
        }
      }
    }

    // System.out.format("pq:%s\n", pq);
    while (res.size() < 10 && !pq.isEmpty()) {
      res.add(pq.poll().getValue());
      // res.addFirst(pq.poll().getValue());
    }
    // System.out.format("res:%s\n", res);
    return res;
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    // System.out.format("check point 6\n");
    follower.putIfAbsent(followerId, new HashSet<>());
    // System.out.format("check point 7\n");
    follower.get(followerId).add(followeeId);
    // System.out.format("check point 8\n");
    // allPost.get(followeeId).addAll(ownPost.get(followerId));
    // System.out.format("check point 9\n");
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    // System.out.format("check point 10\n");
    // System.out.format("followeId: %d, followeeId:%d\n", followerId, followeeId);
    if (followerId != followeeId && follower.containsKey(followerId)) {
      follower.get(followerId).remove(Integer.valueOf(followeeId));
    }
    // System.out.format("check point 11\n");
    // allPost.get(followeeId).removeAll(ownPost.get(followerId));
  }
}

//// ------------------------ end (Approach1)-----------------------
//// ------------------------start(Approach2)-----------------------
// 20200410, OOD based
// refer to
//// https://leetcode.com/problems/design-twitter/discuss/82825/Java-OO-Design-with-most-efficient-function-getNewsFeed
// timeStamp is not static : Your runtime beats 90.37 % of java submissions
// timeStamp is static: Your runtime beats 96.42 % of java submissions


// class Twitter2 {
// public class Twitter {
class Twitter2 {

  private Map<Integer, User> userMap;
  private static int timeStamp = 0;

  /** Initialize your data structure here. */
  // public Twitter2() {
  public Twitter2() {
    // public Twitter() {
    userMap = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    userMap.putIfAbsent(userId, new User(userId));
    userMap.get(userId).post(tweetId);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>();
    if (!userMap.containsKey(userId)) {
      return res;
    }
    Set<Integer> followedLst = userMap.get(userId).followedList;
    // System.out.format("followedLst: %s\n", followedLst);
    PriorityQueue<Tweet> pq = new PriorityQueue<>(followedLst.size(), (a, b) -> b.time - a.time);

    for (Integer followed : followedLst) {
      if (userMap.get(followed).tweetHead != null) {
        pq.add(userMap.get(followed).tweetHead);
      }
    }

    int n = 0;
    while (n < 10 && !pq.isEmpty()) {
      Tweet currTweet = pq.poll();
      res.add(currTweet.tweetId);
      n++;
      if (currTweet.next != null) {
        pq.add(currTweet.next);
      }
    }
    return res;
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    userMap.putIfAbsent(followerId, new User(followerId));
    userMap.putIfAbsent(followeeId, new User(followeeId));
    userMap.get(followerId).fo(followeeId);
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    if (!userMap.containsKey(followerId) || followerId == followeeId) {
      return;
    }
    userMap.get(followerId).unfo(followeeId);
  }

  private class User {
    public int userId;
    public Set<Integer> followedList;
    public Tweet tweetHead;

    public User(int userId) {
      this.userId = userId;
      followedList = new HashSet<>();
      fo(userId);
      tweetHead = null;
    }

    public void post(int tweetId) {
      Tweet newPost = new Tweet(tweetId);
      newPost.next = tweetHead;
      tweetHead = newPost;
    }

    public void fo(int followeeId) {
      followedList.add(followeeId);
    }

    public void unfo(int followeeId) {
      followedList.remove(Integer.valueOf(followeeId));
    }
  }

  private class Tweet {
    public int tweetId;
    public int time;
    public Tweet next;

    public Tweet(int tweetId) {
      this.tweetId = tweetId;
      time = timeStamp++;
      next = null;
    }
  }
}


//// ------------------------ end (Approach2)-----------------------
////////////////// second round(20200730)///////////////////////////////////
////////////////// second round(20200730)///////////////////////////////////
//// ------------------------start(Approach3)-----------------------
// 20200730 by myself.
//problem: should use LinkedList to store tweet(blog).

// 23/23 cases passed (33 ms)
// Your runtime beats 59.41 % of java submissions
// Your memory usage beats 19.05 % of java submissions (45.2 MB)

// class Twitter3 {
public class Twitter {
  // public class Twitter {

  static int timestamp = 0;
  Map<Integer, User> users;

  /** Initialize your data structure here. */
  public Twitter() {
    // public Twitter3() {
    users = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(int userId, int tweetId) {
    if (!users.containsKey(userId)) {
      users.put(userId, new User(userId));
    }
    Blog newBlog = new Blog(tweetId, timestamp++);
    users.get(userId).blogs.add(newBlog);
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(int userId) {
    List<Integer> res = new ArrayList<>(10);
    PriorityQueue<Blog> pq = new PriorityQueue<>((a, b) -> b.timestamp - a.timestamp);

    // check the existence of userId
    if (!users.containsKey(userId)) {
      return res;
    }

    // pq.addAll(users.get(userId).blogs);
    // System.out.format("pq: %s\n", pq);
    for (User followee : users.get(userId).followees) {
      pq.addAll(followee.blogs);
    }

    while (!pq.isEmpty() && res.size() < 10) {
      // for (int i = 0; i < 10; i++) {
      res.add(pq.poll().blogId);
    }
    return res;
  }

  /**
   * Follower follows a followee. If the operation is invalid, it should be a no-op.
   */
  public void follow(int followerId, int followeeId) {
    if (!users.containsKey(followerId))
      users.put(followerId, new User(followerId));
    if (!users.containsKey(followeeId))
      users.put(followeeId, new User(followeeId));
    users.get(followerId).followees.add(users.get(followeeId));
  }

  /**
   * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
   */
  public void unfollow(int followerId, int followeeId) {
    if (followerId != followeeId && users.containsKey(followerId)
        && users.containsKey(followeeId)) {
      users.get(followerId).followees.remove(users.get(followeeId));
    }
  }

  private class User {
    int userId;
    Set<User> followees;
    // List<User> followees;
    List<Blog> blogs;

    public User(int userId) {
      this.userId = userId;
      followees = new HashSet<>();
      // followees = new ArrayList<>();
      blogs = new ArrayList<>();
      followees.add(this);
    }
  }

  private class Blog {
    int blogId;
    int timestamp;

    public Blog(int blogId, int timestamp) {
      this.blogId = blogId;
      this.timestamp = timestamp;
    }

    public String toString() {
      return String.valueOf(blogId);
    }
  }
}

//// ------------------------ end (Approach3)-----------------------

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
// @lc code=end
