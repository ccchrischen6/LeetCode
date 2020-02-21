import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L501 {
    public int[] findMode(TreeNode root) {
        if(root==null) return new int[]{};
        List<Integer> list = new ArrayList<>();
        List<Integer> res = new ArrayList<Integer>();
        find(root,list);
        list.sort((a,b) -> a-b);
        int prev = list.get(0), modeCount=1, currCount=1;
        res.add(prev);
        for (int i=1; i< list.size(); i++){
            int curr = list.get(i);
            if (curr==prev) currCount++;
            else currCount=1;

            if (currCount==modeCount) res.add(curr);
            else if (currCount>modeCount){
                res.clear();
                res.add(curr);
                modeCount = currCount;
            }

            prev = curr;
        }
        int[] R = new int[res.size()];
        for(int i=0; i<res.size(); i++) R[i] = res.get(i);
        return R;
    }

    public void find(TreeNode root, List<Integer> list){
        if (root==null) return;
        list.add(root.val);
        find(root.left, list);
        find(root.right,list);
    }
}
