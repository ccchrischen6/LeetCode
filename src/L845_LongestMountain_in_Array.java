public class L845_LongestMountain_in_Array {
    public int longestMountain(int[] A) {
        int start = 0;
        int n = A.length;
        int res = 0;

        while (start < n - 1) {
            boolean f1 = false;
            boolean f2 = false;
            int i = start;
            while (i + 1 < n && A[i + 1] > A[i]) {
                i++;
                f1 = true;
            }
            while (f1 && i + 1 < n && A[i + 1] < A[i]) {
                i++;
                f2 = true;
            }
            if (f1 && f2) {
                res = Math.max(res, i - start + 1);
                start = i;
            } else start = i + 1;
        }
        return res;
    }
}
