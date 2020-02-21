import java.util.Arrays;

public class L506 {
    public String[] findRelativeRanks(int[] nums) {
        if(nums==null || nums.length==0) return new String[]{""};
        String[] res = new String[nums.length];
        int[][] pairs = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }

        Arrays.sort(pairs, (a,b) -> b[0]-a[0]);
        for (int j=0; j<nums.length; j++){
            if (j==0) res[pairs[j][1]] = "Gold Medal";
            else if (j==1) res[pairs[j][1]] = "Silver Medal";
            else if (j==2) res[pairs[j][1]] = "Bronze Medal";
            else res[pairs[j][1]] = j + 1 + "";
        }

        return res;
    }
}
