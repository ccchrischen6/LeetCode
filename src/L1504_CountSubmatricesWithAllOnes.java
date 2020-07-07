import java.util.Arrays;

/*
* basic solution
* time: O(M*M*N)
* space: O(N)
*
* https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed-Explanation-From-O(MNM)-to-O(MN)-by-using-Stack
*
* */
public class L1504_CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int M = mat.length;
        int N = mat[0].length;
        int res = 0;

        for (int up = 0; up < M; up++) {
            int[] h = new int[N];
            Arrays.fill(h, 1);
            for (int down = up; down < M; down++) {
                for (int i = 0; i < N; i++) {
                    h[i] = h[i] & mat[down][i];
                }
                res += count(h);
            }
        }

        return res;
    }

    private int count(int[] h) {
        int res = 0;
        int len = 0;
        for (int i = 0; i < h.length; i++) {
            len = h[i] == 0 ? 0 : len + 1;
            res += len;
        }
        return res;
    }
}
