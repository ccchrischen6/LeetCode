import java.util.*;

public class L207_CourseSchedule {
    /**
     * BFS
     * time: O(max(v, n))]
     * space: O(max(v, n))
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> path = new HashMap();
        int[] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList();

        for (int[] pair : prerequisites) {
            int pre = pair[1];
            int aim = pair[0];
            if (!path.containsKey(pre)) path.put(pre, new ArrayList());
            path.get(pre).add(aim);
            inDegree[aim]++;
        }

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0)
                q.offer(i);
        }

        while (!q.isEmpty()) {
            int c = q.poll();
            if (!path.containsKey(c)) continue;
            List<Integer> nexts = path.get(c);
            for (int j = 0; j < nexts.size(); j++) {
                inDegree[nexts.get(j)]--;
                if (inDegree[nexts.get(j)] == 0)
                    q.offer(nexts.get(j));
            }
        }

        for (int k : inDegree)
            if (k != 0) return false;

        return true;
    }


    /**
     * dfs
     * time: O(max(v, n))]
     * space: O(max(v, n))]
     */

//    Map<Integer,List<Integer>> path;
//    boolean[] finished;
//    boolean[] visited;
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        path = new HashMap();
//        finished = new boolean[numCourses];
//        visited = new boolean[numCourses];
//
//        for(int[] pair : prerequisites){
//            int pre = pair[1];
//            int next = pair[0];
//            if(!path.containsKey(pre)) path.put(pre, new ArrayList());
//            path.get(pre).add(next);
//        }
//
//        for(int i=0; i<numCourses; i++){
//            if(!dfs(i)) return false;
//        }
//
//        return true;
//
//    }
//
//    private boolean dfs(int i){
//        if(finished[i]) return true;
//        if(visited[i]) return false;
//        visited[i] = true;
//
//        if(path.containsKey(i)){
//            List<Integer> nexts = path.get(i);
//            for(int j=0; j<nexts.size(); j++){
//                if(!dfs(nexts.get(j))) return false;
//            }
//        }
//
//        finished[i] = true;
//        return true;
//    }
}
