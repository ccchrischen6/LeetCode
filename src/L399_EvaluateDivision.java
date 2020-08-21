import java.util.*;

public class L399_EvaluateDivision {
    /**
     *
     * @param e
     * @param values
     * @param q
     * @return
     *
     * UNION FIND
     *
     */
    public double[] calcEquation(String[][] e, double[] values, String[][] q) {
        double[] res = new double[q.length];
        Map<String, String> root = new HashMap<>();
        Map<String, Double> dist = new HashMap<>();
        for (int i = 0; i < e.length; i++) {
            String r1 = find(root, dist, e[i][0]);
            String r2 = find(root, dist, e[i][1]);
            root.put(r1, r2);
            dist.put(r1, dist.get(e[i][1]) * values[i] / dist.get(e[i][0]));
        }
        for (int i = 0; i < q.length; i++) {
            if (!root.containsKey(q[i][0]) || !root.containsKey(q[i][1])) {
                res[i] = -1.0;
                continue;
            }
            String r1 = find(root, dist, q[i][0]);
            String r2 = find(root, dist, q[i][1]);
            if (!r1.equals(r2)) {
                res[i] = -1.0;
                continue;
            }
            res[i] = (double) dist.get(q[i][0]) / dist.get(q[i][1]);
        }
        return res;
    }

    private String find(Map<String, String> root, Map<String, Double> dist, String s) {
        if (!root.containsKey(s)) {
            root.put(s, s);
            dist.put(s, 1.0);
            return s;
        }
        if (root.get(s).equals(s)) return s;
        String lastP = root.get(s);
        String p = find(root, dist, lastP);
        root.put(s, p);
        dist.put(s, dist.get(s) * dist.get(lastP));
        return p;

    }

    /**
     * DFS
     * time: O(e + e*q)
     * space: O(e)
     */

    Map<String,Map<String,Double>> g;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        g = new HashMap();

        for(int i=0; i<n; i++){
            String up = equations.get(i).get(0);
            String down = equations.get(i).get(1);
            if(!g.containsKey(up)) g.put(up,new HashMap());
            g.get(up).put(down,values[i]);

            if(!g.containsKey(down)) g.put(down, new HashMap());
            g.get(down).put(up, 1.0/values[i]);
        }

        double[] res = new double[queries.size()];
        for(int j=0; j<queries.size(); j++){
            String A = queries.get(j).get(0);
            String B = queries.get(j).get(1);
            Set<String> visited = new HashSet();
            if(!g.containsKey(A) && !g.containsKey(B)) res[j] = -1.0;
            else res[j] = res[j] = dfs(A,B,visited);
        }

        return res;
    }

    private double dfs(String A, String B, Set<String> visited){
        if(A.equals(B)) return 1.0;
        if(!g.containsKey(A)) return -1.0;
        Map<String,Double> ma = g.get(A);
        visited.add(A);
        for(String C : ma.keySet()){
            if(visited.contains(C)) continue;
            double b = dfs(C,B,visited);
            if(b>0) return ma.get(C)*b;
        }
        return -1.0;
    }
}
