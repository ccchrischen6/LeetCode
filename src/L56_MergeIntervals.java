import java.util.*;

/**
 * Created by Chris Chen
 */
public class L56_MergeIntervals {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 0) return new int[][]{};
        Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        List<int[]> list = new ArrayList();
        int n = intervals.length;
        for(int i=0; i<n; i++){
            if(list.isEmpty()){
                list.add(intervals[i]);
                continue;
            }

            int[] last = list.get(list.size()-1);
            if(last[1] < intervals[i][0]){
                list.add(intervals[i]);
            }

            else if(last[1] < intervals[i][1]){
                list.get(list.size()-1)[1] = intervals[i][1];
            }
        }

        int len = list.size();
        int[][] res = new int[len][2];
        for(int i=0; i<len; i++){
            res[i] = list.get(i);
        }

        return res;
    }

    private class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }
}
