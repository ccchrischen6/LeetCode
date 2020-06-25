import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L752_Open_the_Lock {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet();
        for (String s : deadends) set.add(s);
        if (set.contains("0000")) return -1;

        Queue<String> q = new LinkedList();
        q.offer("0000");
        int step = 0;

        while (!q.isEmpty()) {
            step++;
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                char[] chs = cur.toCharArray();
                for (int j = 0; j < 4; j++) {
                    char c = chs[j];
                    for (int k = -1; k <= 1; k += 2) {
                        chs[j] = (char) ((c - '0' + k + 10) % 10 + '0');
                        String ns = new String(chs);
                        if (ns.equals(target)) return step;
                        chs[j] = c;
                        if (set.contains(ns)) continue;
                        q.offer(ns);
                        set.add(ns);
                    }
                }
            }
        }
        return -1;
    }
    
    //bidirectional BFS
//    public int openLock(String[] deadends, String target) {
//        Set<String> set = new HashSet();
//        for(String s : deadends) set.add(s);
//        if(set.contains("0000")) return -1;
//        if(target.equals("0000")) return 0;
//
//        Set<String> s1 = new HashSet();
//        Set<String> s2 = new HashSet();
//        s1.add("0000");
//        s2.add(target);
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
//            for(String cur: s1){
//                char[] chs = cur.toCharArray();
//                for(int j=0; j<4; j++){
//                    char c = chs[j];
//                    for(int k=-1; k<=1; k+=2){
//                        chs[j] = (char) ((c-'0'+k+10)%10 + '0');
//                        String ns = new String(chs);
//                        chs[j] = c;
//                        if(s2.contains(ns)) return step;
//                        if(set.contains(ns)) continue;
//                        s.add(ns);
//                        s.add(ns);
//                        set.add(ns);
//
//                    }
//                }
//            }
//            s1 = s;
//        }
//        return -1;
//    }
}
