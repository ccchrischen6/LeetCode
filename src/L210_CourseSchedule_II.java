import java.util.*;

public class L210_CourseSchedule_II {
    /**
     * BFS
     * time: O(max(n,v))
     * space: O(max(n,v))
     */

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] inDegree = new int[n];
        Map<Integer, List<Integer>> g = new HashMap();
        for(int[] pair : prerequisites){
            int pre = pair[1];
            int follow = pair[0];
            if(!g.containsKey(pre)) g.put(pre, new ArrayList());
            g.get(pre).add(follow);
            inDegree[follow]++;
        }
        int idx = 0;
        Queue<Integer> q = new LinkedList();
        int[] res = new int[n];
        for(int i=0; i<n; i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }

        }


        while(!q.isEmpty()){
            int c = q.poll();
            res[idx++] = c;
            if(g.containsKey(c)){
                List<Integer> nexts = g.get(c);
                for(int next : nexts){
                    inDegree[next]--;
                    if(inDegree[next] == 0)
                        q.offer(next);
                }
            }
        }

        return idx == n ? res : new int[]{};


    }


    /**
     * DFS
     * time: O(max(n,v))
     * space: O(max(n,v))
     */

//    Map<Integer,List<Integer>> g;
//    boolean[] finished;
//    boolean[] visited;
//    int[] res;
//    int idx;
//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        int n = numCourses;
//        g = new HashMap();
//        finished = new boolean[n];
//        visited = new boolean[n];
//        res = new int[n];
//        idx = n-1;
//
//        for(int[] pair : prerequisites){
//            int pre = pair[1];
//            int follow = pair[0];
//            if(!g.containsKey(pre)) g.put(pre, new ArrayList());
//            g.get(pre).add(follow);
//        }
//
//        for(int i=0; i<n; i++){
//            if(!dfs(i)) return new int[]{};
//        }
//
//        return res;
//    }
//
//    private boolean dfs(int i){
//        if(finished[i]) return true;
//        if(visited[i]) return false;
//        visited[i] = true;
//
//        if(g.containsKey(i)){
//            List<Integer> nexts = g.get(i);
//            for(int next : nexts){
//                if(!dfs(next)) return false;
//            }
//        }
//
//        finished[i] = true;
//        res[idx--] = i;
//        return true;
//    }

}
