import java.util.ArrayList;
import java.util.List;

public class L131_PalindromePartitioning {
    /**
     * recursive
     * time: O(2^n)
     * space: O(n)
     */
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        helper(new ArrayList(), s, 0);
        return res;
    }

    private void helper(List<String> curList, String s, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList(curList));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (isValid(s, pos, i)) {
                curList.add(s.substring(pos, i + 1));
                helper(curList, s, i + 1);
                curList.remove(curList.size() - 1);

            }
        }
    }

    //[start, end]
    private boolean isValid(String s, int start, int end) {
        if (start >= end) return true;
        if (s.charAt(start) == s.charAt(end)) return isValid(s, start + 1, end - 1);
        else return false;
    }
}
