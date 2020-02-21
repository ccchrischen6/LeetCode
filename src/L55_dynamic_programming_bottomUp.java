enum Index {
    GOOD, UNKNOWN
}

public class L55_dynamic_programming_bottomUp {
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 0) return true;
        Index[] memo = new Index[n];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[n - 1] = Index.GOOD;

        for (int i = n - 2; i >= 0; i--) {
            int furthest = Math.min(nums[i] + i, n - 1);
            for (int j = i + 1; j <= furthest; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
                System.out.println(j);
            }

        }
        return memo[0] == Index.GOOD;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }
}

