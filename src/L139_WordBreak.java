import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        Set<String> set = new HashSet();
        for (String str : wordDict) set.add(str);
        int len = s.length();

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }


    /**
     * recursive with memo
     * time: O(n^2)
     * space: O(n)
     */
//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet();
//        for(String str : wordDict) set.add(str);
//        return helper(set, s, 0, new Boolean[s.length()]);
//    }
//
//    private boolean helper(Set<String> set, String s, int pos, Boolean[] memo){
//        if(pos == s.length()) return true;
//        //setting memo to be a Boolean[] rather than boolean[] is crucial
//        //Boolean[] has three state, null, true, and false while boolean[] only
//        //has two
//        if(memo[pos] != null) return memo[pos];
//        for(int i=pos+1; i<=s.length(); i++){
//            if(set.contains(s.substring(pos,i)) && helper(set, s, i, memo)){
//                memo[pos] = true;
//                return true;
//            }
//        }
//
//        memo[pos] = false;
//        return false;
//    }



    /**
     * BFS
     * time: O(n^2)
     * space: O(n)
     */

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet(wordDict);
//        int n = s.length();
//        boolean[] visited = new boolean[n];
//        Queue<Integer> q = new LinkedList();
//        q.offer(0);
//
//        while(!q.isEmpty()){
//            int start = q.poll();
//            if(!visited[start]){
//                for(int end=start+1; end<=n; end++){
//                    if(set.contains(s.substring(start,end))) {
//                        if(end == n) return true;
//                        q.offer(end);
//                    }
//
//                }
//                visited[start] = true;
//            }
//        }
//        return false;
//    }

    /**
     * dp, loop through wordDict
     * time: O(n*m), n: length of s, m: size of wordDict
     * space: O(n)
     */

//    public boolean wordBreak(String s, List<String> wordDict) {
//        Set<String> set = new HashSet(wordDict);
//        int n = s.length();
//        boolean[] dp = new boolean[n+1];
//        dp[0] = true;
//
//        for(int i=1; i<=n; i++){
//            for(String cur : set){
//                int len = cur.length();
//                if(i-len >= 0 && dp[i-len] && s.substring(i-len,i).equals(cur)){
//                    dp[i] = true;
//                    break;
//                }
//            }
//        }
//        return dp[n];
//    }
}
