import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L802_FindEventualSafeStates {

    /**
     * DFS
     * time: O(max(n,v))
     * space: O(max(n,v))
     */
    boolean[] finished;
    boolean[] visited;
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList();
        if(graph == null || graph.length == 0) return res;

        int n = graph.length;
        finished = new boolean[n];
        visited = new boolean[n];

        for(int i=0; i<n; i++)
            dfs(i, graph);

        for(int i=0; i<n; i++)
            if(finished[i])
                res.add(i);

        Collections.sort(res);
        return res;
    }

    private boolean dfs(int i, int[][] graph){
        if(finished[i]) return true;
        if(visited[i]) return false;
        visited[i] = true;

        boolean flag = false;
        for(int next : graph[i]){
            if(!dfs(next, graph)){
                return false;
            }
        }

        finished[i] = true;
        return true;
    }

    /**
     * BFS
     * time: O(max(n,v))
     * space: O(max(n,v))
     */

//    public List<Integer> eventualSafeNodes(int[][] graph) {
//        List<Integer> res = new ArrayList();
//        if(graph == null || graph.length == 0) return res;
//
//        int n = graph.length;
//        int[] outDegree = new int[n];
//        Map<Integer,List<Integer>> map = new HashMap();
//        for(int i=0; i<n; i++){
//            for(int j : graph[i]){
//                if(!map.containsKey(j)) map.put(j, new ArrayList());
//                map.get(j).add(i);
//                outDegree[i]++;
//            }
//        }
//
//        Queue<Integer> q = new LinkedList();
//        for(int k=0; k<n; k++)
//            if(outDegree[k] == 0)
//                q.offer(k);
//
//
//
//
//        while(!q.isEmpty()){
//            int cur = q.poll();
//            res.add(cur);
//            if(map.containsKey(cur)){
//                List<Integer> nexts = map.get(cur);
//                for(int next : nexts){
//                    outDegree[next]--;
//                    if(outDegree[next] == 0)
//                        q.offer(next);
//                }
//            }
//        }
//
//        Collections.sort(res);
//        return res;
//    }
}
