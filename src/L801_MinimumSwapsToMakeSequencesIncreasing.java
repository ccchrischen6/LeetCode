import java.util.Arrays;

public class L801_MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
        int res = 0;
        int n = A.length;
        int[] keep = new int[n];
        int[] swap = new int[n];

        //it is the key
        Arrays.fill(keep, Integer.MAX_VALUE);
        Arrays.fill(swap, Integer.MAX_VALUE);

        //initialize the base case
        keep[0] = 0;
        swap[0] = 1;

        for(int i=1; i<n; i++){
            if(A[i] > A[i-1] && B[i] > B[i-1]) {
                keep[i] = keep[i-1];
                swap[i] = swap[i-1]+1;
            }

            if(A[i] > B[i-1] && B[i] > A[i-1]){
                keep[i] = Math.min(keep[i], swap[i-1]);
                swap[i] = Math.min(swap[i], keep[i-1]+1);
            }
        }
        return Math.min(keep[n-1], swap[n-1]);
    }
}
