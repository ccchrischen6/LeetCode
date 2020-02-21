import java.util.ArrayList;
import java.util.List;

public class L17 {
    private String[] keys = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) return ans;
        dfs(ans, digits, "", 0);
        return ans;
    }

    private void dfs(List<String> ans, String digits, String prefix, int offset) {
        if (offset >= digits.length()) {
            ans.add(prefix);
            return;
        }

        String letters = keys[digits.charAt(offset) - '0'];


        for (int i = 0; i < letters.length(); i++) {
            dfs(ans, digits, prefix + letters.charAt(i), offset + 1);
        }

    }
}
