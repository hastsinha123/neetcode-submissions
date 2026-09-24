class Twitter {

    static class Tweet implements Comparable<Tweet>{
        int tId;
        int time;

        public Tweet(int id, int t){
            this.tId = id;
            this.time = t;
        }

        public int compareTo(Tweet other){
            return other.time - this.time;
        }
    }

    static class User {
        int id;
        List<Tweet> tweets;
        HashSet<Integer> followers;

        public User(int id){
            this.id = id;
            tweets = new LinkedList<>();
            followers = new HashSet<>();
            followers.add(id);
        }

        public void addTweet(int tweetId, int time){
            tweets.add(0, new Tweet(tweetId, time));
        }

        public void addFollower(int id){
            followers.add(id);
        }

        public void removeFollower(int id){
            followers.remove(id);
        }
    }

    HashMap<Integer, User> map ;
    int timer;

    public Twitter() {
        map = new HashMap<>();
        timer = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        timer++;
        if(!map.containsKey(userId)){
            User user = new User(userId);
            user.addTweet(tweetId, timer);
            map.put(userId,user);
        } else {
            User user = map.get(userId);
            user.addTweet(tweetId, timer);
        }
        
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if(!map.isEmpty() && !map.containsKey(userId)){
            return null;
        }
        PriorityQueue<Tweet> pq = new PriorityQueue<>();

        User user = map.get(userId);
        for(Integer foll : user.followers){
            int count = 0;
            for(Tweet t : map.get(foll).tweets){
                pq.offer(t);
                count++;
                if(count == 10){
                    break;
                }
            }
        }



        List<Integer> list = new ArrayList<>();
        int i = 0;
        while(!pq.isEmpty() && i<10){
            Tweet t = pq.poll();
            list.add(t.tId);
            i++;
        }

        return list;

        
    }
    
    public void follow(int followerId, int followeeId) {
        
        if(!map.containsKey(followeeId)){
            User followee = new User(followeeId);
            map.put(followeeId, followee);
        }

        if(!map.containsKey(followerId)){
            User user = new User(followerId);
            map.put(followerId,user);
        }
        User follower = map.get(followerId);
        follower.addFollower(followeeId);
        
    }
    
    public void unfollow(int followerId, int followeeId) {  
         if(!map.containsKey(followerId)){
           return;
        }
        User user = map.get(followerId);
        user.removeFollower(followeeId);

        
    }
}
