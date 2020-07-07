import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L139_WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return true;
        if (wordDict == null || wordDict.size() == 0) return false;
        Set<String> set = new HashSet();
        for (String str : wordDict) set.add(str);
        int len = s.length();

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];
    }
}
