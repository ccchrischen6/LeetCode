public class L91 {
    public int numDecodings(String s) {
        if (s==null || s.length()==0 || s.charAt(0)=='0') return 0;
        int len = s.length();
        int[] memo = new int[len+1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i=2; i<=len; i++){
            int first = Integer.valueOf(s.substring(i-1,i));
            int second = Integer.valueOf(s.substring(i-2,i));
            if (0<first && first<10) memo[i] += memo[i-1];
            if (9<second && second<27) memo[i] += memo[i-2];
        }
        return memo[len];
    }
}
