public class L1513_Number_of_SubstringsWithOnly_1s {
    public int numSub(String s) {
        int k = 1000000007;
        int res = 0;
        int start = 0;
        int end = 0;
        int len = s.length();
        while (start < len) {
            while (start < len && s.charAt(start) == '0') {
                start++;
            }
            end = start;
            while (end < len && s.charAt(end) == '1') end++;
            res += (int) (helper((double) (end - start)) % k);
            start = end;

        }
        return res % k;
    }

    private double helper(double n) {
        return (1 + n) * n / 2;
    }
}
