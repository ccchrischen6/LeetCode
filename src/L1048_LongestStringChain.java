import java.util.Arrays;

/**
 * dp
 * time: O(n^2)
 * space: O(n)
 */
public class L1048_LongestStringChain {
    public int longestStrChain(String[] words) {
        //sort the words from less length to more length
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int n = words.length;
        //dp array to track the maxLen for the current word
        int[] dp = new int[n];
        //initially every word has a maxLen 1
        Arrays.fill(dp, 1);
        int max = 1;

        //double for loop to traverse from left to right
        //j is subcase for i
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isValid(words[j], words[i])) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    //check if word_j can be modified to be word_i by adding ONE more letter
    private boolean isValid(String a, String b) {
        if (a.length() + 1 != b.length()) return false;
        int count = 0;
        for (int i = 0, j = 0; i < a.length() && j < b.length(); ) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                count++;
                j++;
            }
        }
        return count < 2;
    }
}
