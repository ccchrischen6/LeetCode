import java.util.HashSet;
import java.util.Set;

/**
 * Created by Chris Chen
 */
public class L277_Find_the_Celebrity {
    /**
     * time: O(n*)
     * space: O(n)
     */
//    public int findCelebrity(int n) {
//        Set<Integer> set = new HashSet();
//        for(int i=0; i<n; i++) set.add(i);
//
//        for(int i=0; i<n; i++){
//            if(!set.contains(i)) continue;
//            for(int j=0; j<n; j++){
//                if(i==j) continue;
//                if(knows(i,j)){
//                    set.remove(i);
//                    break;
//                }
//                else{
//                    set.remove(j);
//                }
//            }
//
//        }
//
//        if(set.isEmpty()) return -1;
//
//        for(int candi : set){
//            int count = 0;
//            for(int i=0; i<n; i++){
//                if(knows(i,candi))
//                    count++;
//            }
//            if(count == n) return candi;
//        }
//
//        return -1;
//    }

    /**
     * one dimensional loop
     * time: O(n)
     * space: O(1)
     */
//    public int findCelebrity(int n) {
//        int candi = 0;
//        //for each loop, we remove one invalid candidate from the pool
//        for(int i=0; i<n; i++){
//            //if candi knows i, candi is invalid
//            //else i is invalid since candi does not know i
//            if(knows(candi,i)){
//                candi = i;
//            }
//        }
//
//        int count = 0;
//        for(int i=0; i<n; i++){
//            if(candi == i) continue;
//            if(knows(candi,i) || !knows(i,candi))
//                return -1;
//        }
//
//        return candi;
//    }
}
