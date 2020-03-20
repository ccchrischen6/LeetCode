import java.util.ArrayList;
import java.util.List;

public class L89 {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList();
        ans.add(0);

        for(int i=0; i<n; i++){
            int add = 1 << i;
            for(int j=ans.size()-1; j>=0; j--){
                ans.add(ans.get(j) + add);
            }
        }
        return ans;
    }
}
