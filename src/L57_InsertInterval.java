import java.util.LinkedList;
import java.util.List;

/**
 * Created by Chris Chen
 */
public class L57_InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals == null || intervals.length == 0){
            return new int[][]{newInterval};
        }

        List<int[]> list = new LinkedList();
        int n = intervals.length;
        int i=0;
        while(i<n && intervals[i][1] < newInterval[0]){
            list.add(intervals[i]);
            i++;
        }

        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        list.add(newInterval);

        while(i<n){
            list.add(intervals[i]);
            i++;
        }


        int len = list.size();
        int[][] res = new int[len][2];
        for(int j=0; j<len; j++){
            res[j] = list.get(j);
        }

        return res;
    }
}
