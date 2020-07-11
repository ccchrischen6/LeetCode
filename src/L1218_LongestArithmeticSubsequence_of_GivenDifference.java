import java.util.HashMap;
import java.util.Map;

public class L1218_LongestArithmeticSubsequence_of_GivenDifference {
    public int longestSubsequence(int[] arr, int diff) {
        Map<Integer, Integer> map = new HashMap();
        map.put(arr[0], 1);
        int n = arr.length;
        int max = 1;

        for (int i = 0; i < n; i++) {
            if (map.containsKey(arr[i] - diff)) {
                int v = map.get(arr[i] - diff) + 1;
                map.put(arr[i], v);
                max = Math.max(max, v);
            } else map.put(arr[i], 1);
        }

        return max;

    }
}
