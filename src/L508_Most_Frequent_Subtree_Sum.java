import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L508_Most_Frequent_Subtree_Sum {
    int freq = 0;
    List<Integer> res = new ArrayList();
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[]{};
        Map<Integer, Integer> map = new HashMap();
        helper(root, map);
        int[] result = new int[res.size()];
        for(int i=0; i<res.size(); i++) result[i] = res.get(i);
        return result;
    }

    private int helper(TreeNode root, Map<Integer, Integer> map){
        if(root == null) return 0;
        int sum = root.val + helper(root.left, map) + helper(root.right, map);
        int curFreq = map.getOrDefault(sum, 0)+1;
        map.put(sum, curFreq);
        if(curFreq == freq) res.add(sum);
        else if(curFreq > freq){
            freq = curFreq;
            res.clear();
            res.add(sum);
        }
        return sum;

    }
}
