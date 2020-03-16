import java.util.ArrayList;
import java.util.List;

public class L22 {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList();
        helper(list, n, 0, 0, "");
        return list;
    }

    private void helper(List<String> list, int max, int open, int close, String curr){
        if(curr.length() >= max*2){
            list.add(curr);
        }

        if(open<max){
            helper(list, max, open+1, close, curr+"(");
        }

        if(close<open){
            helper(list, max, open, close+1, curr+")");
        }
    }
}
