import java.util.HashMap;
import java.util.Map;

public class L220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        Map<Long, Long> map = new HashMap();
        if (t < 0 || k <=0) return false;
        for (int i=0; i<nums.length; i++){
            long remappednum = (long) nums[i] - Integer.MIN_VALUE;
            long bucket = remappednum / ((long)t+1);
            if (map.containsKey(bucket) ||
                    (map.containsKey(bucket-1) && remappednum - map.get(bucket-1) <= t)
                        || (map.containsKey(bucket+1) && map.get(bucket+1) - remappednum <= t)
            ) {
                return true;
            }

            if (i >= k){
                long lastBucket = ((long) nums[i-k] - Integer.MIN_VALUE)/(t+1);
                map.remove(lastBucket);
            }
            map.put(bucket, remappednum);
        }
        return false;
    }
    public static void main(String[] args) {
        int[] n = new int[]{-1,2147483647};
        System.out.println(containsNearbyAlmostDuplicate(n, 1, 2147483647));
    }
}
