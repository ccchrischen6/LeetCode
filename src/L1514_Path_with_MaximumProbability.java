import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class L1514_Path_with_MaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //store the dist from start to current node
        Map<Integer,Double> dist = new HashMap();
        //graph map
        //g<Node-a,<Node-b,p>>
        Map<Integer,Map<Integer,Double>> g = new HashMap();
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            double p = succProb[i];

            if(!g.containsKey(a)) g.put(a, new HashMap());
            Map<Integer,Double> ma = g.get(a);
            ma.put(b,p);
            g.put(a, ma);

            if(!g.containsKey(b)) g.put(b, new HashMap());
            Map<Integer,Double> mb = g.get(b);
            mb.put(a,p);
            g.put(b, mb);
        }
        double res = 0.0;
        if(!g.containsKey(start) || !g.containsKey(end)) return res;

        Queue<Integer> q = new LinkedList();
        q.offer(start);
        dist.put(start, 1.0);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next : g.get(cur).keySet()){
                //if we have not visited this node
                if(!dist.containsKey(next)) {
                    dist.put(next, dist.get(cur) * g.get(cur).get(next));
                    q.offer(next);
                }
                //if the current path the this node has higher p, we update the dist
                else if(dist.get(next) < dist.get(cur) * g.get(cur).get(next)){
                    dist.put(next,dist.get(cur) * g.get(cur).get(next));
                    q.offer(next);
                }
            }
        }
        return dist.getOrDefault(end,0.0);
    }
}
