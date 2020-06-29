import java.util.Arrays;

public class L1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int len = stones.length;
        if(len == 1) return stones[0];
        Arrays.sort(stones);
        while(stones[len-1] != 0 && stones[len-2] != 0){
            int s1 = stones[len-1];
            int s2 = stones[len-2];
            if(s1 == s2) stones[len-1] = stones[len-2] = 0;
            else{
                stones[len-2] = 0;
                stones[len-1] = Math.abs(s1-s2);
            }
            Arrays.sort(stones);
        }


        return stones[len-1];
    }
    
    //pq
//    public int lastStoneWeight(int[] stones) {
//        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
//        for(int i : stones) q.offer(i);
//        while(q.size() >= 2){
//            int s1 = q.poll();
//            int s2 = q.poll();
//            if(s1 != s2) q.offer(Math.abs(s1-s2));
//        }
//
//        return q.isEmpty() ? 0 : q.peek();
//    }


}
