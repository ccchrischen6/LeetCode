import java.util.ArrayList;
import java.util.List;

public class L60 {
    public String getPermutation(int n, int k) {
        List<Integer> indices = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n+1];

        //build indices & factorial
        factorial[0] = 1;
        for (int i=1; i<=n; i++) {
            indices.add(i);
            factorial[i] = factorial[i-1]*i;
        }

        //convert k to index-k
        k--;

        for(int i=1; i<=n; i++){
            int index = k/factorial[n-i];
            sb.append(indices.get(index));
            indices.remove(index);
            k -= index*factorial[n-i];
        }
        return sb.toString();
    }
}
