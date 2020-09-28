import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Chris Chen
 * sort
 * time: O(nlogn)
 * space: O(1)
 */
public class L252_MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0)
            return true;

        Collections.sort(Arrays.asList(intervals), new MyComparator());

        int n = intervals.length;
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] < intervals[i - 1][1])
                return false;
        }
        return true;
    }

    private class MyComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] a, int[] b) {
            return Integer.compare(a[0], b[0]);
        }
    }

}
