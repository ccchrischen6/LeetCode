import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L818_RaceCar {
    //BFS with String memo
    public int racecar(int target) {
        Queue<Pair<Integer, Integer>> q = new LinkedList();
        //pair<pos, speed>
        q.offer(new Pair(0, 1));
        Set<String> visited = new HashSet();
        //initialize the visited set
        visited.add("0_1");
        visited.add("0_-1");
        int step = 0;

        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; i++) {
                Pair<Integer, Integer> pair = q.poll();
                int pos = pair.getKey();
                int speed = pair.getValue();

                //first condition
                int pos1 = pos + speed;
                int speed1 = speed * 2;
                if (pos1 == target) return step + 1;

                String key1 = pos1 + "_" + speed1;
                if (pos1 > 0 && !visited.contains(key1)) {
                    q.offer(new Pair(pos1, speed1));
                }

                //second condition
                int pos2 = pos;
                int speed2 = speed > 0 ? -1 : 1;
                String key2 = pos2 + "_" + speed2;
                if (!visited.contains(key2)) {
                    visited.add(key2);
                    q.offer(new Pair(pos2, speed2));
                }
            }
            step++;
        }

        return -1;
    }



    //BFS with String memo
//    public int racecar(int target) {
//        Queue<Pair<Integer,Integer>> q = new LinkedList();
//        q.offer(new Pair(0,1));
//        Set<Integer> visited = new HashSet();
//        visited.add(2);
//        visited.add(0);
//        int step = 0;
//
//        while(!q.isEmpty()){
//            int n = q.size();
//            for(int i=0; i<n; i++){
//                Pair<Integer,Integer> pair = q.poll();
//                int pos = pair.getKey();
//                int speed = pair.getValue();
//
//                //first condition
//                int pos1 = pos+speed;
//                int speed1 = speed*2;
//                if(pos1 == target) return step+1;
//                if(pos1 > 0){
//                    q.offer(new Pair(pos1, speed1));
//                }
//
//                //second condition
//                int pos2 = pos;
//                int speed2 = speed > 0 ? -1 : 1;
//                int key2 = pos2<<2 | (speed2+1);
//                if(!visited.contains(key2)){
//                    visited.add(key2);
//                    q.offer(new Pair(pos2,speed2));
//                }
//            }
//            step++;
//        }
//
//        return -1;
//    }
}
