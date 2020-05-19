import java.util.*;

class Twitter {
    static int timeStamp = 0;
    Map<Integer, User> userMap = new HashMap();

    public class Tweet{
        public int id;
        public int timeStamp;
        public Tweet next;

        public Tweet(int id){
            this.id = id;
            this.timeStamp = ++Twitter.timeStamp;
        }
    }

    public class User{
        public int id;
        public Set<User> followSet;
        public Tweet tweetHead;

        public User(int id){
            this.id = id;
            followSet = new HashSet();
        }
    }

    /** Initialize your data structure here. */
    public Twitter() {

    }

    private void initUser(int userId){
        User u = new User(userId);
        u.followSet.add(u);
        userMap.put(userId, u);
    }


    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)){
            initUser(userId);
        }

        Tweet t = new Tweet(tweetId);
        User u = userMap.get(userId);
        t.next = u.tweetHead;
        u.tweetHead = t;

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((t1, t2) -> t2.timeStamp - t1.timeStamp);
        if(!userMap.containsKey(userId)) return new LinkedList<>();
        User u = userMap.get(userId);
        Set<User> followSet = u.followSet;

        //retrieve all the tweet
        for(User user : followSet){
            Tweet tweetHead = user.tweetHead;
            while(tweetHead != null){
                pq.add(tweetHead);
                tweetHead = tweetHead.next;
            }
        }

        List<Integer> res = new LinkedList<>();
        int n = 0;
        while(!pq.isEmpty() && n<10){
            res.add(pq.poll().id);
            n++;
        }
        return res;

    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)){
            initUser(followerId);

        }

        if(!userMap.containsKey(followeeId)){
            initUser(followeeId);
        }

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        follower.followSet.add(followee);


    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId) ||
            !userMap.containsKey(followeeId) ||
            followerId == followeeId) return;

        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        follower.followSet.remove(followee);

    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 1);
        twitter.getNewsFeed(1);
        twitter.follow(2,1);
        twitter.getNewsFeed(2);
        twitter.unfollow(2,1);
        twitter.getNewsFeed(2);

    }
}
/**
 *
 ["Twitter",    "postTweet",    "getNewsFeed",  "follow",   "getNewsFeed",  "unfollow", "getNewsFeed"]
 [[],           [1,1],          [1],            [2,1],       [2],           [2,1],      [2]]

 *
 */



/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */