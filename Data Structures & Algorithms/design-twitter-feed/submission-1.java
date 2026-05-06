class Twitter {
    private static int timestamp = 0;
    private static class Tweet{
        int id;
        int time;
        Tweet next;
        public Tweet(int id, int time, Tweet next){
            this.id = id;
            this.time = time;
            this.next = next;
        }
    }

    HashMap<Integer, Tweet> tweets;
    HashMap<Integer, HashSet<Integer>> follows;


    public Twitter() {
        tweets = new HashMap<>();
        follows = new HashMap<>();
        
    }
    
    public void postTweet(int userId, int tweetId) {
        timestamp++;
        tweets.put(userId, new Tweet(tweetId, timestamp, tweets.get(userId)));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        HashSet<Integer> users = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        users.add(userId);
        users.addAll(follows.getOrDefault(userId, new HashSet<>()));
        for(int uid : users){
            Tweet t = tweets.get(uid);
            if(t != null){
                pq.offer(t);
            }
        }

        while(!pq.isEmpty() && res.size() < 10){
            Tweet t = pq.poll();
            res.add(t.id);
            if(t.next != null){
                pq.offer(t.next);
            }
        } 
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        follows.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(follows.containsKey(followerId)){
            follows.get(followerId).remove(followeeId);
        }
    }
}
