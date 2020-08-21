/**
 * Created by Chris Chen
 */
public class L997_Find_theTownJudge {
    //two array version
//    public int findJudge(int N, int[][] trust) {
//        int[] inDegree = new int[N+1];
//        int[] outDegree = new int[N+1];
//        for(int[] pair : trust){
//            int a = pair[0];
//            int b = pair[1];
//
//            outDegree[a]++;
//            inDegree[b]++;
//        }
//
//        for(int i=1; i<=N; i++){
//            if(outDegree[i] == 0 && inDegree[i] == N-1)
//                return i;
//        }
//
//        return -1;
//    }

    //one array version
    public int findJudge(int N, int[][] trust) {
        int[] degree = new int[N+1];
        for(int[] pair : trust){
            int a = pair[0];
            int b = pair[1];

            degree[a]--;
            degree[b]++;
        }

        for(int i=1; i<=N; i++){
            if(degree[i] == N-1)
                return i;
        }

        return -1;
    }
}
