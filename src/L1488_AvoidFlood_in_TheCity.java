import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class L1488_AvoidFlood_in_TheCity {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);

        //store the last day of rain over the lake
        Map<Integer, Integer> full = new HashMap();
        //store all the sunny days
        TreeSet<Integer> dry = new TreeSet();
        for (int i = 0; i < n; i++) {
            int lake = rains[i];
            if (lake > 0) {
                //check it the lake is full
                if (full.containsKey(lake)) {
                    Integer it = dry.higher(full.get(lake));
                    //find the sunny day right after last
                    //rainny day over this lake
                    if (it == null) return new int[]{};
                    //use that found sunny day
                    res[it] = lake;
                    //delete that sunny day from available set
                    dry.remove(it);
                }
                //if the lake is not full
                full.put(lake, i);
            }
            //if it is a sunny day
            else {
                dry.add(i);
                //temporarily fulfill with 1, if necessary
                // it will be overwrite
                res[i] = 1;
            }
        }
        return res;
    }
}
