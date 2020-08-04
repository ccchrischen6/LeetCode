import java.util.*;

/**
 * time: O(vlogv)
 * space: O(v)
 */
public class L1202_SmallestStringWithSwaps {
    Map<Integer, List<Integer>> g;
    boolean[] visited;
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        g = new HashMap(n);
        visited = new boolean[n];
        char[] sc = s.toCharArray();
        //generate the graph
        for(List<Integer> pair : pairs){
            int a = pair.get(0);
            int b = pair.get(1);
            if(!g.containsKey(a)) g.put(a, new ArrayList());
            if(!g.containsKey(b)) g.put(b, new ArrayList());
            g.get(a).add(b);
            g.get(b).add(a);
        }

        //loop through the sc
        for(int i=0; i<n; i++){
            if(!g.containsKey(i)) continue;
            List<Integer> idxs = new ArrayList();
            List<Character> chs = new ArrayList();

            dfs(sc, idxs, chs, i);
            Collections.sort(idxs);
            Collections.sort(chs);
            for(int j=0; j<idxs.size(); j++)
                sc[idxs.get(j)] = chs.get(j);

        }
        return new String(sc);


    }

    private void dfs(char[] sc, List<Integer> idxs, List<Character> chs, int cur){
        if(visited[cur]) return;
        visited[cur] = true;
        idxs.add(cur);
        chs.add(sc[cur]);
        List<Integer> neis = g.get(cur);
        for(int nei : neis) dfs(sc, idxs, chs, nei);
    }
}
