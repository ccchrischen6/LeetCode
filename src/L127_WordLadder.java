import java.util.*;

public class L127_WordLadder {
    //simple BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet();
        for(String s : wordList) set.add(s);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList();
        q.offer(beginWord);
        int step = 0;
        while(!q.isEmpty()){
            step++;
            int size = q.size();
            for(int i=0; i<size; i++){
                String s = q.poll();
                char[] chs = s.toCharArray();
                for(int j=0; j<chs.length; j++){
                    char cur = chs[j];
                    for(char k='a'; k<='z'; k++){
                        if(k == cur) continue;
                        chs[j] = k;
                        String ns = new String(chs);
                        if(endWord.equals(ns)) return step+1;
                        if(set.contains(ns)){
                            set.remove(ns);
                            q.offer(ns);
                        }
                        chs[j] = cur;
                    }
                }
            }
        }
        return 0;
    }




    //bidirectional BFS
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> dict = new HashSet();
//        for(String s : wordList) dict.add(s);
//        if(!dict.contains(endWord)) return 0;
//
//        Set<String> s1 = new HashSet();
//        Set<String> s2 = new HashSet();
//        s1.add(beginWord);
//        s2.add(endWord);
//        int step = 0;
//
//        while(!s1.isEmpty() && !s2.isEmpty()){
//            step++;
//            if(s1.size() > s2.size()){
//                Set<String> temp = s1;
//                s1 = s2;
//                s2 = temp;
//            }
//
//            Set<String> s = new HashSet();
//
//            for(String str : s1){
//                char[] chs = str.toCharArray();
//                for(int i=0; i<chs.length; i++){
//                    char cur = chs[i];
//                    for(char ch='a'; ch<='z'; ch++){
//                        if(ch == cur) continue;
//                        chs[i] = ch;
//                        String ns = new String(chs);
//                        if(s2.contains(ns)) return step+1;
//                        if(!dict.contains(ns)) continue;
//                        dict.remove(ns);
//                        s.add(ns);
//                    }
//                    chs[i] = cur;
//                }
//                s1 = s;
//            }
//
//        }
//        return 0;
//    }
}
