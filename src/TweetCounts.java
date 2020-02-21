import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class TweetCounts {
    List<Integer> tt = new ArrayList();
    public TweetCounts() {

    }

    public void recordTweet(String tweetName, int time) {
        this.tt.add(time);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> list = new ArrayList();
        int interval;
        if(freq.equals("minute")) interval = 60;
        else if(freq.equals("hour")) interval = 3600;
        else interval = 3600*24;
        Collections.sort(tt);

        int period = endTime-startTime, curr=0, start=0, end=interval;
        while(period>=start){
            for(int i=0; i<tt.size(); i++){
                if (period==end && tt.get(i)==end) break;
                if(period>=tt.get(i)) curr++;
            }
            list.add(curr);
            period -= interval;
            curr=0;
        }

        return list;



    }

    public static void main(String[] args) {
        TweetCounts tweetCounts = new TweetCounts();
        tweetCounts.recordTweet("tweet3",0);
        tweetCounts.recordTweet("tweet3",60);
        tweetCounts.recordTweet("tweet3",10);
        System.out.println(tweetCounts.getTweetCountsPerFrequency("minute", "tweet3", 0, 60));
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */