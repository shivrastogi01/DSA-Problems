class TweetCounts {
      Map<String,List<Integer>>map;
    
    public TweetCounts() {
        map=new HashMap<>();       //initialize the object
    }
    
    
    public void recordTweet(String tweetName, int time) {
        if(!map.containsKey(tweetName)){
          map.put(tweetName,new ArrayList<>());
              map.get(tweetName).add(time);      // add all the time when particular tweet occur in list
        }
        else
            map.get(tweetName).add(time);
         
    }
    
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        
        List<Integer>list=map.get(tweetName);   // get the list which contain time of tweet
        int frequency = getFreq(freq);     // get the freq as min=60 ,hour=60*60 for chunks
        
        int size=(endTime-startTime)/frequency; // to know total chunks for that period(start-end)
        int[] chunks=new int[size+1];
        
        for(int l:list)
        {
            if(l>=startTime && l<=endTime)        // in a range 
                chunks[(l-startTime)/frequency]++;   // than increments that chunks index value
        }
        List<Integer>res=new ArrayList<>();
        for(int n:chunks)
            res.add(n);               // add ans to res
        
        
        return res;
    }
    
    // to convert freq to time(integer)
    public int getFreq(String freq)
    {
        
        if(freq.equals("minute"))
            return 60;
        else if(freq.equals("hour"))
            return 3600;
        else
            return 60*60*24;
       
        
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */