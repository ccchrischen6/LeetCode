public class L926_FlipString_to_MonotoneIncreasing {
    public int minFlipsMonoIncr(String S) {
        int n = S.length();
        // # of flips converting digits from 1 to 0 before i+1
        int[] l = new int[n + 1];
        // # of flips converting digits from 0 to 1 after i-1
        int[] r = new int[n + 1];

        l[0] = S.charAt(0) - '0';
        r[n - 1] = '1' - S.charAt(n - 1);

        for (int i = 1; i < n; i++) {
            l[i] = l[i - 1] + S.charAt(i) - '0';
        }

        for (int i = n - 2; i >= 0; i--) {
            r[i] = r[i + 1] + '1' - S.charAt(i);
        }

        int ans = r[0];
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, l[i] + r[i + 1]);
        }
        return ans;
    }
}
