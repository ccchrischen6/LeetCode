import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class L983_MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length - 1];
        int[] dp = new int[n + 1];
        Set<Integer> travel = new HashSet();
        for (int d : days) travel.add(d);

        for (int i = 1; i <= n; i++) {
            if (!travel.contains(i)) dp[i] = dp[i - 1];
            else {
                int one = dp[i - 1] + costs[0];
                int seven = dp[Math.max(i - 7, 0)] + costs[1];
                int thirty = dp[Math.max(i - 30, 0)] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
            }
        }
        return dp[n];
    }

//    public int mincostTickets(int[] days, int[] costs) {
//        LinkedList<Pair<Integer,Integer>> q7 = new LinkedList();
//        LinkedList<Pair<Integer,Integer>> q30 = new LinkedList();
//        int total = 0;
//
//        for(int i=0; i<days.length; i++){
//            int d = days[i];
//            while(!q7.isEmpty() && q7.peek().getKey()+7 <= d) q7.poll();
//            while(!q30.isEmpty() && q30.peek().getKey()+30 <= d) q30.poll();
//            q7.offer(new Pair(d, total+costs[1]));
//            q30.offer(new Pair(d, total+costs[2]));
//            total = Math.min(total+costs[0], Math.min(
//                    q7.peek().getValue(),
//                    q30.peek().getValue()));
//        }
//        return total;
//    }
}
