class Twitter {
    Map<Integer, Set<Integer>> followers = new HashMap();
    List<Node> tweets = new ArrayList();
    int timestamp = 0;
    public Twitter() {
    }

    public void postTweet(int userId, int tweetId) {
        Node n = new Node();
        n.id = tweetId;
        n.userId=userId;
        n.timestamp = ++timestamp;
        tweets.add(n);
    }

    public List<Integer> getNewsFeed(int userId) {
        LinkedList<Integer> res = new LinkedList();
        Set<Integer> set=followers.getOrDefault(userId, new HashSet<Integer>());
        set.add(userId);
        for (int i = tweets.size() - 1; res.size()<10 && i >= 0; i--) {
            Node n=tweets.get(i);
            if(set.contains(n.userId)){
                res.add(n.id);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        Set<Integer> set = followers.getOrDefault(followerId, new HashSet());
        set.add(followeeId);
        followers.put(followerId, set);
    }

    public void unfollow(int followerId, int followeeId) {
        followers.getOrDefault(followerId, new HashSet()).remove(followeeId);
    }
}

class Node {
    int userId;
    int id;
    int timestamp;
}
