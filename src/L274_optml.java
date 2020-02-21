import java.util.Arrays;

public class L274_optml {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0) return 0;
        int[] bucket = new int[n+1];
        for (int c : citations){
            if (c >= n){
                bucket[n]++;
            }
            else bucket[c]++;
        }

        int count = 0;
        for (int i=n; i>=0; i--){
            count += bucket[i];
            if (count >= i){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 1, 1, 5, 7};
        System.out.println(hIndex(x));
    }
}
