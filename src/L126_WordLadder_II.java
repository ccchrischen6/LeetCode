import java.util.*;

public class L126_WordLadder_II {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList();
        Set<String> dict = new HashSet();
        for (String s : wordList) dict.add(s);
        if (!dict.contains(endWord)) return ans;
        dict.remove(beginWord);
        //remove endWord from dict is necessary, see line x
        dict.remove(endWord);


        Map<String, Integer> steps = new HashMap();
        steps.put(beginWord, 1);
        Map<String, List<String>> parents = new HashMap();
        LinkedList<String> q = new LinkedList();
        q.offer(beginWord);


        int l = beginWord.length();
        int step = 0;
        boolean found = false;

        while (!q.isEmpty() && !found) {
            step++;
            for (int size = q.size(); size > 0; size--) {
                String p = q.poll();
                char[] chs = p.toCharArray();
                for (int i = 0; i < l; i++) {
                    char ch = p.charAt(i);
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (j == ch) continue;
                        chs[i] = j;
                        String w = new String(chs);
                        if (w.equals(endWord)) {
                            if (!parents.containsKey(w))
                                parents.put(w, new ArrayList());
                            parents.get(w).add(p);
                            found = true;
                        } else {
                            if (step < steps.getOrDefault(w, 0))
                                parents.get(w).add(p);
                        }

                        //if we do not remove endWord from the dist,
                        //the endWord would have two parent which are the same
                        if (!dict.contains(w)) continue;
                        dict.remove(w);
                        q.offer(w);
                        steps.put(w, steps.get(p) + 1);
                        if (!parents.containsKey(w))
                            parents.put(w, new ArrayList());
                        parents.get(w).add(p);
                    }
                    chs[i] = ch;
                }
            }
        }

        if (found) {
            List<String> curr = new ArrayList();
            curr.add(endWord);
            getPaths(endWord, beginWord, parents, curr, ans);
        }
        return ans;
    }


    private void getPaths(String word, String beginWord, Map<String, List<String>> parents,
                          List<String> curr, List<List<String>> ans) {
        if (word.equals(beginWord)) {
            ans.add(new ArrayList(curr));
            return;
        }

        for (String p : parents.get(word)) {
            curr.add(0, p);
            getPaths(p, beginWord, parents, curr, ans);
            curr.remove(0);
        }

    }
}



