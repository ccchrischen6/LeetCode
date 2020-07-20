import java.util.*;

/**
 * recursive with memo
 * time: O(n^2 + 2^n + W)
 * space: O(2^n * n + n^2 + W)
 */
public class L140_Word_Break_II {
    Map<String,List<String>> memo = new HashMap();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet(wordDict);
        return helper(dict,s );
    }

    private List<String> helper(Set<String> dict, String s){
        if(memo.containsKey(s)) return memo.get(s);
        List<String> ans = new ArrayList();

        if(dict.contains(s)) ans.add(s);

        for(int j=1; j<=s.length(); j++){
            String right = s.substring(j);
            if(!dict.contains(right)) continue;
            String left = s.substring(0,j);
            List<String> left_ans = fusion(helper(dict, left), right);

            for(String str : left_ans) ans.add(str);
        }

        memo.put(s, ans);
        return ans;
    }

    private List<String> fusion(List<String> left, String right){
        List<String> res = new ArrayList();
        for(int i=0; i<left.size(); i++){
            res.add(left.get(i) + " " + right);
        }
        return res;
    }
}
